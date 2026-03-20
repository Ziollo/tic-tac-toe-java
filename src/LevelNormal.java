import javax.swing.JButton;
import java.util.Random;

public class LevelNormal {

    public int getMove(JButton[] fields) {
        String[] points = new String[9];
        for (int i = 0; i < 9; i++) {
            points[i] = fields[i].getText();
        }

        int[][] winIdx = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int i = 0; i < winIdx.length; i++) {
            int number_O = 0;
            int IDX = -1;
            for (int j = 0; j < winIdx[i].length; j++) {
                int area = winIdx[i][j];
                if (points[area].equals("O")) {
                    number_O++;
                } else if (points[area].equals("")) {
                    IDX = area;
                }
            }
            if (number_O == 2 && IDX != -1) {
                return IDX;
            }
        }

        for (int i = 0; i < winIdx.length; i++) {
            int number_X = 0;
            int IDX = -1;
            for (int j = 0; j < winIdx[i].length; j++) {
                int area = winIdx[i][j];
                if (points[area].equals("X")) {
                    number_X++;
                } else if (points[area].equals("")) {
                    IDX = area;
                }
            }
            if (number_X == 2 && IDX != -1) {
                return IDX;
            }
        }

        Random rand = new Random();
        boolean free = false;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().equals("")) {
                free = true;
                break;
            }
        }

        if (free) {
            while (true) {
                int x = rand.nextInt(fields.length);
                if (fields[x].getText().equals("")) {
                    return x;
                }
            }
        }

        return -1;
    }
}