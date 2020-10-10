package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.EntityWeapon;
import me.giverplay.teamfortress.entity.entities.BulletEntity;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class AkWeaponEntity extends EntityWeapon
{
  public AkWeaponEntity(int x, int y, int ammo)
  {
    super("AK-47", EntityAmmoType.AK, 30, ammo, x, y + 22, 36, 16, Spritesheet.WEAPON_AK);
  }
  
  public AkWeaponEntity(int x, int y)
  {
    this(x, y, 30);
  }
  
  @Override
  public void collect()
  {
    collected = true;
    game.getPlayer().checkWeaponCollect(this);
    destroy();
  }
  
  @Override
  public boolean shoot(boolean invert)
  {
    int x = getX() + getWidth();
    int dx = 15;
  
    if(invert)
    {
      dx *= -1;
      x -= getWidth() + getXOffset();
    }
  
    game.getEntities().add(new BulletEntity(x, getY() + 2, dx, getDamage()));
    return true;
  }
  
  @Override
  public void tick()
  {
    if(isColliding(game.getPlayer()))
    {
      collect();
    }
  }
  
  @Override
  public int getXOffset()
  {
    return 8;
  }
  
  @Override
  public int getYOffset()
  {
    return 18;
  }
  
  @Override
  public int getDelay()
  {
    return 200;
  }
  
  @Override
  public int getDamage()
  {
    return 5;
  }
}
