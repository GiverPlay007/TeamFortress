package me.giverplay.teamfortress.entity.entities;

import static me.giverplay.teamfortress.world.World.moveAllowed;

import me.giverplay.teamfortress.entity.EntityHuman;
import me.giverplay.teamfortress.entity.EntityHumanType;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class EnemyEntity extends EntityHuman
{
	private boolean changeDir = false;
	
	public EnemyEntity(double x, double y, EntityHumanType type)
	{
		super(type, x, y);
		
		setDepth(1);
	}
	
	@Override
	public void tick()
	{
		super.tick();
		
		if(moveAllowed(getX() + (changeDir ? -Spritesheet.TILE_SIZE : Spritesheet.TILE_SIZE), (int) (y + 1))
				|| !moveAllowed(getX() + (changeDir ? (int) -speed : (int) -speed), getY()))
		{
			changeDir = !changeDir;
		}
		
		//moveX(changeDir ? -speed : speed);
	}
}
