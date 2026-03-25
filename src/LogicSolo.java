import javax.swing.*;

public class LogicSolo extends Logic {

    public LogicSolo(JLabel writting, JButton[] fields, JLabel p1ScoreLabel, JLabel p2ScoreLabel, JLabel drawScoreLabel, String level, String player1Name, String player2Name) {
        super(writting, fields, p1ScoreLabel, p2ScoreLabel, drawScoreLabel, level, player1Name, "Komputer");
    }

    public void computerMove() {
        if (!isGameActive) return;

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

            if (!judge()) {
                writting.setText("Ruch: " + player1Name);
            }
        }
    }

    @Override
    public void playerMove(JButton click){
        if (click.getText().equals("") && isGameActive){
            click.setText("X");
            click.setForeground(Style.color_X);
            if(!judge()){
                writting.setText("Ruch komputera....");
                computerMove();
            }
        }
    }
}