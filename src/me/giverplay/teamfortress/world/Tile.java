package me.giverplay.teamfortress.world;

import static me.giverplay.teamfortress.world.World.TILE_SIZE;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.giverplay.teamfortress.game.Game;

public class Tile
{
	private static Game game = Game.getGame();

	private BufferedImage sprite;
	
	private boolean isRigid;
	
	private int x, y;
	
	public Tile(int x, int y, boolean isRigid, BufferedImage sprite)
	{
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.isRigid = isRigid;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(sprite, x - game.getCamera().getX(), y - game.getCamera().getY(), null);
	}
	
	public boolean isRigid()
	{
		return this.isRigid;
	}
}
