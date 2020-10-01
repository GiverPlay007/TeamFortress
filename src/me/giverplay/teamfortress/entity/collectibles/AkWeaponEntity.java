package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.WeaponEntity;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class AkWeaponEntity extends WeaponEntity
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
  
  }
  
  @Override
  public boolean shoot()
  {
    return false;
  }
  
  @Override
  public void tick()
  {
  
  }
}
