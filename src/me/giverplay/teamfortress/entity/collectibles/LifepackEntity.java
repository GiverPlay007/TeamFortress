package me.giverplay.teamfortress.entity.collectibles;

import java.awt.Graphics;
import me.giverplay.teamfortress.entity.Collectible;
import me.giverplay.teamfortress.entity.Entity;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class LifepackEntity extends Entity implements Collectible
{
  public LifepackEntity(int x, double y)
  {
    super(x, y, 10, 10, 0);
  }
  
  @Override
  public void collect()
  {
  
  }
  
  @Override
  public void tick()
  {
  
  }
  
  @Override
  public void render(Graphics g)
  {
    g.drawImage(Spritesheet.LIFE_PACK, getX() - camera.getX(), getY() - camera.getY(), width * 2, height * 2, null);
  }
}
