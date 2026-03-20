import javax.swing.JButton;
import java.util.Random;

public class LevelEasy {

    public int getMove(JButton[] fields) {
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