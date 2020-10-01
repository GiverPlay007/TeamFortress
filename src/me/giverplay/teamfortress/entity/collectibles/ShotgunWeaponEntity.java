package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.WeaponEntity;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class ShotgunWeaponEntity extends WeaponEntity
{
  public ShotgunWeaponEntity(int x, int y, int ammo)
  {
    super("Shotgun", EntityAmmoType.SHOTGUN, 8, ammo, x, y + 25, 36, 13, Spritesheet.WEAPON_SHOTGUN);
  }
  
  public ShotgunWeaponEntity(int x, int y)
  {
    this(x, y, 8);
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
