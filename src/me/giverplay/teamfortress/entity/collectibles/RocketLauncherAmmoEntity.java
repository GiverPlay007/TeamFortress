package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.AmmoEntity;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class RocketLauncherAmmoEntity extends AmmoEntity
{
  public RocketLauncherAmmoEntity(int x, int y, int ammo)
  {
    super("Rocket Launcher Ammo", EntityAmmoType.RPG, ammo, 1, x, y, 17, 15, Spritesheet.AMMO_RPG);
  }
  
  public RocketLauncherAmmoEntity(int x, int y)
  {
    this(x, y, 1);
  }
  
  @Override
  public void collect()
  {
  
  }
  
  @Override
  public void tick()
  {
  
  }
}
