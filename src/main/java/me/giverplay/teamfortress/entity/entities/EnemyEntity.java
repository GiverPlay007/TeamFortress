package me.giverplay.teamfortress.entity.entities;

import static me.giverplay.teamfortress.world.World.moveAllowed;

import me.giverplay.teamfortress.entity.EntityHuman;
import me.giverplay.teamfortress.entity.EntityHumanType;
import me.giverplay.teamfortress.graphics.Spritesheet;

public class EnemyEntity extends EntityHuman
{
	private boolean changeDir = false;
	
	public EnemyEntity(int x, double y, EntityHumanType type)
	{
		super(type, x, y);
		
		setDepth(1);
		setSpeed(1);
	}
	
	public EnemyEntity(int x, double y)
	{
		this(x, y, EntityHumanType.getRandomPink());
	}
	
	@Override
	public void tick()
	{
		if(moveAllowed(getX() + (changeDir ? -Spritesheet.TILE_SIZE : Spritesheet.TILE_SIZE), (int) (y + 1))
				|| !moveAllowed(getX() + (changeDir ? (int) -speed : (int) -speed), getY()))
		{
			changeDir = !changeDir;
			invert = changeDir;
			left = changeDir;
			right = !changeDir;
		}
		
		moveX(invert ? -speed : speed);
		super.tick();
	}
}
