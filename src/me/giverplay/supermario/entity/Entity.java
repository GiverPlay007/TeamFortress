package me.giverplay.supermario.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import me.giverplay.supermario.Game;
import me.giverplay.supermario.algorithms.Node;
import me.giverplay.supermario.algorithms.Vector2i;
import me.giverplay.supermario.world.World;

public class Entity
{
	protected static Random random = new Random();
	private static Game game = Game.getGame();
	
	private final EntityType type;
	
	protected List<Node> path;
	
	protected double x;
	protected double y;
	protected double speed;
	
	private int width;
	private int height;
	private int depth;
	
	public Entity(EntityType type, double x, double y)
	{
		this.x = x;
		this.y = y;
		this.type = type;
		this.width = type.getWidth();
		this.height = type.getHeight();
		
		this.depth = 0;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.drawImage(sprite, getX() - game.getCamera().getX(), getY() - game.getCamera().getY(), width, height, null);
	}
	
	public void destroy()
	{
		game.getEntities().remove(this);
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setDepth(int toSet)
	{
		this.depth = toSet;
	}
	
	public void moveX(double d)
	{
		x += d;
	}
	
	public void moveY(double d)
	{
		y += d;
	}
	
	public int getX()
	{
		return (int) this.x;
	}
	
	public int getY()
	{
		return (int) this.y;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getDepth()
	{
		return this.depth;
	}
	
	public BufferedImage getSprite()
	{
		return this.sprite;
	}
	
	public void followPath(List<Node> path)
	{
		if(path != null)
		{
			if(path.size() > 0)
			{
				Vector2i target = path.get(path.size() - 1).getTile();
				
				if(x < target.x * World.TILE_SIZE)
				{
					x++;
				}
				else if(x > target.x * World.TILE_SIZE)
				{
					x--;
				}
				
				if(y < target.y * World.TILE_SIZE)
				{
					y++;
				}
				else if(y > target.y * World.TILE_SIZE)
				{
					y--;
				}
				
				if(x == target.x * World.TILE_SIZE && y == target.y * World.TILE_SIZE)
					path.remove(path.size() -1);
			}
		}
	}
	
	public double pointDistance(int x1, int y1, int x2, int y2)
	{
		return Math.sqrt((x2 - x1) * (x2 - x1) + ((y2 - y1) * (y2 - y1)));
	}
	
	public static boolean isColliding(Entity e1, Entity e2)
	{
		Rectangle e1m = new Rectangle(e1.getX(), e1.getY(), e1.getWidth(), e1.getHeight());
		Rectangle e2m = new Rectangle(e2.getX(), e2.getY(), e2.getWidth(), e2.getHeight());
		
		return e1m.intersects(e2m);
	}
	
	public static Comparator<Entity> sortDepth = new Comparator<Entity>()
	{
		@Override
		public int compare(Entity e0, Entity e1)
		{
			return (Integer.compare(e0.getDepth(), e1.getDepth()));
		}
	};
}
