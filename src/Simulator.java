import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Simulator extends JFrame implements ActionListener {
    private JPanel panel1;
    private JButton takeToVetButton;
    private JProgressBar vetBar;
    private JButton batheButton;
    private JProgressBar batheBar;
    private JButton feedButton1;
    private JProgressBar feedBar;
    private JButton giveWaterButton;
    private JProgressBar waterBar;
    private JButton playButton;
    private JProgressBar playBar;
    private JButton takeNapButton;
    private JProgressBar sleepBar;
    private JLabel label1;
    private Timer gameTimer;
    private JPanel JPanel1;
    private JPanel catSpace;
    private JLabel imageLabel;
    private int seconds;
    private int coins;

    private ImageIcon deadCat;
    private ImageIcon happyCat;
    private ImageIcon happyCatAtVet;
    private ImageIcon happyCatBathing;
    private ImageIcon happyCatDrinking;
    private ImageIcon happyCatEating;
    private ImageIcon happyCatPlaying;
    private ImageIcon happyCatSleeping;
    private ImageIcon sadCat;

    public Simulator(GUI g) {

        setContentPane(panel1);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        label1.setText(g.getCatName());


        vetBar.setValue(100);
        sleepBar.setValue(100);
        playBar.setValue(100);
        waterBar.setValue(100);
        feedBar.setValue(100);
        batheBar.setValue(100);

        gameTimer = new Timer(1000, null);
        seconds = 0;

        deadCat = new ImageIcon("src/deadCat.jpg");
        happyCat = new ImageIcon("src/happyCat.jpg");
        happyCatAtVet = new ImageIcon("src/happyCatAtVet.jpg");
        happyCatBathing = new ImageIcon("src/happyCatBathing.jpg");
        happyCatDrinking = new ImageIcon("src/happyCatDrinking.jpg");
        happyCatEating = new ImageIcon("src/happyCatEating.jpg");
        happyCatPlaying = new ImageIcon("src/happyCatPlaying.jpg");
        happyCatSleeping = new ImageIcon("src/happyCatSleeping.jpg");
        sadCat = new ImageIcon("src/sadCat.jpg");

        imageLabel.setIcon(happyCat);

        setupListeners();
        createUIComponents();


    }

    public void createUIComponents() {
        setSize(500, 500);

        setVisible(true);
    }



    public void addActionListener() {
    };

    private void setupListeners(){
        takeToVetButton.addActionListener(this);
        batheButton.addActionListener(this);
        feedButton1.addActionListener(this);
        giveWaterButton.addActionListener(this);
        playButton.addActionListener(this);
        takeNapButton.addActionListener(this);
        gameTimer.addActionListener(this);
        gameTimer.start();
    }

    public void timerFires(){
        seconds++;
        if (seconds % 5 == 0){
            waterBar.setValue(waterBar.getValue() - 10);
        }
        if (seconds % 15 == 0){
            feedBar.setValue(feedBar.getValue() - 15);
        }
//        if (seconds % 10 == 0){
//            playBar.setValue(playBar.getValue() - 5);
//        }
        if (seconds % 20 == 0){
            batheBar.setValue(batheBar.getValue() - 20);
        }
        if (seconds % 25 == 0){
            sleepBar.setValue(sleepBar.getValue() - 20);
        }
        if ((waterBar.getValue() == 50
                || feedBar.getValue() == 40
                || playBar.getValue() == 0
                || sleepBar.getValue() == 50
                || batheBar.getValue() == 60)
                || seconds % 35 == 0){
            vetBar.setValue(vetBar.getValue() - 15);
        }
        if (vetBar.getValue() == 40){
            imageLabel.setIcon(sadCat);
        }
        if (vetBar.getValue() == 0);{
            imageLabel.setIcon(deadCat);
            //Insert the code that ends the game
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof Timer){
            timerFires();
        } else if (source instanceof JButton) {
            JButton button = (JButton) source;
            String buttonText = button.getText();
            int waiting;
            int barTemp;
            if (buttonText.equals("Feed")) {
                barTemp = feedBar.getValue();
                waiting = seconds + 3;
                imageLabel.setIcon(happyCatEating);
                if (seconds == waiting) {
                    imageLabel.setIcon(happyCat);
                }
                feedBar.setValue(barTemp + 10);
            } else if (buttonText.equals("Give Water")) {
                barTemp = waterBar.getValue();
                waiting = seconds + 3;
                imageLabel.setIcon(happyCatDrinking);
                if (seconds == waiting) {
                    imageLabel.setIcon(happyCat);
                }
                waterBar.setValue(barTemp + 10);
            } else if (buttonText.equals("Play")) {
//                barTemp = playBar.getValue();
//                waiting = seconds + 3;
//                imageLabel.setIcon(happyCatPlaying);
//                if (seconds == waiting) {
//                    imageLabel.setIcon(happyCat);
//                }
//                playBar.setValue(barTemp + 10);
                imageLabel.setIcon(happyCatPlaying);
                playBar.setValue(playBar.getValue() - 20);
                if (playBar.getValue() <= 20){
                    vetBar.setValue(vetBar.getValue() - 5);
                }
            } else if (buttonText.equals("Take to Vet")) {
                waiting = seconds + 3;
                imageLabel.setIcon(happyCatAtVet);
                if (seconds == waiting) {
                    imageLabel.setIcon(happyCat);
                }
                vetBar.setValue(100);
                feedBar.setValue(100);
                waterBar.setValue(100);
                playBar.setValue(100);
                batheBar.setValue(100);
                sleepBar.setValue(100);
            } else if (buttonText.equals("Bathe")) {
                barTemp = batheBar.getValue();
                waiting = seconds + 3;
                imageLabel.setIcon(happyCatBathing);
                if (seconds == waiting) {
                    imageLabel.setIcon(happyCat);
                }
                batheBar.setValue(barTemp + 10);
            } else if (buttonText.equals("Take Nap")) {
                barTemp = sleepBar.getValue();
                waiting = seconds + 3;
                imageLabel.setIcon(happyCatSleeping);
                if (seconds == waiting) {
                    imageLabel.setIcon(happyCat);
                }
                sleepBar.setValue(barTemp + 10);
            }
        }
    }
    }
