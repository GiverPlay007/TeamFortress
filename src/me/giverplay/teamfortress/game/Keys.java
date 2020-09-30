package me.giverplay.teamfortress.game;

import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener
{
  public static boolean right;
  public static boolean left;
  public static boolean jump;
  public static boolean reload;
  public static boolean change;
  public static boolean shoot;
  
  public static void setup(Canvas canvas)
  {
    Keys keys = new Keys();
    canvas.addKeyListener(keys);
  }
  
  public void change(int code, boolean status)
  {
    switch(code)
    {
      case KeyEvent.VK_RIGHT:
      case KeyEvent.VK_D:
        right = status;
        break;
        
      case KeyEvent.VK_LEFT:
      case KeyEvent.VK_A:
        left = status;
        break;
        
      case KeyEvent.VK_W:
        jump = status;
        break;
        
      case KeyEvent.VK_SPACE:
        shoot = status;
        break;
        
      case KeyEvent.VK_R:
        reload = status;
        break;
        
      case KeyEvent.VK_Q:
        change = status;
        break;
    }
  }
  
  @Override
  public void keyTyped(KeyEvent e)
  {
  
  }
  
  @Override
  public void keyPressed(KeyEvent e)
  {
    change(e.getKeyCode(), true);
  }
  
  @Override
  public void keyReleased(KeyEvent e)
  {
    change(e.getKeyCode(), false);
  }
}
