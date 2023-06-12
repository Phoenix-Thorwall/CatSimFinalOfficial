import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class GameOver extends JFrame implements ActionListener {
    private JLabel header;
    private JLabel explanation;
    private JPanel mainPanel;
    private JLabel imageLabel;
    private JLabel lifespan;
    private ImageIcon deadCat;

    public GameOver(GUI g, Simulator s){
        createUIComponents();
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        deadCat = new ImageIcon("src/deadCat.jpg");
        Image imageData = deadCat.getImage();
        Image scaledImage = imageData.getScaledInstance(624, 480, Image.SCALE_SMOOTH);
        deadCat = new ImageIcon(scaledImage);
        imageLabel.setIcon(deadCat);

        header.setText(g.getCatName() + " is DEAD");
        explanation.setText("You did not take your cat to the vet, so it died.");
        lifespan.setText(g.getCatName() + " was alive for " + (s.getSeconds() / 60) + " minutes and " + (s.getSeconds() % 60) + " seconds.");
    }

    public void createUIComponents() {
        setVisible(true);
        setSize(650, 650);
    }
    public void addActionListener() {

    }

    public void actionPerformed(ActionEvent e){}
}
