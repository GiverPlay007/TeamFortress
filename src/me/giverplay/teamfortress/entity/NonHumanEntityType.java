package me.giverplay.teamfortress.entity;

import java.awt.image.BufferedImage;


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
import static me.giverplay.teamfortress.graphics.Spritesheet.AMMO_AK;
import static me.giverplay.teamfortress.graphics.Spritesheet.AMMO_REVOLVER;
import static me.giverplay.teamfortress.graphics.Spritesheet.AMMO_RPG;
import static me.giverplay.teamfortress.graphics.Spritesheet.AMMO_SHOTGUN;
import static me.giverplay.teamfortress.graphics.Spritesheet.LIFE_PACK;
import static me.giverplay.teamfortress.graphics.Spritesheet.WEAPON_AK;
import static me.giverplay.teamfortress.graphics.Spritesheet.WEAPON_REVOLVER;
import static me.giverplay.teamfortress.graphics.Spritesheet.WEAPON_RPG;
import static me.giverplay.teamfortress.graphics.Spritesheet.WEAPON_SHOTGUN;

public enum NonHumanEntityType
{
  COLLECTIBLE_LIFEPACK("Lifepack", LIFE_PACK, LOC_LIFEPACK),
  
  COLLECTIBLE_WEAPON_RAW("Weapon", null, LOC_WEAPON),
  COLLECTIBLE_AMMO_RAW("Ammo", null, LOC_AMMO),
  
  COLLECTIBLE_WEAPON_AK("AK-47", WEAPON_AK, LOC_WEAPON_AK),
  COLLECTIBLE_WEAPON_RPG("Rocket Launcher", WEAPON_RPG, LOC_WEAPON_RPG),
  COLLECTIBLE_WEAPON_REVOLVER("Revolver", WEAPON_REVOLVER, LOC_WEAPON_REVOLVER),
  COLLECTIBLE_WEAPON_SHOTGUN("Shotgun", WEAPON_SHOTGUN, LOC_WEAPON_SHOTGUN),
  
  COLLECTIBLE_AMMO_AK("AK-47 Ammo", AMMO_AK, LOC_AMMO_AK),
  COLLECTIBLE_AMMO_RPG("Rocket Launcher Ammo", AMMO_RPG, LOC_AMMO_RPG),
  COLLECTIBLE_AMMO_REVOLVER("Revolver Ammo", AMMO_REVOLVER, LOC_AMMO_REVOLVER),
  COLLECTIBLE_AMMO_SHOTGUN("Shotgun Ammo", AMMO_SHOTGUN, LOC_AMMO_SHOTGUN);
  
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
  
  public Entity getNewInstance(int x, int y)
  {
    return null;
  }
}
