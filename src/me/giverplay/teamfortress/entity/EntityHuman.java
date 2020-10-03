package me.giverplay.teamfortress.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import me.giverplay.teamfortress.algorithms.Node;
import me.giverplay.teamfortress.algorithms.Vector2i;


import static me.giverplay.teamfortress.graphics.Spritesheet.TILE_SIZE;
import static me.giverplay.teamfortress.world.World.moveAllowed;

public class EntityHuman extends Entity
{
	protected EntityWeapon equippedWeapon;
	protected EntityHumanType type;
	
	protected List<EntityWeapon> weapons = new ArrayList<>();
	protected List<Node> path;
	
	protected BufferedImage[] sprites;
	
	private boolean right;
	private boolean left;
	private boolean walking;
	private boolean jumping;
	private boolean jump;
	private boolean invert;
	
	protected double speed = 2;
	
	private double gravity = 0.4;
	private double vspd = 0;
	
	protected int ammoAk = 0;
	protected int ammoRpg = 0;
	protected int ammoRevolver = 0;
	protected int ammoShotgun = 0;
	protected int weaponIndex = 0;
	
	private int animFrames = 0;
	private int maxAnimFrames = 10;
	private int animIndex;
	
	public EntityHuman(EntityHumanType type, int x, double y)
	{
		super(x, y, type.getWidth(), type.getHeight(), 0);
		
		sprites = type.getIdle();
		
		setType(type);
	}
	
	@Override
	public void tick()
	{
		checkJump();
		checkWalk();
		advanceAnim();
	}
	
	private void advanceAnim()
	{
		sprites = jumping ? type.getJump() : walking ? type.getWalking() : type.getIdle();
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
		// Little hack
		if(animIndex >= sprites.length)
		{
			animIndex = 0;
		}
		
		int x = getCamX();
		int w = width;
		
		if(invert)
		{
			x += width;
			w *= -1;
		}
		
		g.drawImage(sprites[animIndex], x, getCamY(), w, height, null);
		
		if(equippedWeapon != null)
		{
			equippedWeapon.setX(getX() + equippedWeapon.getXOffset());
			equippedWeapon.setY(getY() + equippedWeapon.getYOffset());
			equippedWeapon.renderDummy(g, invert);
		}
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
			vspd = -8;
		}
		
		if (!moveAllowed(x, (int) (y + vspd)))
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
			
			while (moveAllowed(x, (int) (y + signVsp)))
			{
				y = y + signVsp;
			}
			
			vspd = 0;
		}
		
		y = y + vspd;
		jump = false;
		
		jumping = vspd != 0;
	}
	
	protected void checkWalk()
	{
		walking = false;
		
		if (right)
		{
			if (moveAllowed((int) (x + speed), getY()))
			{
				moveX(speed);
				walking = true;
				invert = false;
			}
		}
		
		if (left)
		{
			if (moveAllowed((int) (x - speed), getY()))
			{
				moveX(-speed);
				walking = true;
				invert = true;
			}
		}
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
	
	public int getAmmoAk()
	{
		return ammoAk;
	}
	
	public void setAmmoAk(int ammoAk)
	{
		this.ammoAk = ammoAk;
	}
	
	public int getAmmoRevolver()
	{
		return ammoRevolver;
	}
	
	public int getAmmoRpg()
	{
		return ammoRpg;
	}
	
	public int getAmmoShotgun()
	{
		return ammoShotgun;
	}
	
	public void setAmmoRevolver(int ammoRevolver)
	{
		this.ammoRevolver = ammoRevolver;
	}
	
	public void setAmmoRpg(int ammoRpg)
	{
		this.ammoRpg = ammoRpg;
	}
	
	public void setAmmoShotgun(int ammoShotgun)
	{
		this.ammoShotgun = ammoShotgun;
	}
	
	public EntityWeapon getEquippedWeapon()
	{
		return this.equippedWeapon;
	}
	
	public boolean checkWeaponCollect(EntityWeapon weapon)
	{
		if(weapons.size() == 4)
		{
			return false;
		}
		
		for(EntityWeapon w : weapons)
		{
			if(w.getAmmoType() == weapon.getAmmoType())
			{
				return false;
			}
		}
		
		weapons.add(weapon);
		
		if(weapons.size() == 1)
		{
			equippedWeapon = weapon;
		}
		
		return true;
	}
	
	public void checkAmmoCollect(EntityAmmo ammo)
	{
		switch(ammo.getType())
		{
			case AK:
				ammoAk += ammo.getCurrentItems();
				break;
				
			case RPG:
				ammoRpg += ammo.getCurrentItems();
				break;
				
			case REVOLVER:
				ammoRevolver += ammo.getCurrentItems();
				break;
				
			case SHOTGUN:
				ammoShotgun += ammo.getCurrentItems();
				break;
		}
	}
	
	public void checkHeal()
	{
	
	}
	
	public void changeWeapon()
	{
		if(weapons.isEmpty())
		{
			return;
		}
		
		weaponIndex++;
		
		if(weaponIndex >= weapons.size())
		{
			weaponIndex = 0;
		}
		
		equippedWeapon = weapons.get(weaponIndex);
	}
}
