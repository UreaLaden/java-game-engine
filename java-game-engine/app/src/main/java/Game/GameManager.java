package Game;

import UreaLaden.Engine.AbstractGame;
import UreaLaden.Engine.GameContainer;
import UreaLaden.Engine.Renderer;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    public GameManager()
    {

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

    }

    public static void main(String[] args)
    {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
