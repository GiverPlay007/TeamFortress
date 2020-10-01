package me.giverplay.teamfortress.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class AmmoEntity extends Entity implements Collectible
{
  protected BufferedImage sprite;
  private EntityAmmoType type;
  private String name;
  
  protected boolean collected;
  
  private int currentItems;
  private int maxItems;
  
  public AmmoEntity(String name, EntityAmmoType type, int currentItems, int maxItems, int x, int y, int width, int height, BufferedImage sprite)
  {
    super(x, y, width, height, 0);
    
    this.sprite = sprite;
    this.name = name;
    this.type = type;
    this.currentItems = currentItems;
    this.maxItems = maxItems;
  }
  
  @Override
  public boolean isCollected()
  {
    return collected;
  }
  
  @Override
  public void render(Graphics g)
  {
    g.drawImage(sprite, getCamX(), getCamY(), getWidth(), getHeight(), null);
  }
  
  public void setCurrentItems(int currentItems)
  {
    this.currentItems = currentItems;
  }
  
  public EntityAmmoType getType()
  {
    return type;
  }
  
  public String getName()
  {
    return name;
  }
  
  public int getCurrentItems()
  {
    return currentItems;
  }

  public int getMaxItems()
  {
    return maxItems;
  }
  
  public BufferedImage getSprite()
  {
    return sprite;
  }
}
