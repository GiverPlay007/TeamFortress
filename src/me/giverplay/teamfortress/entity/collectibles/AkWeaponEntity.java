package me.giverplay.teamfortress.entity.collectibles;

import java.awt.Graphics;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.WeaponEntity;

public class AkWeaponEntity extends WeaponEntity
{
  public AkWeaponEntity(int x, int y, int ammo)
  {
    super("AK-47", EntityAmmoType.AK, 30, ammo, x, y, 36, 16);
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
  public void tick()
  {
  
  }
  
  @Override
  public void render(Graphics g)
  {
  
  }
}
