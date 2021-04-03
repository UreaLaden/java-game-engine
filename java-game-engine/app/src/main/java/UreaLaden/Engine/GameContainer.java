package UreaLaden.Engine;

public class GameContainer implements Runnable
{
    private Thread thread;
    private Window window;
    private Renderer renderer;
    private Input input;


    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0; //Cap updates at 60 frames per second

    private int width = 1600, height= 900;
    private float scale = 1f;
    private String title = "UreaLaden.Engine v1.0";

    public GameContainer()
    {

    }
    public void start()
    {
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);

        thread = new Thread(this);
        thread.run(); //.run is for main thread
    }
    public void stop(){

    }
    public void run()
    {
        running = true;
        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0; //count passed frames
        int fps = 0; //frames per second

        while(running)
        {
            render = false;
            //Get current time and determine how long it has been
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >=UPDATE_CAP)
            {
                //Updates twice if frames freeze
                unprocessedTime -= UPDATE_CAP;
                render = true; // only when we update
                //TODO: Update game
                System.out.println("x: " + input.getMouseX() + " y: " + input.getMouseY());

                input.update();

                if(frameTime >= 1.0)
                {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
            }

            if(render)
            {
                renderer.clear();
                //TODO: Render game
                window.update();
                frames++;

            }
            else
            {
                try
                {
                    Thread.sleep(1); //If not updating or rendering don't do anything. Takes it
                    // easy on CPU
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        dispose();
    }
    private void dispose()
    {

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static void main(String[] args){
        GameContainer gc = new GameContainer();
        gc.start();
    }

    public Window getWindow() {
        return window;
    }
}
