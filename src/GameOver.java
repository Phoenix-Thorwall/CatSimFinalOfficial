import javax.swing.*;
import java.awt.*;

public class GameOver {
    private JLabel header;
    private JLabel explanation;
    private ImageIcon deadCat;

    public GameOver(){
        createUIComponents();
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        deadCat = new ImageIcon("src/deadCat.jpg");
        Image imageData = deadCat.getImage();
        Image scaledImage = imageData.getScaledInstance(39, 30, Image.SCALE_SMOOTH);
        deadCat = new ImageIcon(scaledImage);
    }

    public void createUIComponents() {
        setVisible(true);
        setSize(500, 500);
    }
    public void addActionListener() {

    }
}
