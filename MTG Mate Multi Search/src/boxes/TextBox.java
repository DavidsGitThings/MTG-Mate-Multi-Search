package boxes;

import javax.swing.*;
import java.awt.*;

public class TextBox extends JPanel {
    private JTextArea textArea;

    public TextBox() {
        setLayout(new BorderLayout()); // Use BorderLayout for better resizing

        // Create the text area
        textArea = new JTextArea(10, 15);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setRows(20); // Set max lines to 20

        // Add a scroll pane
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to get text from the text area
    public JTextArea getText() {
        return textArea;
    }

    // Method to set text in the text area
    public void setText(String text) {
        textArea.setText(text);
    }

    // Method to clear the text area
    public void clearText() {
        textArea.setText("");
    }

    // Expose the JTextArea if needed for additional customization
    public JTextArea getTextArea() {
        return textArea;
    }
}
