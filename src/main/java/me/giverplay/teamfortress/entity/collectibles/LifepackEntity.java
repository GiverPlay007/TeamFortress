package me.giverplay.teamfortress.entity.collectibles;

import java.awt.Graphics;
import me.giverplay.teamfortress.entity.Collectible;
import me.giverplay.teamfortress.entity.Entity;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class LifepackEntity extends Entity implements Collectible
{
  private boolean collected;
  
  public LifepackEntity(int x, double y)
  {
    super(x + 10, y + 18, 20, 20, 0);
  }
  
  @Override
  public void collect()
  {
    collected = true;
    game.getPlayer().checkHeal();
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
  public boolean isCollected()
  {
    return collected;
  }
  
  @Override
  public void render(Graphics g)
  {
    g.drawImage(Spritesheet.LIFE_PACK, getCamX(), getCamY(), width, height, null);
  }
}
