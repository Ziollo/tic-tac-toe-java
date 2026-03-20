import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Style {

    public static final Color bacgrand = new Color(24,24,27); // główny kolor tła

    public static final Color color_O = new Color(255, 107, 107);
    public static final Color color_X = new Color(51, 154, 240);

    // wygląd napisów
    public static final Font headerFont = new Font("Arial", Font.BOLD, 30);
    public static final EmptyBorder headerPadding = new EmptyBorder(20, 0, 20, 0);
    public static final Color text = new Color(255, 255, 255);

    public static void styl_Writting(JLabel label){
        label.setFont(Style.headerFont);
        label.setBorder(Style.headerPadding);
        label.setForeground(Style.text);
    }

    // wygląd planszy
    public static final Color bord = new Color(39, 39, 42);
    public static final Font bord_font = new Font("Arial", Font.BOLD, 100);

    public static void stylBord(JButton button) {
        button.setFont(bord_font);
        button.setBackground(bord);
        button.setForeground(Color.WHITE); // Kolor X i O zanim zostaną przypisane specyficzne kolory
        button.setFocusPainted(false);

        // dla MAC OS
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(true);

        button.setBorder(new LineBorder(new Color(63, 63, 70), 2));
    }

    // wygląd przycisków
    public static final Color level_Easy = new Color(34, 202, 109, 211);
    public static final Color level_Normal = new Color(218, 79, 37, 211);
    public static final Font leve_Font = new Font("Arial", Font.BOLD, 30);

    public static final Color start_color = new Color(13, 204, 216, 255);
    public static final Font start_Font = new Font("Arial", Font.BOLD, 40);
    public static final Color start = new Color(99, 102, 241, 60);

    public static final Color reset_color = new Color(0, 0, 0, 255);
    public static final Font reset_Font = new Font("Arial", Font.BOLD, 40);
    public static final Color reset = new Color(239, 68, 68);

    public static void styl_Easy(JButton button) {
        button.setFont(leve_Font);
        button.setBackground(level_Easy);
        button.setFocusPainted(false);
        button.setMargin(new Insets(20, 30, 20, 35));
        // dla MAC OS
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    public static void styl_Normal(JButton button) {
        button.setFont(leve_Font);
        button.setBackground(level_Normal);
        button.setFocusPainted(false);
        button.setMargin(new Insets(20, 30, 20, 35));
        // dla MAC OS
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    public static void styl_Start(JButton button) {
        button.setForeground(start_color);
        button.setFont(start_Font);
        button.setBackground(start);
        button.setFocusPainted(false);
        button.setMargin(new Insets(20, 30, 20, 35));
        // dla MAC OS
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    public static void styl_Reset(JButton button) {
        button.setForeground(reset_color);
        button.setFont(reset_Font);
        button.setBackground(reset);
        button.setFocusPainted(false);
        // dla MAC OS
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }
}