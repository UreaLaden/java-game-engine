package UreaLaden.Engine;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
    private GameContainer gc;

    private final int NUM_KEYS = 256;  //standard keyboard has 256 keys
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS]; //for keys on the last frame

    private final int NUM_BUTTONS = 5;  //Buttons on mouse
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS]; //for keys on the last frame

    private int mouseX, mouseY; //location of mouse
    private int scroll; // 1 : not scrolling 0: down -1

    public Input(GameContainer gc)
    {
        this.gc = gc;
        mouseX = 0;
        mouseY = 0;
        scroll = 0;

        gc.getWindow().getCanvas().addKeyListener(this);
        gc.getWindow().getCanvas().addMouseListener(this);
        gc.getWindow().getCanvas().addMouseMotionListener(this);
        gc.getWindow().getCanvas().addMouseWheelListener(this);
    }

    public void update()
    {
        scroll = 0;
        //Called at the end of our frame
        for(int i=0;i<NUM_KEYS;i++)
        {
            //Takes the current frames input and store in last frames input
            keysLast[i] = keys[i];
        }
        //Called at the end of our frame
        for(int i=0;i<NUM_BUTTONS;i++)
        {
            //Takes the current frames input and store in last frames input
            buttonsLast[i] = buttons[i];
        }
    }
    public boolean isKey(int keyCode)
    {
        return keys[keyCode];
    }
    public boolean isKeyUp(int keyCode)
    {
        return !keys[keyCode] && keysLast[keyCode];
    }
    public boolean isKeyDown(int keyCode)
    {
        return keys[keyCode] && !keysLast[keyCode];
    }

    public boolean isButton(int button)
    {
        return buttons[button];
    }
    public boolean isButtonUp(int button)
    {
        return !buttons[button] && buttonsLast[button];
    }
    public boolean isButtonDown(int button)
    {
        return buttons[button] && !buttonsLast[button];
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = (int) (e.getX() / gc.getScale());
        mouseY = (int)(e.getY() / gc.getScale());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = (int) (e.getX() / gc.getScale() ); //same scale as// resolution
        mouseY = (int)(e.getY() / gc.getScale());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        scroll = e.getWheelRotation();
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public int getScroll() {
        return scroll;
    }
}
