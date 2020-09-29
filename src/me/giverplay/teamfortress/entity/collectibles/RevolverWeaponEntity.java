package me.giverplay.teamfortress.entity.collectibles;

import java.awt.Graphics;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.WeaponEntity;

public class RevolverWeaponEntity extends WeaponEntity
{
  public RevolverWeaponEntity(int x, int y, int ammo)
  {
    super("Revolver", EntityAmmoType.REVOLVER, 7, ammo, x, y, 21, 15);
  }
  
  public RevolverWeaponEntity(int x, int y)
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
  
  @Override
  public void render(Graphics g)
  {
  
  }
}
