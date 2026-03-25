import javax.swing.*;
import java.awt.*;

public class GUI {

    private JFrame window;
    private JLabel writting;
    private JLabel drawLabel;
    private JButton[] fields = new JButton[9];
    private String level;
    private String player1Name = "Gracz 1";
    private String player2Name = "Gracz 2";
    private JLabel p1ScoreLabel;
    private JLabel p2ScoreLabel;

    //  GŁÓWNE OKNA
    public void open(){
        window = new JFrame("TIC-TAC-TOE"); // Tworzy okno z tytułem
        window.setSize(Style.border_size); // Ustawia rozmiar z klasy Style
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Wyłącza program po kliknięciu X
        window.getContentPane().setBackground(Style.bacgrand); // Ustawia kolor tła
        window.setLocationRelativeTo(null); // Wyśrodkowuje okno na monitorze

        showToMode(); // Przechodzi do pierwszego ekranu
        window.setVisible(true); // Wyświetla okno na ekranie
    }

    //  ELEMENT:  NAGŁÓWKA
    private JPanel Heder(){
        // rozmiar i kolor
        JPanel heder = new JPanel(new BorderLayout());
        heder.setBackground(Style.heder_color);
        heder.setPreferredSize(Style.heder_size);

        // text wewnątrz nagłówka
        JLabel title = new JLabel("TIC-TAC-TOE", SwingConstants.CENTER);
        title.setFont(Style.heder_font);
        title.setForeground(Style.text_color);
        heder.add(title, BorderLayout.CENTER);

        return heder;
    }

    // ELEMENT: POMOCNICZY PANEL TEKSTOWY
    private JPanel TextPanel(String text){
        JPanel Panel = new JPanel(new BorderLayout());
        Panel.setBackground(Style.mode_color);
        Panel.setPreferredSize(Style.mode_size);

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(Style.mode_font);
        label.setForeground(Style.text_color);
        Panel.add(label, BorderLayout.CENTER);

        return Panel;
    }

    // EKRAN 1: WYBÓR TRYBU (SOLO / DUO)
    public void showToMode(){
        window.getContentPane().removeAll(); // Czyści okno
        window.setLayout(new BorderLayout());

        window.add(Heder(), BorderLayout.NORTH); // Dodaje nagłówek na górę

        JPanel centerPanel = new JPanel(new GridBagLayout()); // Siatka na środku
        centerPanel.setBackground(Style.bacgrand);

        // "Wybierz tryb gry"
        JPanel mode_panel = TextPanel("Wybierz tryb gry");

        GridBagConstraints net = new GridBagConstraints();
        net.gridx = 0;
        net.gridy = 0;
        net.gridwidth = 2;
        net.insets = new Insets(0, 0, 60, 0);
        centerPanel.add(mode_panel, net);

        // 2. Przyciski wyboru trybu
        JButton solo = new JButton("Solo");
        Style.styleModeBuutton(solo);

        JButton duo = new JButton("Duo");
        Style.styleModeBuutton(duo);

        // Pozycjonowanie przycisku "Solo" po lewej
        net.gridx = 0;
        net.gridy = 1;
        net.gridwidth = 1;
        net.insets = new Insets(0, 0, 0, 40);
        centerPanel.add(solo, net);

        // Pozycjonowanie przycisku "Duo" po prawej
        net.gridx = 1;
        net.insets = new Insets(0, 40, 0, 0);
        centerPanel.add(duo, net);

        window.add(centerPanel, BorderLayout.CENTER); // Wrzuć wszystko na środek ekranu

        // Akcje po kliknięciu przycisków
        solo.addActionListener(e -> {
            showToLevel();
        });
        duo.addActionListener(e -> {
            level = "Duo";
            showToStart();
        });

        window.revalidate();
        window.repaint();
    }

    // WYBÓR POZIOMU TRUDNOŚCI (Tylko dla trybu Solo)
    public void showToLevel(){
        window.getContentPane().removeAll();
        window.setLayout(new BorderLayout());

        window.add(Heder(), BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Style.bacgrand);

        JPanel mode_panel = TextPanel("Wybierz poziom trudności");

        GridBagConstraints net = new GridBagConstraints();
        net.gridx = 0;
        net.gridy = 0;
        net.gridwidth = 2;
        net.insets = new Insets(0, 0, 60, 0);
        centerPanel.add(mode_panel, net);

        // przyciski wyboru poziomu
        JButton easy = new JButton("Łatwy");
        Style.easy_button_style(easy);

        JButton normal = new JButton("Normalny");
        Style.normla_button_style(normal);

        // Pozycjonowanie przycisku
        net.gridx = 0;
        net.gridy = 1;
        net.gridwidth = 1;
        net.insets = new Insets(0, 0, 40, 40);
        centerPanel.add(easy, net);

        // Pozycjonowanie przycisku
        net.gridx = 1;
        net.insets = new Insets(0, 40, 40, 0);
        centerPanel.add(normal, net);

        window.add(centerPanel, BorderLayout.CENTER);


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

    // WPISYWANIE IMION GRACZY I START GRY
    public void showToStart(){
        window.getContentPane().removeAll();
        window.setLayout(new BorderLayout());

        window.add(Heder(), BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Style.bacgrand);

        //  informaccja o wybranym wcześniej trybie/poziomie
        JPanel mode_panel = TextPanel("Wybrany pozim: " + level);

        GridBagConstraints net = new GridBagConstraints();
        net.gridx = 0;
        net.gridy = 0;
        net.gridwidth = 2;
        net.insets = new Insets(0, 0, 60, 0);
        centerPanel.add(mode_panel, net);

        //panel do wpisania tekstu (okienka na imiona)
        JTextField Player1 = new JTextField("Gracz 1");
        Style.text_style(Player1);

        JTextField Player2 = new JTextField("Gracz 2");
        Style.text_style(Player2);

        // Przycisk "Rozpocznij gre"
        JButton start = new JButton("Rozpocznij gre");
        Style.styleStartButton(start);

        net.gridx = 1;
        net.gridy = 1;
        net.gridwidth = 1;
        net.insets = new Insets(0, 0, 40, 0);

        if (level.equals("Duo")) {
            net.gridx = 0;
            net.insets = new Insets(0, 0, 40, 40);
            centerPanel.add(Player1, net); // Pole Gracza 1 po lewej

            net.gridx = 1;
            net.insets = new Insets(0, 40, 40, 0);
            centerPanel.add(Player2, net); // Pole Gracza 2 po prawej
        } else {
            centerPanel.add(Player1, net); // Tylko pole Gracza 1 na środku
        }

        // Dodanie przycisku start na dole
        net.gridx = 0;
        net.gridy = 2;
        net.gridwidth = 2;
        net.insets = new Insets(40, 0, 0, 0);
        centerPanel.add(start, net);

        window.add(centerPanel, BorderLayout.CENTER);

        start.addActionListener(e -> {
            player1Name =  Player1.getText();
            if (level.equals("Duo")) {
                player2Name =  Player2.getText();
            }
            showToBoard();
        });

        window.revalidate();
        window.repaint();
    }

    // PANEL BOCZNYCH (GRACZY) ---
    private JPanel createPlayerPanel(String playerName, String iconPath, JLabel scoreLabel) {
        // Zwraca gotowy, pionowy panel z Ikoną -> Imieniem -> Wynikiem gracza
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Style.mode_player_color);
        panel.setPreferredSize(Style.mode_player_size);

        JLabel imageLabel = new JLabel(new ImageIcon(iconPath));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel nameLabel = new JLabel(playerName, SwingConstants.CENTER);
        nameLabel.setFont(Style.mode_font);
        nameLabel.setForeground(Style.text_color);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(20));
        panel.add(imageLabel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(scoreLabel);

        return panel;
    }

    //  METODA POMOCNICZA: GENERATOR MAŁYCH PANELI (TRYB/REMIS)
    private JPanel createInfoPanel(String topText, Component centerComponent) {
        // Zwraca gotowy mały prostokąt z nagłówkiem i informacją w środku
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Style.mode_lvl_rest_color);
        panel.setPreferredSize(Style.mode_lvl_rest_size);

        if (topText != null && !topText.isEmpty()) {
            JLabel topLabel = new JLabel(topText, SwingConstants.CENTER);
            topLabel.setFont(Style.mode_font);
            topLabel.setForeground(Style.text_color);
            panel.add(topLabel, BorderLayout.NORTH);
        }

        panel.add(centerComponent, BorderLayout.CENTER);
        return panel;
    }

    //  GŁÓWNA PLANSZA GRY
    public void showToBoard(){
        window.getContentPane().removeAll();
        window.setLayout(new BorderLayout());

        // Inicjalizacja głównych etykiet z tekstami i zerowanie wyników
        writting = new JLabel("Kolej gracza: " + player1Name, SwingConstants.CENTER);
        writting.setFont(Style.player_name_font);
        writting.setForeground(Style.text_color);

        drawLabel = new JLabel("0", SwingConstants.CENTER);
        drawLabel.setFont(Style.player_name_font);
        drawLabel.setForeground(Style.text_color);

        p1ScoreLabel = new JLabel("0", SwingConstants.CENTER);
        p1ScoreLabel.setFont(Style.player_name_font);
        p1ScoreLabel.setForeground(Style.text_color);

        p2ScoreLabel = new JLabel("0", SwingConstants.CENTER);
        p2ScoreLabel.setFont(Style.player_name_font);
        p2ScoreLabel.setForeground(Style.text_color);

        // ==========================================
        // GÓRNE MENU (Nagłówek, Menu, Reset)
        // pasek na samej górze ekranu gry z dwoma przyciskami
        // ==========================================
        JPanel myHeder = Heder();
        myHeder.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton menu = new JButton("MENU"); // Przycisk wyjścia do menu
        Style.button_style(menu);
        menu.addActionListener(e -> showToMode());

        JButton reset = new JButton("Reset"); // Przycisk restartu planszy
        Style.button_style(reset);

        myHeder.add(menu, BorderLayout.WEST); // Menu idzie na lewo
        myHeder.add(reset, BorderLayout.EAST); // Reset idzie na prawo
        window.add(myHeder, BorderLayout.NORTH);

        // ==========================================
        // GŁÓWNY PANEL (Środek okna z siatką i wszystkimi elementami)
        // ==========================================
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Style.bacgrand);
        GridBagConstraints net = new GridBagConstraints();

        // LOGIKA GRY: Inicjowanie klasy odpowiedzialnej za zasady (Solo vs Duo)
        Logic gameLogic;
        if (level.equalsIgnoreCase("Duo")) {
            gameLogic = new MoveToPlayer(writting, fields, p1ScoreLabel, p2ScoreLabel, drawLabel, level, player1Name, player2Name);
        } else {
            gameLogic = new LogicSolo(writting, fields, p1ScoreLabel, p2ScoreLabel, drawLabel, level, player1Name, "Komputer");
        }

        // 1. MAŁY PANEL: POZIOM / TRYB (Generuje się w LEWYM GÓRNYM rogu obszaru gry)
        String info = level.equals("Duo") ? "Tryb:<br>" + level : "Poziom:<br>" + level;
        JLabel levelLabel = new JLabel("<html><center>" + info + "</center></html>", SwingConstants.CENTER);
        levelLabel.setFont(Style.mode_font);
        levelLabel.setForeground(Style.text_color);

        JPanel level_mode = createInfoPanel(null, levelLabel);

        net.gridx = 0; net.gridy = 0; net.gridwidth = 1; net.weightx = 1.0; net.weighty = 1.0;
        net.anchor = GridBagConstraints.NORTHWEST; // Pozycjonowanie Lewa-Góra
        net.insets = new Insets(20, 20, 0, 0);
        centerPanel.add(level_mode, net);

        // 2. MAŁY PANEL: REMIS (Generuje się w PRAWYM GÓRNYM rogu obszaru gry)
        JPanel remis_mode = createInfoPanel("Remis", drawLabel);

        net.anchor = GridBagConstraints.NORTHEAST; // Pozycjonowanie Prawa-Góra
        net.insets = new Insets(20, 0, 0, 20);
        centerPanel.add(remis_mode, net);

        // 3. PANEL KOLEJ GRACZA (Generuje się centralnie na GÓRZE, nad planszą)
        JPanel mode_panel = TextPanel("");
        mode_panel.add(writting, BorderLayout.CENTER);
        net.anchor = GridBagConstraints.NORTH; // Pozycjonowanie Środek-Góra
        net.insets = new Insets(20, 0, 90, 0);
        centerPanel.add(mode_panel, net);

        // 4. PANEL GRACZ 1 (Generuje się po LEWEJ stronie, obok planszy)
        JPanel player_1_mode = createPlayerPanel(player1Name, "img/X.png", p1ScoreLabel);
        net.anchor = GridBagConstraints.WEST; // Pozycjonowanie Lewo
        net.insets = new Insets(0, 20, 0, 0);
        centerPanel.add(player_1_mode, net);

        // 5. PANEL GRACZ 2 (Generuje się po PRAWEJ stronie, obok planszy)
        JPanel player_2_mode = createPlayerPanel(player2Name, "img/O.png", p2ScoreLabel);
        net.anchor = GridBagConstraints.EAST; // Pozycjonowanie Prawo
        net.insets = new Insets(0, 0, 0, 20);
        centerPanel.add(player_2_mode, net);

        // 6. PLANSZA DO GRY (Generuje się na SAMYM ŚRODKU ekranu, to jest siatka 3x3)
        JPanel bord = new JPanel(new GridLayout(3,3,15,15)); // GridLayout tworzy 3 rzędy, 3 kolumny
        bord.setBackground(Style.bord);
        bord.setPreferredSize(Style.bord_size);

        // Pętla tworząca 9 kafelków (przycisków) dla kółka i krzyżyka
        for(int i = 0; i < 9; i++){
            fields[i] = new JButton(""); // Pusty przycisk
            Style.styleBoardTile(fields[i]); // Nadanie stylu (wyglądu)
            bord.add(fields[i]); // Dodanie przycisku do panelu planszy

            Logic finalGameLogic = gameLogic;
            // Dodanie nasłuchiwacza - co ma się stać, gdy gracz kliknie pole
            fields[i].addActionListener(e -> {
                JButton clickedButton = (JButton) e.getSource();
                finalGameLogic.playerMove(clickedButton); // Wywołanie ruchu w logice gry
            });
        }

        net.anchor = GridBagConstraints.CENTER; // Wyśrodkowanie całej planszy 3x3
        net.insets = new Insets(90, 20, 0, 20);
        centerPanel.add(bord, net);

        // ==========================================
        // ZATWIERDZENIE ZMIAN W EKRANIE GRY
        // ==========================================
        window.add(centerPanel, BorderLayout.CENTER); // Dodanie całego środka do okna

        Logic finalGameLogicForReset = gameLogic;
        reset.addActionListener(e -> finalGameLogicForReset.reset()); // Akcja do przycisku Reset z górnej belki

        window.revalidate(); // Aktualizacja widoku
        window.repaint(); // Przemalowanie ekranu
    }
}