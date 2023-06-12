import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private String catName;
    private JTextField typeTheNameYouTextField;
    private JButton startGameButton;
    private JLabel instructions;

    public GUI() {
        createUIComponents();

        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        startGameButton.addActionListener(this);

    }

    public void createUIComponents() {
        setVisible(true);
        setSize(700, 400);
    }

    public String getCatName() {
        return catName;
    }

    public void addActionListener() {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = (JButton) source;
        String buttonText = button.getText();

        if (buttonText.equals("Start Game")){
            catName = typeTheNameYouTextField.getText();
            Simulator s = new Simulator(this);
        }



    }
}
