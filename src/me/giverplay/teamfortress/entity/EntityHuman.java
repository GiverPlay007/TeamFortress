package me.giverplay.teamfortress.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import me.giverplay.teamfortress.game.Game;
import me.giverplay.teamfortress.algorithms.Node;
import me.giverplay.teamfortress.algorithms.Vector2i;
import me.giverplay.teamfortress.world.World;


import static me.giverplay.teamfortress.world.World.moveAllowed;

public class EntityHuman
{
	protected static Random random = new Random();
	protected static Game game = Game.getGame();
	
	private EntityHumanType type;
	
	protected List<Node> path;
	
	private boolean right;
	private boolean left;
	private boolean walking;
	private boolean jumping;
	private boolean jump;
	
	protected double x;
	protected double y;
	protected double speed;
	
	private double gravity = 0.4;
	private double vspd = 0;
	
	private int width;
	private int height;
	private int depth;
	private int animFrames = 0;
	private int maxAnimFrames = 10;
	private int animIndex;
	
	public EntityHuman(EntityHumanType type, double x, double y)
	{
		this.x = x;
		this.y = y;
		
		setType(type);
		setDepth(0);
	}
	
	public void tick()
	{
		checkJump();
		
		if(right)
		{
			x += speed;
		}
		
		if(left)
		{
			x -= speed;
		}
	}
	
	public void render(Graphics g)
	{
		BufferedImage[] sprites = jumping ? type.getJump() : walking ? type.getWalking() : type.getIdle();
		
		animFrames++;
		
		if(animFrames >= maxAnimFrames)
		{
			animFrames = 0;
			animIndex++;
			
			if(animIndex >= sprites.length)
			{
				animIndex = 0;
			}
		}
		
		g.drawImage(sprites[animIndex], getX() - game.getCamera().getX(), getY() - game.getCamera().getY(), width, height, null);
	}
	
	public void setType(EntityHumanType type)
	{
		this.type = type;
		this.width = type.getWidth();
		this.height = type.getHeight();
	}
	
	protected void checkJump()
	{
		vspd += gravity;
		
		if (jump && !moveAllowed(getX(), (int) (y + 1)) && moveAllowed(getX(), (int) (y -1)))
		{
			vspd = -6;
			jumping = true;
		}
		
		if (!moveAllowed((int) x, (int) (y + vspd)))
		{
			int signVsp = 0;
			
			if (vspd >= 0)
			{
				signVsp = 1;
			}
			else
			{
				signVsp = -1;
			}
			
			while (moveAllowed((int) x, (int) (y + signVsp)))
			{
				y = y + signVsp;
			}
			
			vspd = 0;
		}
		
		y = y + vspd;
		
		walking = false;
		
		if (!(right && left))
		{
			if (right)
			{
				if (moveAllowed((int) (x + speed), getY()))
				{
					moveX(speed);
					
					if (!jumping)
					{
						walking = true;
					}
				}
				
			} else if (left)
			{
				if (moveAllowed((int) (x - speed), getY()))
				{
					moveX(-speed);
					
					if (!jumping)
					{
						walking = true;
					}
				}
			}
		}
		
		jump = false;
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
	
	public static boolean isColliding(EntityHuman e1, EntityHuman e2)
	{
		Rectangle e1m = new Rectangle(e1.getX(), e1.getY(), e1.getWidth(), e1.getHeight());
		Rectangle e2m = new Rectangle(e2.getX(), e2.getY(), e2.getWidth(), e2.getHeight());
		
		return e1m.intersects(e2m);
	}
	
	public void jump()
	{
		jump = true;
	}
	
	public void moveRight(boolean right)
	{
		this.right = right;
	}
	
	public void moveLeft(boolean left)
	{
		this.left = left;
	}
	
	public boolean isJumping()
	{
		return this.jumping;
	}
	
	public static Comparator<EntityHuman> sortDepth = Comparator.comparingInt(EntityHuman::getDepth);
}
