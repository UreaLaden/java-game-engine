package Game;

import UreaLaden.Engine.AbstractGame;
import UreaLaden.Engine.GameContainer;
import UreaLaden.Engine.Renderer;
import UreaLaden.Engine.gfx.Image;
import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    private Image image;

    public GameManager()
    {
        image = new Image("/test.png");
    }

    @Override
    public void update(GameContainer gc, float deltaTime) {
        if(gc.getInput().isKeyDown(KeyEvent.VK_A))
        {
            System.out.println("A was pressed");
        }
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        renderer.drawImage(image,gc.getInput().getMouseX(),gc.getInput().getMouseY());
    }

    public static void main(String[] args)
    {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
