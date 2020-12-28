package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.EntityAmmo;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class RocketLauncherAmmoEntity extends EntityAmmo
{
  public RocketLauncherAmmoEntity(int x, int y, int ammo)
  {
    super("Rocket Launcher Ammo", EntityAmmoType.RPG, ammo, 1, x + 10, y + 16, 20, 18, Spritesheet.AMMO_RPG);
  }
  
  public RocketLauncherAmmoEntity(int x, int y)
  {
    this(x, y, 1);
  }
  
  @Override
  public void collect()
  {
    collected = true;
    game.getPlayer().checkAmmoCollect(this);
    destroy();
  }
  
  @Override
  public void tick()
  {
    if(isColliding(game.getPlayer()))
    {
      collect();
    }
  }
}
