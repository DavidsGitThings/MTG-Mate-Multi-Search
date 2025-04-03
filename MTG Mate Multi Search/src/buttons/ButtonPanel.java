package buttons;

import utils.GrayscaleFilter;
import websites.MultiSearchWebsite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ButtonPanel extends JPanel {
    private List<JButton> buttons = new ArrayList<>();
    private List<ImageIcon> originalIcons = new ArrayList<>();
    private List<ImageIcon> greyedIcons = new ArrayList<>();
    private List<MultiSearchWebsite> websitesList = new ArrayList<>();
    private int selectedIndex = 0;

    public ButtonPanel(MultiSearchWebsite[] websites) {
        setLayout(new FlowLayout());

        // Load images and create buttons dynamically
        for (MultiSearchWebsite website : websites) {
            ImageIcon originalIcon = new ImageIcon(getClass().getResource(website.getWebsiteImgDir()));
            ImageIcon greyedIcon = GrayscaleFilter.createGreyedImageIcon(originalIcon);

            JButton button = new JButton(greyedIcon);
            setupButton(button, originalIcon, greyedIcon, websitesList.size());
            add(button);

            buttons.add(button);
            originalIcons.add(originalIcon);
            greyedIcons.add(greyedIcon);
            websitesList.add(website);
        }

        // Set the first button as active and disable others initially
        if (!buttons.isEmpty()) {
            buttons.get(0).setIcon(originalIcons.get(0));
            buttons.get(0).setDisabledIcon(originalIcons.get(0));
            buttons.get(0).setEnabled(false);
        }
    }

    private void setupButton(JButton button, ImageIcon originalIcon, ImageIcon greyedIcon, int index) {
        button.setPreferredSize(new Dimension(100, 100));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setIcon(greyedIcon);
        button.setDisabledIcon(greyedIcon);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Disable all buttons and reset their icons
                for (int i = 0; i < buttons.size(); i++) {
                    buttons.get(i).setIcon(greyedIcons.get(i));
                    buttons.get(i).setDisabledIcon(greyedIcons.get(i));
                    buttons.get(i).setEnabled(true);
                }

                // Enable only the clicked button and set it to its original icon
                button.setIcon(originalIcon);
                button.setDisabledIcon(originalIcon);
                button.setEnabled(false);

                selectedIndex = index;
                System.out.println("Button clicked: " + originalIcon.getDescription());
            }
        });
    }

    public MultiSearchWebsite getSelectedWebsite() {
        return websitesList.get(selectedIndex);
    }
}
