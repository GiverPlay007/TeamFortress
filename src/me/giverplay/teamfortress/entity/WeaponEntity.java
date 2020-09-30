package me.giverplay.teamfortress.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class WeaponEntity extends Entity implements Collectible
{
  protected EntityAmmoType type;
  private BufferedImage sprite;
  private String name;
  
  protected int maxAmmo;
  protected int ammo;
  
  public WeaponEntity(String name, EntityAmmoType type, int maxAmmo, int ammo, int x, int y, int width, int height, BufferedImage sprite)
  {
    super(x, y, width, height, 0);
    
    this.sprite = sprite;
    this.maxAmmo = maxAmmo;
    this.ammo = ammo;
    this.name = name;
  }
  
  @Override
  public void render(Graphics g)
  {
    g.drawImage(sprite, getX(), getY(), null);
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
  
  public abstract boolean shoot();
}
