package me.giverplay.teamfortress.entity.entities;

import static me.giverplay.teamfortress.world.World.moveAllowed;


import me.giverplay.teamfortress.entity.EntityHuman;
import me.giverplay.teamfortress.entity.EntityHumanType;
import me.giverplay.teamfortress.world.World;

public class Enemy extends EntityHuman
{
	private boolean changeDir = false;
	
	public Enemy(double x, double y, EntityHumanType type)
	{
		super(type, x, y);
		
		setDepth(1);
	}
	
	@Override
	public void tick()
	{
		if(moveAllowed(getX() + (changeDir ? -World.TILE_SIZE : World.TILE_SIZE), (int) (y + 1))
				|| !moveAllowed(getX() + (changeDir ? (int) -speed : (int) -speed), getY()))
		{
			changeDir = !changeDir;
		}
		
		moveX(changeDir ? -speed : speed);
	}
	
	@Override
	public void destroy()
	{
		super.destroy();
		game.addEnemyCount();
	}
}
