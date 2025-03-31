import javax.swing.*;
import java.awt.*;

public class MultiSearchUI {
    public void renderMultiSearchUI() {
        // Create the frame
        JFrame frame = new JFrame("Open Google");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new GridBagLayout()); // Use GridBagLayout to center components

        // Create layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        // Create label
        JLabel label = new JLabel("Hello World", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(label, gbc);

        // Create the text area with a scrollbar
        JTextArea textArea = new JTextArea(10, 15);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setRows(20); // Set max lines to 20
        JScrollPane scrollPane = new JScrollPane(textArea);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(scrollPane, gbc);

        // Create the button
        JButton button = new JButton("Process Text");
        gbc.gridx = 0;
        gbc.gridy = 2;

        // Add action listener to the button
        button.addActionListener(new MultiSearchTextProcessor(textArea));

        // Add button to the frame with centered layout
        frame.add(button, gbc);

        // Make the frame visible
        frame.setVisible(true);
    }
}
