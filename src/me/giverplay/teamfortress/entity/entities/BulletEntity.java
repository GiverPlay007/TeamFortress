package me.giverplay.teamfortress.entity.entities;

import java.awt.Color;
import java.awt.Graphics;
import me.giverplay.teamfortress.entity.Entity;
import me.giverplay.teamfortress.entity.EntityHuman;

public class BulletEntity extends Entity
{
  private final int dx;
  private final int damage;
  
  public BulletEntity(int x, int y, int dx, int damage)
  {
    super(x, y, 5, 5, 1);
    
    this.dx = dx;
    this.damage = damage;
  }
  
  @Override
  public void tick()
  {
    moveX(dx);
    
    for(int i = 0; i < game.getEntities().size(); i++)
    {
      Entity entity = game.getEntities().get(i);
      
      if(entity instanceof EntityHuman)
      {
        if(!isColliding(entity))
        {
          return;
        }
        
        ((EntityHuman) entity).shootDamage(damage);
        destroy();
        break;
      }
    }
  }
  
  @Override
  public void render(Graphics g)
  {
    g.setColor(Color.YELLOW);
    g.fillRect(getCamX(), getCamY(), getWidth(), getHeight());
  }
}
