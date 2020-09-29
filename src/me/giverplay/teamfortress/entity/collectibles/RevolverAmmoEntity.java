package me.giverplay.teamfortress.entity.collectibles;

import java.awt.Graphics;
import me.giverplay.teamfortress.entity.AmmoEntity;
import me.giverplay.teamfortress.entity.EntityAmmoType;

public class RevolverAmmoEntity extends AmmoEntity
{
  public RevolverAmmoEntity(int x, int y, int ammo)
  {
    super("Revolver Ammo", EntityAmmoType.REVOLVER, ammo, 7, x, y, 5, 8);
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
  
  @Override
  public void render(Graphics g)
  {
  
  }
}
