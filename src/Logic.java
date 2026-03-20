import javax.swing.*;

public class Logic {

    private JLabel writting;
    private JButton[] fields;
    private JLabel result;
    private String level;
    private boolean movementPlayer;
    private boolean movementComputer;

    private int pointsX = 0;
    private int pointsO = 0;

    public Logic(JLabel writting, JButton[] fields, JLabel result, String level) {
        this.writting = writting;
        this.fields = fields;
        this.result = result;
        this.level = level;

        this.movementPlayer = true;
        this.movementComputer = true;
    }

    public void playerMove(JButton click) {
        if (click.getText().equals("") && movementPlayer) {
            click.setText("X");
            click.setForeground(Style.color_X);


            if (!judge()) {
                writting.setText("Ruch komputera....");
                movementComputer = true;
                movementPlayer = false;
                computerMove();
            }
        }
    }

    public void computerMove() {
        if (!movementComputer) return;

        int chosenMove = -1;

        if (level.equals("Łatwy")) {
            LevelEasy easy = new LevelEasy();
            chosenMove = easy.getMove(fields);
        } else if (level.equals("Normalny")) {
            LevelNormal normal = new LevelNormal();
            chosenMove = normal.getMove(fields);
        }

        if (chosenMove != -1) {
            fields[chosenMove].setText("O");
            fields[chosenMove].setForeground(Style.color_O);
            movementComputer = false;

            if (!judge()) {
                writting.setText("Ruch Gracza....");
                movementPlayer = true;
            }
        }
    }

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
            movementPlayer = false;
            movementComputer = false;
            return true;
        }
        return false;
    }

    public void stopGame(String win) {
        writting.setText("Wygrał: " + win + "!!");
        movementPlayer = false;
        movementComputer = false;

        if (win.equals("X")) {
            pointsX++;
        } else if (win.equals("O")) {
            pointsO++;
        }
        result.setText("X: " + pointsX + " | O: " + pointsO);
    }

    public void reset() {
        for (int i = 0; i < fields.length; i++) {
            fields[i].setText("");
        }

        movementPlayer = true;
        movementComputer = false;
        writting.setText("Twój ruch!");
    }
}