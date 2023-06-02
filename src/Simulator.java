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

    private Image deadCat;
    private Image happyCat;
    private Image happyCatAtVet;
    private Image happyCatBathing;
    private Image happyCatDrinking;
    private Image happyCatEating;
    private Image happyCatPlaying;
    private Image happyCatSleeping;

    public Simulator(GUI g) {
        createUIComponents();

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

        deadCat = new ImageIcon("src//deadCat.jpg").getImage();
        happyCat = new ImageIcon("src//happyCat.jpg").getImage();
        happyCatAtVet = new ImageIcon("src//happyCatAtVet.jpg").getImage();
        happyCatBathing = new ImageIcon("src//happyCatBathing.jpg").getImage();
        happyCatDrinking = new ImageIcon("src//happyCatDrinking.jpg").getImage();
        happyCatEating = new ImageIcon("src//happyCatEating.jpg").getImage();
        happyCatPlaying = new ImageIcon("src//happyCatPlaying.jpg").getImage();
        happyCatSleeping = new ImageIcon("src//happyCatSleeping.jpg").getImage();

        imageLabel.setIcon((Icon) happyCat);

        setupListeners();

    }

    public void createUIComponents() {
        setVisible(true);
        setSize(500, 500);
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
        //now we can make various if statements based on what multiple
        //of a number seconds is
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
            if (buttonText.equals("Feed")) {
                waiting = seconds + 4;
                while (seconds < waiting) {
                    imageLabel.setIcon((Icon) happyCatEating);
                }
                imageLabel.setIcon((Icon) happyCat);
            } else if (buttonText.equals("Give Water")) {
                waiting = seconds + 4;
                while (seconds < waiting) {
                    imageLabel.setIcon((Icon) happyCatDrinking);
                }
                imageLabel.setIcon((Icon) happyCat);
            } else if (buttonText.equals("Play")) {
                waiting = seconds + 4;
                while (seconds < waiting) {
                    imageLabel.setIcon((Icon) happyCatPlaying);
                }
                imageLabel.setIcon((Icon) happyCat);
            } else if (buttonText.equals("Take to Vet")) {
                waiting = seconds + 4;
                while (seconds < waiting) {
                    imageLabel.setIcon((Icon) happyCatAtVet);
                }
                imageLabel.setIcon((Icon) happyCat);
            } else if (buttonText.equals("Bathe")) {
                waiting = seconds + 4;
                while (seconds < waiting) {
                    imageLabel.setIcon((Icon) happyCatBathing);
                }
                imageLabel.setIcon((Icon) happyCat);
            } else if (buttonText.equals("Take Nap")) {
                waiting = seconds + 4;
                while (seconds < waiting) {
                    imageLabel.setIcon((Icon) happyCatSleeping);
                }
                imageLabel.setIcon((Icon) happyCat);
            }
        }
    }
    }
