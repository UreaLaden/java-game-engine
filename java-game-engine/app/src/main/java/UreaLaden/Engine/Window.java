package UreaLaden.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window
{
    private JFrame frame;
    private BufferedImage image; //Store pixel data for screen
    private Canvas canvas;
    private BufferStrategy bs;
    private Graphics g;

    public Window(GameContainer gc)
    {
        image  = new BufferedImage(gc.getWidth(),gc.getHeight(),BufferedImage.TYPE_INT_RGB); //image stored in ram
        canvas = new Canvas();
        Dimension s = new Dimension((int)(gc.getWidth() * gc.getScale()),
                (int)(gc.getHeight()*gc.getScale()));
        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setMinimumSize(s);

        frame = new JFrame(gc.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program ends on clicking x button
        frame.setLayout(new BorderLayout()); // matches canvas to border
        frame.add(canvas,BorderLayout.CENTER);
        frame.pack(); //sets frame to size of the canvas
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
    }

    public void update()
    {
        g.drawImage(image,0,0,canvas.getWidth(), canvas.getHeight(),null);
        bs.show();
    }

    public BufferedImage getImage() {
        return image;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
