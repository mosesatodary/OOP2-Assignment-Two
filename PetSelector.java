import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetSelector extends JFrame 
{
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel imageLabel;
    private ButtonGroup group;

    public PetSelector() 
    {
        setTitle("Pet Selector");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Initialize radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Group the radio buttons
        group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Add radio buttons to the panel
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // Add the panel to the frame
        add(radioPanel, BorderLayout.WEST);

        // Initialize and add image label
        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        // Add action listeners to radio buttons
        birdButton.addActionListener(new RadioButtonListener());
        catButton.addActionListener(new RadioButtonListener());
        dogButton.addActionListener(new RadioButtonListener());
        rabbitButton.addActionListener(new RadioButtonListener());
        pigButton.addActionListener(new RadioButtonListener());

        // Set default selection
        pigButton.setSelected(true);
        imageLabel.setIcon(new ImageIcon("pig.png"));
    }

    private class RadioButtonListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JRadioButton source = (JRadioButton) e.getSource();
            String selection = source.getText();

            switch (selection) 
            {
                case "Bird":
                    imageLabel.setIcon(new ImageIcon("bird.png"));
                    break;
                case "Cat":
                    imageLabel.setIcon(new ImageIcon("cat.png"));
                    break;
                case "Dog":
                    imageLabel.setIcon(new ImageIcon("dog.png"));
                    break;
                case "Rabbit":
                    imageLabel.setIcon(new ImageIcon("rabbit.png"));
                    break;
                case "Pig":
                    imageLabel.setIcon(new ImageIcon("pig.png"));
                    break;
            }
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new PetSelector().setVisible(true);
            }
        });
    }
}
