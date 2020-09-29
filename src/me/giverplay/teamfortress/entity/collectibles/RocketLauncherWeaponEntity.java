package me.giverplay.teamfortress.entity.collectibles;

import java.awt.Graphics;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.WeaponEntity;

public class RocketLauncherWeaponEntity extends WeaponEntity
{
  public RocketLauncherWeaponEntity(int x, int y, int ammo)
  {
    super("Rocket Launcher", EntityAmmoType.RPG, 1, ammo, x, y, 47, 21);
  }
  
  public RocketLauncherWeaponEntity(int x, int y)
  {
    this(x, y, 1);
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
