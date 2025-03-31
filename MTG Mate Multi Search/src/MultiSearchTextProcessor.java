import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MultiSearchTextProcessor implements ActionListener{
    private JTextArea textArea;

    public MultiSearchTextProcessor(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputText = textArea.getText();
        String[] lines = inputText.split("\\n"); // Split input into lines

        // Add up to 20 lines to the list
        List<String> stringList = new ArrayList<>(Arrays.asList(lines).subList(0, Math.min(lines.length, 20)));

        // Print the list (or process it as needed)
        System.out.println("Stored Strings: " + stringList);
        MultiSearchTabCreator.openMultipleTabs(stringList);
    }
}
