package me.giverplay.teamfortress.entity;

public abstract class WeaponEntity extends Entity implements Collectible
{
  protected EntityAmmoType type;
  private String name;
  
  protected int maxAmmo;
  protected int ammo;
  
  public WeaponEntity(String name, EntityAmmoType type, int maxAmmo, int ammo)
  {
    this.maxAmmo = maxAmmo;
    this.ammo = ammo;
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public EntityAmmoType getAmmoType()
  {
    return type;
  }
  
  public int getMaxAmmo()
  {
    return maxAmmo;
  }
  
  public int getAmmo()
  {
    return ammo;
  }
  
  public void setAmmo(int ammo)
  {
    this.ammo = ammo;
  }
}
