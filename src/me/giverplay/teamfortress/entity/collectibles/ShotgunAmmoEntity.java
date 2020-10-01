package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.EntityAmmo;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class ShotgunAmmoEntity extends EntityAmmo
{
  public ShotgunAmmoEntity(int x, int y, int ammo)
  {
    super("Shotgun Ammo", EntityAmmoType.SHOTGUN, ammo, 8, x + 8, y + 22, 22, 14, Spritesheet.AMMO_SHOTGUN);
  }
  
  public ShotgunAmmoEntity(int x, int y)
  {
    this(x, y, 8);
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
