package me.giverplay.teamfortress.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class EntityWeapon extends Entity implements Collectible
{
  protected EntityAmmoType type;
  private BufferedImage sprite;
  private String name;
  
  protected boolean collected;
  
  protected int maxAmmo;
  protected int ammo;
  
  public EntityWeapon(String name, EntityAmmoType type, int maxAmmo, int ammo, int x, int y, int width, int height, BufferedImage sprite)
  {
    super(x, y, width, height, 0);
    
    this.sprite = sprite;
    this.maxAmmo = maxAmmo;
    this.ammo = ammo;
    this.name = name;
    this.type = type;
  }
  
  @Override
  public boolean isCollected()
  {
    return collected;
  }
  
  @Override
  public void render(Graphics g)
  {
    g.drawImage(sprite, getCamX(), getCamY(), null);
  }
  
  public void renderDummy(Graphics g, boolean invert)
  {
    int x = getCamX();
    int w = width;
    
    if(invert)
    {
      x -= getXOffset() - width;
      w *= -1;
    }
    
    g.drawImage(sprite, x, getCamY(), w, getHeight(), null);
  }
  
  
  public String getName()
  {
    return name;
  }
  
  public EntityAmmoType getAmmoType()
  {
    return type;
  }
  
  public int getMaxAmmo()
  {
    return maxAmmo;
  }
  
  public int getAmmo()
  {
    return ammo;
  }
  
  public void setAmmo(int ammo)
  {
    this.ammo = ammo;
  }
  
  public boolean silentShoot()
  {
    if(ammo <= 0)
    {
      return false;
    }
    
    ammo--;
    return true;
  }
  
  public abstract int getDelay();
  
  public abstract boolean shoot(boolean invert, boolean player);
  
  public abstract int getXOffset();
  
  public abstract int getYOffset();
  
  public abstract int getDamage();
}
