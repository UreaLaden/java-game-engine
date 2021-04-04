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
        //Don't Render Code
        if(offsetX < -image.getWidth())return;
        if(offsetY < -image.getHeight())return;
        if(offsetY >= pW )return;
        if(offsetY >= pH )return;

        int newX = 0;
        int newY = 0;
        int newWidth = image.getWidth();
        int newHeight = image.getHeight();

        //Clipping Code
        if(offsetX < 0){ newX -= offsetX; }
        if(offsetY < 0){ newY -= offsetY; }
        if(newWidth + offsetX > pW){ newWidth -= (newWidth + offsetX - pW); }
        if(newHeight + offsetY > pH){ newHeight -= (newHeight + offsetY - pH); }

        for(int y = newY ; y < newHeight ; y++){
            for(int x = newX ; x < newWidth ; x++){
                //Set pixel data
                setPixelValue(x + offsetX,y + offsetY, image.getPixel()[x+ y * image.getWidth()]);
            }
        }
    }

    public void drawImageTile(ImageTile image, int offsetX, int offsetY, int tileX, int tileY){
        //Don't Render Code
        if(offsetX < -image.getTileWidth())return;
        if(offsetY < -image.getTileHeight())return;
        if(offsetY >= pW )return;
        if(offsetY >= pH )return;

        int newX = 0;
        int newY = 0;
        int newWidth = image.getTileWidth();
        int newHeight = image.getTileHeight();

        //Clipping Code
        if(offsetX < 0){ newX -= offsetX; }
        if(offsetY < 0){ newY -= offsetY; }
        if(newWidth + offsetX > pW){ newWidth -= (newWidth + offsetX - pW); }
        if(newHeight + offsetY > pH){ newHeight -= (newHeight + offsetY - pH); }

        for(int y = newY ; y < newHeight ; y++){
            for(int x = newX ; x < newWidth ; x++){
                //Set pixel data
                setPixelValue(x + offsetX,y + offsetY,
                        image.getPixel()[(x + tileX * image.getTileWidth())+ (y + tileY * image.getTileHeight()) * image.getWidth()]);
            }
        }
    }
}
