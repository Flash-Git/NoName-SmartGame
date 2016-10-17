package dev.flash.smartgame.display;

import javax.swing.JFrame;

import java.awt.Canvas;
import java.awt.Dimension;

/**
 * Created by Flash on 17/10/2016.
 */

public class Display {
    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setName("Jonathon");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);//TODO eventually incorporate adaptable sizes

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(0, 0));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;

    }

    public JFrame getFrame(){
        return frame;
    }
}
