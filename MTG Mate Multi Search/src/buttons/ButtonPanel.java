package buttons;

import utils.GrayscaleFilter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton button1, button2;
    private ImageIcon icon1, icon2;
    private ImageIcon greyedIcon1, greyedIcon2;

    public ButtonPanel() {
        setLayout(new FlowLayout()); // Set layout for buttons

        // Load images for buttons
        icon1 = new ImageIcon(getClass().getResource("/Websites/Images/MTGMateLogo.jpg"));
        icon2 = new ImageIcon(getClass().getResource("/Websites/Images/CKLogo.png"));

        // Create greyed-out icons
        greyedIcon1 = GrayscaleFilter.createGreyedImageIcon(icon1);
        greyedIcon2 = GrayscaleFilter.createGreyedImageIcon(icon2);

        // Create buttons with initial greyed-out icons
        button1 = new JButton(greyedIcon1);
        button2 = new JButton(greyedIcon2);

        // Set up button behavior
        setupButton(button1, button2);
        setupButton(button2, button1);

        // Add buttons to the panel
        add(button1);
        add(button2);
    }

    private void setupButton(JButton button, JButton otherButton) {
        button.setPreferredSize(new Dimension(100, 100));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);

        if (button == button1) {
            button.setIcon(greyedIcon1);
            button.setDisabledIcon(greyedIcon1);
        } else {
            button.setIcon(greyedIcon2);
            button.setDisabledIcon(greyedIcon2);
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button == button1) {
                    button.setIcon(icon1);
                    button.setDisabledIcon(icon1);
                } else {
                    button.setIcon(icon2);
                    button.setDisabledIcon(icon2);
                }

                button.setEnabled(false);
                otherButton.setEnabled(true);

                if (otherButton == button1) {
                    otherButton.setIcon(greyedIcon1);
                    otherButton.setDisabledIcon(greyedIcon1);
                } else {
                    otherButton.setIcon(greyedIcon2);
                    otherButton.setDisabledIcon(greyedIcon2);
                }

                System.out.println(button == button1 ? "Button 1 Pressed" : "Button 2 Pressed");
            }
        });
    }
}
