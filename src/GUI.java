import javax.swing.*;
import java.awt.*;

public class GUI {

    private JFrame window;
    private JLabel writting;
    private JButton[] fields = new JButton[9];
    private JLabel result;
    private String level;

    public void open() {
        window = new JFrame("Tic-Tac-Toe");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Style.bacgrand);
        showToLevel();

        window.setVisible(true);
    }

    public void showToLevel() {
        window.getContentPane().removeAll();

        window.setLayout(new BorderLayout());

        writting = new JLabel("Wybierz poziom trudności: ", SwingConstants.CENTER);
        Style.styl_Writting(writting);

        writting.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        JButton easy = new JButton("Łatwy");
        Style.styl_Easy(easy);
        easy.setPreferredSize(new Dimension(250, 60));

        JButton normal = new JButton("Normalny");
        Style.styl_Normal(normal);
        normal.setPreferredSize(new Dimension(250, 60));

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        JPanel innerButtonPanel = new JPanel();
        innerButtonPanel.setOpaque(false);
        innerButtonPanel.add(easy);
        innerButtonPanel.add(Box.createHorizontalStrut(20));
        innerButtonPanel.add(normal);

        buttonPanel.add(innerButtonPanel);

        window.add(writting, BorderLayout.NORTH);
        window.add(buttonPanel, BorderLayout.CENTER);

        easy.addActionListener(e -> {
            level = "Łatwy";
            showToStart();
        });

        normal.addActionListener(e -> {
            level = "Normalny";
            showToStart();
        });

        window.revalidate();
        window.repaint();
    }


    public void showToStart() {
        window.getContentPane().removeAll();

        window.setLayout(new BorderLayout());

        writting = new JLabel("Wybrany poziom trudności: " + level , SwingConstants.CENTER);
        Style.styl_Writting(writting);

        writting.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        JButton start = new JButton("Rozpocznij gre");
        Style.styl_Start(start);
        start.setPreferredSize(new Dimension(450, 60));

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.add(start);

        window.add(writting, BorderLayout.NORTH);
        window.add(buttonPanel, BorderLayout.CENTER);

        start.addActionListener(e -> {
            showToBoard();
        });

        window.revalidate();
        window.repaint();
    }

    public void showToBoard(){
        window.getContentPane().removeAll();
        window.setLayout(new BorderLayout());

        // 1. Tworzymy nowy panel na samą górę
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);


        JLabel titleLabel = new JLabel("Tic-Tac-Toe");
        Style.styl_Writting(titleLabel);


        JLabel levelLabel = new JLabel("Poziom: " + level);
        Style.styl_Writting(levelLabel);

        levelLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.add(levelLabel, BorderLayout.EAST);

        window.add(topPanel, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(3, 3));
        window.add(center, BorderLayout.CENTER);

        JPanel side = new JPanel(new GridLayout(3, 1));
        side.setPreferredSize(new Dimension(250, 600));
        side.setBackground(Style.bacgrand);

        writting = new JLabel(" Wynik ", SwingConstants.CENTER);
        Style.styl_Writting(writting);

        result = new JLabel(" X: 0 VS O: 0 ", SwingConstants.CENTER);
        Style.styl_Writting(result);

        JButton rest = new JButton("Reset");
        Style.styl_Reset(rest);

        rest.setPreferredSize(new Dimension(220, 120));

        JPanel restPanel = new JPanel(new GridBagLayout());
        restPanel.setOpaque(false);
        restPanel.add(rest);

        side.add(writting);
        side.add(result);

        side.add(restPanel);

        window.add(side, BorderLayout.EAST);

        Logic gameLogic = new Logic(writting, fields, result, level);

        for (int i = 0; i < 9; i++) {
            fields[i] = new JButton("");
            center.add(fields[i]);
            Style.stylBord(fields[i]);
            fields[i].addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                gameLogic.playerMove(clickedButton);
            });
        }

        rest.addActionListener(e -> {
            gameLogic.reset();
        });

        window.revalidate();
        window.repaint();

    }
}