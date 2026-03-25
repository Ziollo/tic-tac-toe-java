import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Style {
    // stylizacja dla wielu elementów
    public static final Color color_X = new Color(51, 154, 240);
    public static final Color color_O = new Color(255, 107, 107);
    public static final Color text_color = new Color(255, 255, 255);
    public static final Dimension button_size = new Dimension(300, 120);
    public static final Font button_font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    public static final Color mode_color = new Color(10, 17, 46);

    // kolor tła oraz wielkość
    public static final Color bacgrand = new Color(35, 52, 94);
    public static final Dimension border_size = new Dimension(1200, 800);

    // stylizacja nagłówka
    public static final Color heder_color = new Color(30, 48, 117);
    public static final Font heder_font = new Font(Font.SANS_SERIF, Font.BOLD, 30);
    public static final Dimension heder_size = new Dimension(1200, 100);

    // stylizacja mode
    public static final Font mode_font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    public static final Dimension mode_size = new Dimension(500, 85);

    // stylizacja mode_button
    public static final Color mode_button_color = new Color(0, 74, 173);

    // stylizacja przycisku start
    public static final Color start_color = new Color(0, 74, 173);
    public static final Dimension start_size = new Dimension(470, 80);

    // stylizacja przycisków level
    public static final Color easy_color = new Color(32, 201, 151);
    public static final Color normal_color = new Color(245, 166, 35);

    // stylizacja przycisku menu i reset
    public static final Color button_color = new Color(37, 54, 98);
    public static final Dimension button_size_2 = new Dimension(240, 60);

    // stylizacja paneli lvl i reset
    public static final Color mode_lvl_rest_color = new Color(51, 72, 101, 255);
    public static final Dimension mode_lvl_rest_size = new Dimension(150, 80);

    // stylizacja paneli gracz
    public static final Color mode_player_color = new Color(10, 17, 46, 255);
    public static final Dimension mode_player_size = new Dimension(150, 210);

    // stylizacja planszy (Dark Mode)
    public static final Color bord = new Color(35, 52, 94);
    public static final Dimension bord_size = new Dimension(550, 500);
    public static final Font board_font = new Font(Font.SANS_SERIF, Font.BOLD, 100);
    public static final Font player_name_font = new Font(Font.SANS_SERIF, Font.BOLD, 25);

    // stylizacja kafelków
    public static final Color tile_color = new Color(45, 65, 115);
    public static final Color tile_hover_color = new Color(60, 85, 145);
    public static final Color tile_border_color = new Color(70, 100, 180);


    // ==========================================
    // METODY STYLIZUJĄCE
    // ==========================================

    public static void styleModeBuutton(JButton button) {
        button.setBackground(mode_button_color);
        button.setForeground(text_color);
        button.setFont(button_font);
        button.setPreferredSize(button_size);
        button.setFocusPainted(false);
        // DLA MAC OS
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    public static void styleStartButton(JButton button) {
        button.setBackground(start_color);
        button.setForeground(text_color);
        button.setFont(button_font);
        button.setPreferredSize(start_size);
        button.setFocusPainted(false);
        // DLA MAC OS
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    public static void easy_button_style(JButton button) {
        button.setBackground(easy_color);
        button.setForeground(text_color);
        button.setFont(button_font);
        button.setPreferredSize(button_size);
        button.setFocusPainted(false);
        // DLA MAC OS
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    public static void normla_button_style(JButton button) {
        button.setBackground(normal_color);
        button.setForeground(text_color);
        button.setFont(button_font);
        button.setPreferredSize(button_size);
        button.setFocusPainted(false);
        // DLA MAC OS
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    public static void button_style(JButton button) {
        button.setBackground(button_color);
        button.setForeground(text_color);
        button.setFont(button_font);
        button.setPreferredSize(button_size_2);
        button.setFocusPainted(false);
        // DLA MAC OS
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    public static void text_style(JTextField field) {
        field.setBackground(mode_color);
        field.setForeground(text_color);
        field.setFont(button_font);
        field.setPreferredSize(button_size);
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setBorder(BorderFactory.createEmptyBorder());
        // DLA MAC OS
        field.setOpaque(true);
    }

    public static void styleBoardTile(JButton button) {
        button.setFont(board_font);
        button.setBackground(tile_color);
        button.setFocusPainted(false);

        // DLA MAC OS
        button.setOpaque(true);

        button.setBorder(BorderFactory.createLineBorder(tile_border_color, 2));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (button.getIcon() == null && button.getText().isEmpty()) {
                    button.setBackground(tile_hover_color);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(tile_color);
            }
        });
    }
}