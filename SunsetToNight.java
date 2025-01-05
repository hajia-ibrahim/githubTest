/*
 * Hajia Ibrahim
 * CSC 142
 * 11/15/24
 * This program will transition from sunset to nightfall.
 * The sky is orange while the sunsets and it  changes to a dark blue when the moon comes up.
 * The cloud moves from left to right.
 */

import java.awt.*; 

public class SunsetToNight {
    public static void main(String[] args) {
        // Create a window with width 800 and height 600
        DrawingPanel panel = new DrawingPanel(800, 600);
        Graphics g = panel.getGraphics(); 

        int sun = 300; // Sun starts in the middle 
        int moon = 600; // Moon starts at the bottom

        
        int cloud = -100; // Cloud starts from the left 

        for (int frame = 0; frame < 300; frame++) {
        
            if (frame < 150) {
                // Sunset color for the first 150 frames
                g.setColor(new Color(255, 140, 0)); // Orange for the sunset color
            } else {
                // Night color for frames 150 and beyond
                g.setColor(new Color(25, 25, 112)); // Blue for the night sky
            }
            g.fillRect(0, 0, 800, 600); 

            // Draw the sun going down
            if (frame < 150) { // The sun sets for the first 150 frames
                drawSun(g, 400, sun + frame); // sun goes down each frame
            }

            // Draw the moon moving up
            if (frame >= 150) { // The moon starts rising after the sun sets
                drawMoon(g, 400, moon - (frame - 150)); // moon moves up each frame
            }

            drawCloud(g, cloud + frame); // Move the cloud from left to right

            panel.sleep(50);
        }
    }

    // Method to draw the sun 
    public static void drawSun(Graphics g, int x, int y) {
        g.setColor(Color.ORANGE); // Make the sun color orange
        g.fillOval(x - 50, y - 50, 100, 100); 
    }

    // Method to draw the moon 
    public static void drawMoon(Graphics g, int x, int y) {
        g.setColor(Color.LIGHT_GRAY); // Make the moon color light gray
        g.fillOval(x - 50, y - 50, 100, 100); 
    }

    // Method to draw a cloud
    public static void drawCloud(Graphics g, int x) {
        g.setColor(Color.LIGHT_GRAY); // Set the cloud color to light gray
        g.fillOval(x, 100, 200, 30); 
    }
}
