package me.giverplay.teamfortress.entity.collectibles;
import me.giverplay.teamfortress.entity.EntityAmmoType;
import me.giverplay.teamfortress.entity.EntityWeapon;
import me.giverplay.teamfortress.entity.entities.BulletEntity;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class RevolverWeaponEntity extends EntityWeapon
{
  public RevolverWeaponEntity(int x, int y, int ammo)
  {
    super("Revolver", EntityAmmoType.REVOLVER, 7, ammo, x, y + 17, 21, 15, Spritesheet.WEAPON_REVOLVER);
  }
  
  public RevolverWeaponEntity(int x, int y)
  {
    this(x, y, 7);
  }
  
  @Override
  public boolean shoot(boolean invert)
  {
    int x = getX() + getWidth();
    int dx = 10;
    
    if(invert)
    {
      dx *= -1;
      x -= getWidth() + getXOffset();
    }
    
    game.getEntities().add(new BulletEntity(x, getY() + 1, dx));
    return true;
  }
  
  @Override
  public void collect()
  {
    collected = true;
    game.getPlayer().checkWeaponCollect(this);
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
  
  @Override
  public int getXOffset()
  {
    return 22;
  }
  
  @Override
  public int getYOffset()
  {
    return 16;
  }
}
