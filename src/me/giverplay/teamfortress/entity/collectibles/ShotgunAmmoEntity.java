package me.giverplay.teamfortress.entity.collectibles;

import java.awt.Graphics;
import me.giverplay.teamfortress.entity.AmmoEntity;
import me.giverplay.teamfortress.entity.EntityAmmoType;

public class ShotgunAmmoEntity extends AmmoEntity
{
  public ShotgunAmmoEntity(int x, int y, int ammo)
  {
    super("Shotgun Ammo", EntityAmmoType.SHOTGUN, ammo, 8, x, y, 9, 6);
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
  
  @Override
  public void render(Graphics g)
  {
  
  }
}
