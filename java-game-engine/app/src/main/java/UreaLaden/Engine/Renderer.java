package UreaLaden.Engine;

import java.awt.image.DataBufferInt;

public class Renderer
{
    private int pW, pH; //pixel width / height
    private int[] p; //pixels

    public Renderer(GameContainer gc)
    {
        pW = gc.getWidth();
        pH = gc.getHeight();
        //Gives the int[] direct access to the pixel data of image in our window
        p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }

    public void clear()
    {
        for(int i=0;i<p.length;i++)
        {
            p[i] += 0;
        }
    }
}
