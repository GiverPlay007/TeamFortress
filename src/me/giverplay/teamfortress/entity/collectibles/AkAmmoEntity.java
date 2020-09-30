package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.AmmoEntity;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class AkAmmoEntity extends AmmoEntity
{
  public AkAmmoEntity(int x, int y, int ammo)
  {
    super("AK-47 Ammo", EntityAmmoType.AK, ammo, 30, x, y, 19, 13, Spritesheet.AMMO_AK);
  }
  
  public AkAmmoEntity(int x, int y)
  {
    this(x, y, 30);
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
