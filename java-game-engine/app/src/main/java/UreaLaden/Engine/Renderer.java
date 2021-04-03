package UreaLaden.Engine;
import UreaLaden.Engine.gfx.*;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

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
        Arrays.fill(p, 0);
    }

    public void setPixelValue(int x, int y, int value){
        if((x < 0 || x >= pW || y < 0 || y >= pH)|| value == 0xffff00ff){
         return;
        }
        p[x + y * pW] = value;
    }

    public void drawImage(Image image, int offsetX, int offsetY)
    {
        for(int y=0;y<image.getHeight();y++){
            for(int x=0;x<image.getWidth();x++){
                //Set pixel data
                setPixelValue(x + offsetX,y + offsetY, image.getPixel()[x+ y * image.getWidth()]);
            }
        }
    }
}
