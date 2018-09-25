package com.img;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScreenCapture {

    public static void main(String[] args) throws AWTException {

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage img = robot.createScreenCapture(rectangle);

    }
}
