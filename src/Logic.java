import javax.swing.*;

public abstract class Logic {

    protected JLabel writting;
    protected JButton[] fields;

    protected JLabel p1ScoreLabel;
    protected JLabel p2ScoreLabel;
    protected JLabel drawScoreLabel;

    protected String level;
    protected boolean isXTurn;
    protected boolean isGameActive;

    protected String player1Name;
    protected String player2Name;

    protected int pointsX = 0;
    protected int pointsO = 0;
    protected int pointsDraw = 0; // Dodano zliczanie remisów

    public Logic(JLabel writting, JButton[] fields, JLabel p1ScoreLabel, JLabel p2ScoreLabel, JLabel drawScoreLabel, String level, String player1Name, String player2Name) {
        this.writting = writting;
        this.fields = fields;
        this.p1ScoreLabel = p1ScoreLabel;
        this.p2ScoreLabel = p2ScoreLabel;
        this.drawScoreLabel = drawScoreLabel;
        this.level = level;

        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.isXTurn = true;
        this.isGameActive = true;
    }

    public abstract void playerMove(JButton click);

    public boolean judge() {
        String[] points = new String[9];
        for (int i = 0; i < 9; i++) {
            points[i] = fields[i].getText();
        }

        int[][] winIdx = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for (int i = 0; i < winIdx.length; i++) {
            int[] line = winIdx[i];
            if (!points[line[0]].equals("")
                    && points[line[0]].equals(points[line[1]])
                    && points[line[0]].equals(points[line[2]])) {
                stopGame(points[line[0]]);
                return true;
            }
        }

        boolean remis = true;
        for (int i = 0; i < points.length; i++) {
            if (points[i].equals("")) {
                remis = false;
            }
        }
        if (remis) {
            writting.setText("Remis!");
            pointsDraw++;
            drawScoreLabel.setText("Remisy: " + pointsDraw);
            isGameActive = false;
            return true;
        }
        return false;
    }

    public void stopGame(String win) {
        isGameActive = false;
        if (win.equals("X")) {
            writting.setText("Wygrał: " + player1Name + "!!");
            pointsX++;
            p1ScoreLabel.setText(String.valueOf(pointsX));
        } else if (win.equals("O")) {
            writting.setText("Wygrał: " + player2Name + "!!");
            pointsO++;
            p2ScoreLabel.setText(String.valueOf(pointsO));
        }
    }

    public void reset() {
        for (int i = 0; i < fields.length; i++) {
            fields[i].setText("");
        }

        isXTurn = true;
        isGameActive = true;
        writting.setText("Ruch: " + player1Name);
    }
}