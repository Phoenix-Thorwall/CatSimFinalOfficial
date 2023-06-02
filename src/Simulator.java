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

        Timer gameTimer = new Timer(1000, null);
        seconds = 0;

        deadCat = new ImageIcon(getClass().getResource("deadCat")).getImage();
        happyCat = new ImageIcon(getClass().getResource("happyCat")).getImage();
        happyCatAtVet = new ImageIcon(getClass().getResource("happyCatAtVet")).getImage();
        happyCatBathing = new ImageIcon(getClass().getResource("happyCatBathing")).getImage();
        happyCatDrinking = new ImageIcon(getClass().getResource("happyCatDrinking")).getImage();
        happyCatEating = new ImageIcon(getClass().getResource("happyCatEating")).getImage();
        happyCatPlaying = new ImageIcon(getClass().getResource("happyCatPlaying")).getImage();
        happyCatSleeping = new ImageIcon(getClass().getResource("happyCatSleeping")).getImage();

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
        }
    }
}
