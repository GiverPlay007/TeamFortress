package me.giverplay.teamfortress.entity.entities;

import me.giverplay.teamfortress.entity.EntityHumanType;
import me.giverplay.teamfortress.game.Game;
import me.giverplay.teamfortress.entity.EntityHuman;
import me.giverplay.teamfortress.game.Camera;

public class PlayerEntity extends EntityHuman
{
	private Camera camera;
	
	public PlayerEntity(int x, int y)
	{
		super(EntityHumanType.getRandomBlue(), x, y);
		
		camera = game.getCamera();
		
		setDepth(2);
	}
	
	@Override
	public void tick()
	{
		updateCamera();
	}
	
	private void updateCamera()
	{
		camera.setX(Camera.clamp(this.getX() - (Game.WIDTH / 2), 0, game.getWorld().getWidth() * 16 - Game.WIDTH));
		camera.setY(Camera.clamp(this.getY() - (Game.HEIGHT / 2), 0, game.getWorld().getHeight() * 16 - Game.HEIGHT));
	}
}
