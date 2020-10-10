package me.giverplay.teamfortress.entity.entities;

import me.giverplay.teamfortress.entity.EntityHumanType;
import me.giverplay.teamfortress.game.Game;
import me.giverplay.teamfortress.entity.EntityHuman;
import me.giverplay.teamfortress.game.Camera;
import me.giverplay.teamfortress.game.Keys;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class PlayerEntity extends EntityHuman
{
	public PlayerEntity(int x, int y)
	{
		super(EntityHumanType.getRandomBlue(), x, y);
		
		setMaxLife(50);
		setLife(50);
		setDepth(2);
		setSpeed(3);
	}
	
	@Override
	public void tick()
	{
	  moveRight(Keys.right);
	  moveLeft(Keys.left);
   
	  if(Keys.jump)
    {
      jump();
    }
	  
	  if(Keys.reload)
		{
			reload();
		}
	 
		super.tick();
		updateCamera();
	}
	
	private void updateCamera()
	{
		camera.setX(Camera.clamp(this.getX() - (Game.WIDTH / 2), 0, game.getWorld().getWidth() * Spritesheet.TILE_SIZE - Game.WIDTH));
		camera.setY(Camera.clamp(this.getY() - (Game.HEIGHT / 2), 0, game.getWorld().getHeight() * Spritesheet.TILE_SIZE - Game.HEIGHT));
	}
}
