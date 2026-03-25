import javax.swing.*;

public class MoveToPlayer extends Logic {

    public MoveToPlayer(JLabel writting, JButton[] fields, JLabel p1ScoreLabel, JLabel p2ScoreLabel, JLabel drawScoreLabel, String level, String player1Name, String player2Name){
        super(writting, fields, p1ScoreLabel, p2ScoreLabel, drawScoreLabel, level, player1Name, player2Name);
    }

    @Override
    public void playerMove(JButton click){
        if (click.getText().equals("") && isGameActive){
            if (isXTurn){
                click.setText("X");
                click.setForeground(Style.color_X);
            } else  {
                click.setText("O");
                click.setForeground(Style.color_O);
            }
            if (!judge()){
                isXTurn = !isXTurn;
                if (isXTurn){
                    writting.setText("Ruch: " + player1Name);
                } else {
                    writting.setText("Ruch: " + player2Name);
                }
            }
        }
    }
}