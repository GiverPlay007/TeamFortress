package me.giverplay.teamfortress.entity.collectibles;

import java.awt.Graphics;
import me.giverplay.teamfortress.entity.AmmoEntity;
import me.giverplay.teamfortress.entity.EntityAmmoType;

public class AkAmmoEntity extends AmmoEntity
{
  public AkAmmoEntity(int x, int y, int ammo)
  {
    super("AK-47 Ammo", EntityAmmoType.AK, ammo, 30, x, y, 19, 13);
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
  
  @Override
  public void render(Graphics g)
  {
  
  }
}
