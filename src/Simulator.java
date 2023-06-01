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
    private JPanel JPanel1;
    private JPanel catSpace;
    private int seconds;

    public Simulator(GUI g) {
        createUIComponents();

        setContentPane(panel1);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        takeToVetButton.addActionListener(this);
        batheButton.addActionListener(this);
        feedButton1.addActionListener(this);
        giveWaterButton.addActionListener(this);
        playButton.addActionListener(this);
        takeNapButton.addActionListener(this);

        label1.setText(g.getCatName());


        vetBar.setValue(100);
        sleepBar.setValue(100);
        playBar.setValue(100);
        waterBar.setValue(100);
        feedBar.setValue(100);
        batheBar.setValue(100);

        Timer gameTimer = new Timer(1000, null);
        seconds = 0;

    }

    public void createUIComponents() {
        setVisible(true);
        setSize(500, 500);
    }



    public void addActionListener() {
    };

    private void setupListeners(){
        gameTimer.addActionListener(this);
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
