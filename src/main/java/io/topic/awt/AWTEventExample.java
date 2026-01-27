package io.topic.awt;

import java.awt.*;
import java.awt.event.*;

public class AWTEventExample {
    public static void main(String[] args) {
        Frame frame = new Frame("AWT Event Demo");
        Button button = new Button("Click Me");

        // Register event listener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setVisible(true);

        // Window closing event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
