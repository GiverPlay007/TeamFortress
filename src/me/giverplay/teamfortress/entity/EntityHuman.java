package me.giverplay.teamfortress.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;
import me.giverplay.teamfortress.algorithms.Node;
import me.giverplay.teamfortress.algorithms.Vector2i;

import static me.giverplay.teamfortress.graphics.Spritesheet.TILE_SIZE;
import static me.giverplay.teamfortress.world.World.moveAllowed;

public class EntityHuman extends Entity
{
	private EntityHumanType type;
	
	protected List<Node> path;
	protected volatile BufferedImage[] sprites;
	
	private boolean right;
	private boolean left;
	private boolean walking;
	private boolean jumping;
	private boolean jump;
	
	protected double speed;
	
	private double gravity = 0.4;
	private double vspd = 0;
	
	private int animFrames = 0;
	private int maxAnimFrames = 10;
	private int animIndex;
	
	public EntityHuman(EntityHumanType type, double x, double y)
	{
		super(x, y, type.getWidth(), type.getHeight(), 0);
		
		sprites = type.getIdle();
		
		setType(type);
	}
	
	@Override
	public void tick()
	{
		//checkJump();
		
		if(right)
		{
			x += speed;
		}
		
		if(left)
		{
			x -= speed;
		}
		
		advanceAnim();
	}
	
	private void advanceAnim()
	{
		sprites = type.getIdle();
		//sprites = jumping ? type.getJump() : walking ? type.getWalking() : type.getIdle();
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
	}
	
	@Override
	public void render(Graphics g)
	{
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
	
	public void followPath(List<Node> path)
	{
		if(path != null)
		{
			if(path.size() > 0)
			{
				Vector2i target = path.get(path.size() - 1).getTile();
				
				if(x < target.x * TILE_SIZE)
				{
					x++;
				}
				else if(x > target.x * TILE_SIZE)
				{
					x--;
				}
				
				if(y < target.y * TILE_SIZE)
				{
					y++;
				}
				else if(y > target.y * TILE_SIZE)
				{
					y--;
				}
				
				if(x == target.x * TILE_SIZE && y == target.y * TILE_SIZE)
					path.remove(path.size() -1);
			}
		}
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
}
