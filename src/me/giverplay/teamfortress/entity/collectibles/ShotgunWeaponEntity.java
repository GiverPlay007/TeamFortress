package me.giverplay.teamfortress.entity.collectibles;

import java.awt.Graphics;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.WeaponEntity;

public class ShotgunWeaponEntity extends WeaponEntity
{
  public ShotgunWeaponEntity(int x, int y, int ammo)
  {
    super("Shotgun", EntityAmmoType.SHOTGUN, 8, ammo, x, y, 36, 13);
  }
  
  public ShotgunWeaponEntity(int x, int y)
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
  
  @Override
  public void render(Graphics g)
  {
  
  }
}
