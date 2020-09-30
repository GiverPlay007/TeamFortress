package me.giverplay.teamfortress.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Comparator;
import java.util.Random;
import me.giverplay.teamfortress.game.Camera;
import me.giverplay.teamfortress.game.Game;

public abstract class Entity
{
  protected static Random random = new Random();
  protected static Game game = Game.getGame();
  protected static Camera camera = game.getCamera();
  
  protected double y;
  
  protected int width;
  protected int height;
  protected int depth;
  protected int x;
  
  public Entity(int x, double y, int width, int height, int depth)
  {
    setLocation(x, y);
    setDimension(width, height);
    setDepth(depth);
  }
  public abstract void tick();
  
  public abstract void render(Graphics g);
  
  public void destroy()
  {
    game.getEntities().remove(this);
  }
  
  public void setX(int x)
  {
    this.x = x;
  }
  
  public void setY(int y)
  {
    this.y = y;
  }
  
  public void setDepth(int toSet)
  {
    this.depth = toSet;
  }
  
  public void setLocation(int x, double y)
  {
    this.x = x;
    this.y = y;
  }
  
  public void setDimension(int w, int h)
  {
    this.width = w;
    this.height = h;
  }
  
  public void moveX(double d)
  {
    x += d;
  }
  
  public void moveY(double d)
  {
    y += d;
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public int getY()
  {
    return (int) this.y;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getDepth()
  {
    return this.depth;
  }
  
  public static boolean isColliding(Entity e1, Entity e2)
  {
    Rectangle e1m = new Rectangle(e1.getX(), e1.getY(), e1.getWidth(), e1.getHeight());
    Rectangle e2m = new Rectangle(e2.getX(), e2.getY(), e2.getWidth(), e2.getHeight());
    
    return e1m.intersects(e2m);
  }
  
  public static Comparator<Entity> sortDepth = Comparator.comparingInt(Entity::getDepth);
  
  public double pointDistance(int x1, int y1, int x2, int y2)
  {
    return Math.sqrt((x2 - x1) * (x2 - x1) + ((y2 - y1) * (y2 - y1)));
  }
}
