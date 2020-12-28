package me.giverplay.teamfortress.entity;

import java.awt.image.BufferedImage;
import java.util.Random;
import me.giverplay.teamfortress.entity.collectibles.AkAmmoEntity;
import me.giverplay.teamfortress.entity.collectibles.AkWeaponEntity;
import me.giverplay.teamfortress.entity.collectibles.LifepackEntity;
import me.giverplay.teamfortress.entity.collectibles.RevolverAmmoEntity;
import me.giverplay.teamfortress.entity.collectibles.RevolverWeaponEntity;
import me.giverplay.teamfortress.entity.collectibles.RocketLauncherAmmoEntity;
import me.giverplay.teamfortress.entity.collectibles.RocketLauncherWeaponEntity;
import me.giverplay.teamfortress.entity.collectibles.ShotgunAmmoEntity;
import me.giverplay.teamfortress.entity.collectibles.ShotgunWeaponEntity;
import me.giverplay.teamfortress.graphics.Spritesheet;

import static me.giverplay.teamfortress.graphics.Cores.LOC_AMMO;
import static me.giverplay.teamfortress.graphics.Cores.LOC_AMMO_AK;
import static me.giverplay.teamfortress.graphics.Cores.LOC_AMMO_REVOLVER;
import static me.giverplay.teamfortress.graphics.Cores.LOC_AMMO_RPG;
import static me.giverplay.teamfortress.graphics.Cores.LOC_AMMO_SHOTGUN;
import static me.giverplay.teamfortress.graphics.Cores.LOC_LIFEPACK;
import static me.giverplay.teamfortress.graphics.Cores.LOC_WEAPON;
import static me.giverplay.teamfortress.graphics.Cores.LOC_WEAPON_AK;
import static me.giverplay.teamfortress.graphics.Cores.LOC_WEAPON_REVOLVER;
import static me.giverplay.teamfortress.graphics.Cores.LOC_WEAPON_RPG;
import static me.giverplay.teamfortress.graphics.Cores.LOC_WEAPON_SHOTGUN;

public enum NonHumanEntityType
{
  LIFE_PACK("Lifepack", Spritesheet.LIFE_PACK, LOC_LIFEPACK),
  
  WEAPON_RAW("Weapon", null, LOC_WEAPON),
  AMMO_RAW("Ammo", null, LOC_AMMO),
  
  WEAPON_AK("AK-47", Spritesheet.WEAPON_AK, LOC_WEAPON_AK),
  WEAPON_RPG("Rocket Launcher", Spritesheet.WEAPON_RPG, LOC_WEAPON_RPG),
  WEAPON_REVOLVER("Revolver", Spritesheet.WEAPON_REVOLVER, LOC_WEAPON_REVOLVER),
  WEAPON_SHOTGUN("Shotgun", Spritesheet.WEAPON_SHOTGUN, LOC_WEAPON_SHOTGUN),
  
  AMMO_AK("AK-47 Ammo", Spritesheet.AMMO_AK, LOC_AMMO_AK),
  AMMO_RPG("Rocket Launcher Ammo", Spritesheet.AMMO_RPG, LOC_AMMO_RPG),
  AMMO_REVOLVER("Revolver Ammo", Spritesheet.AMMO_REVOLVER, LOC_AMMO_REVOLVER),
  AMMO_SHOTGUN("Shotgun Ammo", Spritesheet.AMMO_SHOTGUN, LOC_AMMO_SHOTGUN);
  
  private final String displayName;
  private final BufferedImage sprite;
  
  private final int hexaColor;
  
  NonHumanEntityType(String displayName, BufferedImage sprite, int hexaColor)
  {
    this.displayName = displayName;
    this.sprite = sprite;
    this.hexaColor = hexaColor;
  }
  
  public BufferedImage getSprite()
  {
    return sprite;
  }
  
  public String getDisplayName()
  {
    return displayName;
  }
  
  public int getHexaColor()
  {
    return hexaColor;
  }
  
  public Entity choose(int x, int y, NonHumanEntityType... types)
  {
    return types[new Random().nextInt(types.length)].getNewInstance(x, y);
  }
  
  public Entity getNewInstance(int x, int y)
  {
    switch(this)
    {
      case LIFE_PACK:
        return new LifepackEntity(x, y);
        
      case WEAPON_RAW:
        return choose(x, y, WEAPON_AK, WEAPON_REVOLVER, WEAPON_RPG, WEAPON_SHOTGUN);
      
      case AMMO_RAW:
        return choose(x, y, AMMO_AK, AMMO_REVOLVER, AMMO_RPG, AMMO_SHOTGUN);
      
      case WEAPON_AK:
        return new AkWeaponEntity(x, y);
      
      case WEAPON_RPG:
        return new RocketLauncherWeaponEntity(x, y);
      
      case WEAPON_REVOLVER:
        return new RevolverWeaponEntity(x, y);
      
      case WEAPON_SHOTGUN:
        return new ShotgunWeaponEntity(x, y);
      
      case AMMO_AK:
        return new AkAmmoEntity(x, y);
      
      case AMMO_RPG:
        return new RocketLauncherAmmoEntity(x, y);
      
      case AMMO_REVOLVER:
        return new RevolverAmmoEntity(x, y);
        
      case AMMO_SHOTGUN:
        return new ShotgunAmmoEntity(x, y);
    }
    
    return null;
  }
}
