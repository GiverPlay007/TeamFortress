package me.giverplay.teamfortress.entity.collectibles;

import me.giverplay.teamfortress.entity.AmmoEntity;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.NonHumanEntityType;

public class AkAmmoEntity extends AmmoEntity
{
  public AkAmmoEntity(int ammo)
  {
    super(NonHumanEntityType.COLLECTIBLE_AMMO_AK.getDisplayName(), EntityAmmoType.AK, ammo, 30);
  }
  
  public AkAmmoEntity()
  {
    this(30);
  }
  
  @Override
  public void collect()
  {
  
  }
}
