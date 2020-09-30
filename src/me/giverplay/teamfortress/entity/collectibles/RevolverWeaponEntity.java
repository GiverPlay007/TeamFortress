package me.giverplay.teamfortress.entity.collectibles;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.WeaponEntity;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class RevolverWeaponEntity extends WeaponEntity
{
  public RevolverWeaponEntity(int x, int y, int ammo)
  {
    super("Revolver", EntityAmmoType.REVOLVER, 7, ammo, x, y, 21, 15, Spritesheet.WEAPON_REVOLVER);
  }
  
  public RevolverWeaponEntity(int x, int y)
  {
    this(x, y, 7);
  }
  
  @Override
  public boolean shoot()
  {
    return false;
  }
  
  @Override
  public void collect()
  {
  
  }
  
  @Override
  public void tick()
  {
  
  }
}
