package me.giverplay.teamfortress.entity.entities;

import java.awt.Color;
import java.awt.Graphics;
import me.giverplay.teamfortress.entity.Entity;
import me.giverplay.teamfortress.entity.EntityHuman;

public class BulletEntity extends Entity
{
  private final boolean player;
  private final int dx;
  private final int damage;
  
  public BulletEntity(int x, int y, int dx, int damage, boolean player)
  {
    super(x, y, 5, 5, 1);
    
    this.player = player;
    this.dx = dx;
    this.damage = damage;
  }
  
  @Override
  public void tick()
  {
    for(int i = 0; i < game.getEntities().size(); i++)
    {
      Entity entity = game.getEntities().get(i);
      
      if(player && (entity instanceof PlayerEntity))
      {
        continue;
      }
      
      if(entity instanceof EntityHuman)
      {
        if(isColliding(entity))
        {
          ((EntityHuman) entity).shootDamage(damage);
          destroy();
          break;
        }
      }
    }
    
    moveX(dx);
  }
  
  @Override
  public void render(Graphics g)
  {
    g.setColor(Color.YELLOW);
    g.fillRect(getCamX(), getCamY(), getWidth(), getHeight());
  }
}
