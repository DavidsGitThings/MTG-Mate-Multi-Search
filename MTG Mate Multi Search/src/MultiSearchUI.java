import boxes.TextBox;
import buttons.ButtonPanel;
import buttons.SearchButton;
import websites.CardKingdom;
import websites.MTGMate;
import websites.MultiSearchWebsite;

import javax.swing.*;
import java.awt.*;

public class MultiSearchUI {
    private JButton button1, button2;
    private ImageIcon icon1, icon2;
    private ImageIcon greyedIcon1, greyedIcon2;

    public void renderMultiSearchUI() {
        // Create the frame
        JFrame frame = new JFrame("Open Google");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLayout(new GridBagLayout()); // Use GridBagLayout to center components

        // Create layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        // Create label
        JLabel label = new JLabel("MTG Card Multi-Search", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(label, gbc);

        // Create an instance of the ButtonPanel

        // Create new instance of websites to be added to the panel
        MultiSearchWebsite CardKingdom = new CardKingdom();
        MultiSearchWebsite MTGMate = new MTGMate();

        // Original Button Array
        String[] buttonImages = {
                MTGMate.getWebsiteImgDir(),
                CardKingdom.getWebsiteImgDir()
        };

        //New Button Array
        MultiSearchWebsite[] websiteArray = {
                // Add each website class' instance
                MTGMate,
                CardKingdom
        };

        ButtonPanel buttonPanel = new ButtonPanel(websiteArray);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(buttonPanel, gbc);


        // Create an instance of the TextBox
        TextBox textBox = new TextBox();
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(textBox, gbc);

        // Create an instance of the SearchBox
        JButton searchButton = SearchButton.createSearchButton(new MultiSearchTextProcessor(textBox.getText()));
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(searchButton, gbc);

        // Make the frame visible
        frame.setVisible(true);
    }
}
