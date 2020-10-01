package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.EntityWeapon;
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
  public boolean shoot()
  {
    return false;
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
}
