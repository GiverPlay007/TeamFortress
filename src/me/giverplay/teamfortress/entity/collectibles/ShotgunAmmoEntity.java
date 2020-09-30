package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.AmmoEntity;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class ShotgunAmmoEntity extends AmmoEntity
{
  public ShotgunAmmoEntity(int x, int y, int ammo)
  {
    super("Shotgun Ammo", EntityAmmoType.SHOTGUN, ammo, 8, x, y, 9, 6, Spritesheet.AMMO_SHOTGUN);
  }
  
  public ShotgunAmmoEntity(int x, int y)
  {
    this(x, y, 8);
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
