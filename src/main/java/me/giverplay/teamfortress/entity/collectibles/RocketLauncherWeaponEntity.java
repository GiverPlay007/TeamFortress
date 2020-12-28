package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.EntityWeapon;
import me.giverplay.teamfortress.entity.entities.BulletEntity;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class RocketLauncherWeaponEntity extends EntityWeapon
{
  public RocketLauncherWeaponEntity(int x, int y, int ammo)
  {
    super("Rocket Launcher", EntityAmmoType.RPG, 1, ammo, x, y + 17, 47, 21, Spritesheet.WEAPON_RPG);
  }
  
  public RocketLauncherWeaponEntity(int x, int y)
  {
    this(x, y, 1);
  }
  
  @Override
  public boolean shoot(boolean invert, boolean player)
  {
    int x = getX() + getWidth();
    int dx = 10;
  
    if(invert)
    {
      dx *= -1;
      x -= getWidth() + getXOffset();
    }
  
    game.getEntities().add(new BulletEntity(x, getY() + 6, dx, getDamage(), player));
    return true;
  }
  
  @Override
  public void collect()
  {
    collected = true;
    game.getPlayer().checkWeaponCollect(this);
    destroy();
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
  public int getDelay()
  {
    return 2000;
  }
  
  @Override
  public int getXOffset()
  {
    return -10;
  }
  
  @Override
  public int getYOffset()
  {
    return 14;
  }
  
  @Override
  public int getDamage()
  {
    return 50;
  }
}
