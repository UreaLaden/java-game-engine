package Game;

import UreaLaden.Engine.AbstractGame;
import UreaLaden.Engine.GameContainer;
import UreaLaden.Engine.Renderer;
import UreaLaden.Engine.gfx.ImageTile;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    private ImageTile image;

    public GameManager()
    {
        image = new ImageTile("/test.png",16,16);
    }

    float temp = 0;

    @Override
    public void update(GameContainer gc, float deltaTime) {
        if(gc.getInput().isKeyDown(KeyEvent.VK_A))
        {
            System.out.println("A was pressed");
        }
        temp += deltaTime * 10;
        if(temp > 3){
            temp = 0;
        }
    }
    @Override
    public void render(GameContainer gc, Renderer renderer) {
        renderer.drawImageTile(image,gc.getInput().getMouseX()- 8,gc.getInput().getMouseY()- 16,
                (int)temp
                ,0);
    }

    public static void main(String[] args)
    {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
