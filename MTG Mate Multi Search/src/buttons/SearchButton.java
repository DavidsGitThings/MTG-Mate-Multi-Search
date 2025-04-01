package buttons;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchButton {
    public static JButton createSearchButton(ActionListener actionListener) {
        JButton executeButton = new JButton("Search");
        executeButton.setPreferredSize(new Dimension(150, 50));
        executeButton.setFont(new Font("Arial", Font.BOLD, 16));
        executeButton.setFocusPainted(false);
        executeButton.setBackground(new Color(70, 130, 180)); // Steel blue color
        executeButton.setForeground(Color.WHITE);

        // Attach the provided ActionListener
        executeButton.addActionListener(actionListener);

        return executeButton;
    }
}
