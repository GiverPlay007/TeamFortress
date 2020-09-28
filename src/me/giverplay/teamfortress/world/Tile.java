package me.giverplay.teamfortress.world;

import java.awt.Graphics;
import me.giverplay.teamfortress.game.Game;

public class Tile
{
	protected static final Game game = Game.getGame();
	private final int x, y;
	
	private TileType type;
	
	public Tile(TileType type, int x, int y)
	{
		this.x = x;
		this.y = y;
		
		setType(type);
	}
	
	public void render(Graphics g)
	{
		if(type == TileType.AIR)
		{
			return;
		}
		
		g.drawImage(type.getSprite(), x - game.getCamera().getX(), y - game.getCamera().getY(), null);
	}
	
	public boolean isRigid()
	{
		return type.isRigid();
	}
	
	public void setType(TileType type)
	{
		this.type = type;
	}
	
	public TileType getType()
	{
		return this.type;
	}
}
