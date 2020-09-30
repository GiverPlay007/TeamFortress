package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.AmmoEntity;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class RevolverAmmoEntity extends AmmoEntity
{
  public RevolverAmmoEntity(int x, int y, int ammo)
  {
    super("Revolver Ammo", EntityAmmoType.REVOLVER, ammo, 7, x, y, 5, 8, Spritesheet.AMMO_REVOLVER);
  }
  
  public RevolverAmmoEntity(int x, int y)
  {
    this(x, y, 7);
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
