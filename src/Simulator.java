import javax.swing.*;
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
    private JLabel CoinsLabel;
    private int seconds;
    private int coins;

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
        coins = 15;


        happyCat = new ImageIcon("src/happyCat.jpg");
        happyCatAtVet = new ImageIcon("src/happyCatAtVet.jpg");
        happyCatBathing = new ImageIcon("src/happyCatBathing.jpg");
        happyCatDrinking = new ImageIcon("src/happyCatDrinking.jpg");
        happyCatEating = new ImageIcon("src/happyCatEating.jpg");
        happyCatPlaying = new ImageIcon("src/happyCatPlaying.jpg");
        happyCatSleeping = new ImageIcon("src/happyCatSleeping.jpg");
        sadCat = new ImageIcon("src/sadCat.jpg");

        imageLabel.setIcon(happyCat);
        imageLabel.setText("Happy!!");

        setupListeners();
        createUIComponents();


    }

    public void createUIComponents() {
        setSize(500, 500);

        setVisible(true);
    }



    public void addActionListener() {
    }

    public int getSeconds(){
        return seconds;
    }

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
        CoinsLabel.setText("Coins: " + coins);
        seconds++;
        if (seconds % 5 == 0){
            waterBar.setValue(waterBar.getValue() - 10);
        }
        if (seconds % 15 == 0){
            feedBar.setValue(feedBar.getValue() - 15);
        }
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
        if (vetBar.getValue() > 40){
            imageLabel.setIcon(happyCat);
        }
        if (vetBar.getValue() <= 40){
            imageLabel.setIcon(sadCat);
        }
        if (vetBar.getValue() == 0) {

            gameTimer.stop();
            GameOver go = new GameOver();

//            imageLabel.setIcon(deadCat);
//            label1.setText("GAME OVER");
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
            int barTemp;
            if (buttonText.equals("Feed")) {
                if (coins - 10 >= 0){
                    imageLabel.setText("OM NOM NOM NOM");
                    coins -= 10;
                    barTemp = feedBar.getValue();
                    imageLabel.setIcon(happyCatEating);
                    feedBar.setValue(barTemp + 10);
                } else{
                    imageLabel.setText("Not enough coins :(");
                }

            } else if (buttonText.equals("Give Water")) {
                if (coins - 5 >= 0){
                    imageLabel.setText("GULP GULP GULP");
                    coins -= 5;
                    barTemp = waterBar.getValue();
                    imageLabel.setIcon(happyCatDrinking);
                    waterBar.setValue(barTemp + 10);
                } else{
                    imageLabel.setText("Not enough coins :(");
                }

            } else if (buttonText.equals("Play")) {
                imageLabel.setText("HOORAY!!!");
                coins += 15;
                imageLabel.setIcon(happyCatPlaying);
                playBar.setValue(playBar.getValue() - 20);
                if (playBar.getValue() <= 20){
                    sleepBar.setValue(sleepBar.getValue() - 5);
                }
            } else if (buttonText.equals("Take to Vet")) {
                if (coins - 25 >= 0){
                    imageLabel.setText("ALL BETTER :)");
                    coins -= 25;
                    imageLabel.setIcon(happyCatAtVet);
                    vetBar.setValue(100);
                    feedBar.setValue(100);
                    waterBar.setValue(100);
                    playBar.setValue(100);
                    batheBar.setValue(100);
                    sleepBar.setValue(100);
                } else{
                    imageLabel.setText("Not enough coins :(");
                }

            } else if (buttonText.equals("Bathe")) {
                if (coins - 10 >= 0){
                    imageLabel.setText("SCRUB A DUB DUB");
                    coins -= 10;
                    barTemp = batheBar.getValue();
                    imageLabel.setIcon(happyCatBathing);
                    batheBar.setValue(barTemp + 10);
                } else{
                    imageLabel.setText("Not enough coins :(");
                }

            } else if (buttonText.equals("Take Nap")) {
                imageLabel.setText("A HONK SHOO");
                barTemp = sleepBar.getValue();
                imageLabel.setIcon(happyCatSleeping);
                sleepBar.setValue(barTemp + 10);
                playBar.setValue(playBar.getValue() + 25);
            }
        }
    }
    }
