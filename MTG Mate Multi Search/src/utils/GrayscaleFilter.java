package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GrayscaleFilter {
    public static ImageIcon createGreyedImageIcon(ImageIcon original) {
        // Get the image from the ImageIcon
        Image img = original.getImage();

        // Convert to BufferedImage
        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        // Apply the grayscale filter while preserving transparency
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                int color = bufferedImage.getRGB(x, y);

                // Extract ARGB components
                int alpha = (color >> 24) & 0xFF; // Preserve transparency
                int red = (color >> 16) & 0xFF;
                int green = (color >> 8) & 0xFF;
                int blue = color & 0xFF;

                // Convert to grayscale
                int gray = (int) (red * 0.3 + green * 0.59 + blue * 0.11);

                // Reconstruct the color with the original alpha channel
                int newColor = (alpha << 24) | (gray << 16) | (gray << 8) | gray;

                bufferedImage.setRGB(x, y, newColor);
            }
        }

        // Return new grayscale ImageIcon
        return new ImageIcon(bufferedImage);
    }
}
