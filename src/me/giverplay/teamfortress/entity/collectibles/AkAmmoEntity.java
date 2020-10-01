package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.EntityAmmo;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class AkAmmoEntity extends EntityAmmo
{
  public AkAmmoEntity(int x, int y, int ammo)
  {
    super("AK-47 Ammo", EntityAmmoType.AK, ammo, 30, x + 8, y + 18, 30, 20, Spritesheet.AMMO_AK);
  }
  
  public AkAmmoEntity(int x, int y)
  {
    this(x, y, 30);
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
