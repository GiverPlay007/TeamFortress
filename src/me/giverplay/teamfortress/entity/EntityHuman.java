package me.giverplay.teamfortress.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import me.giverplay.teamfortress.algorithms.Node;
import me.giverplay.teamfortress.algorithms.Vector2i;
import me.giverplay.teamfortress.entity.entities.PlayerEntity;
import me.giverplay.teamfortress.game.Keys;


import static me.giverplay.teamfortress.graphics.Spritesheet.TILE_SIZE;
import static me.giverplay.teamfortress.world.World.moveAllowed;

public class EntityHuman extends Entity
{
	protected EntityWeapon weapon;
	protected EntityHumanType type;
	
	protected List<EntityWeapon> weapons = new ArrayList<>();
	protected List<Node> path;
	
	protected BufferedImage[] sprites;
	
	protected boolean invert;
	protected boolean right;
	protected boolean left;
	private boolean walking;
	private boolean onAir;
	private boolean jump;
	
	protected double speed = 2;
	
	private double gravity = 0.4;
	private double vspd = 0;
	
	protected long lastShoot;
	
	protected int ammoAk = 0;
	protected int ammoRpg = 0;
	protected int ammoRevolver = 0;
	protected int ammoShotgun = 0;
	protected int weaponIndex = 0;
	
	private int animFrames = 0;
	private int maxAnimFrames = 10;
	private int animIndex;
	private int life = 10;
	private int maxLife = 10;
	
	public EntityHuman(EntityHumanType type, int x, double y)
	{
		super(x, y, type.getWidth(), type.getHeight(), 0);
		
		sprites = type.getIdle();
		setType(type);
	}
	
	@Override
	public void tick()
	{
		if(life <= 0)
		{
			destroy();
			return;
		}
		
		checkJump();
		checkWalk();
		checkShoot();
		advanceAnim();
	}
	
	private void advanceAnim()
	{
		sprites = onAir ? type.getJump() : walking ? type.getWalking() : type.getIdle();
		++animFrames;
		
		if(animFrames >= maxAnimFrames)
		{
			animFrames = 0;
			++animIndex;
			
			if(animIndex >= sprites.length)
			{
				animIndex = 0;
			}
		}
	}
	
	protected void checkShoot()
	{
		if(!Keys.shoot)
		{
			return;
		}
		
		if(weapon != null)
		{
			if(System.currentTimeMillis() - lastShoot >= weapon.getDelay())
			{
				if(weapon.silentShoot())
				{
					weapon.shoot(invert, this instanceof PlayerEntity);
					lastShoot = System.currentTimeMillis();
				}
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
		
		if(weapon != null)
		{
			weapon.setX(getX() + weapon.getXOffset());
			weapon.setY(getY() + weapon.getYOffset());
			weapon.renderDummy(g, invert);
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
			int signVsp = vspd >= 0 ? 1 : -1;
			
			while (moveAllowed(x, (int) (y + signVsp)))
			{
				y += signVsp;
			}
			
			vspd = 0;
		}
		
		y += vspd;
		jump = false;
		
		onAir = vspd != 0;
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
	
	public void setSpeed(double speed)
	{
		this.speed = speed;
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
	
	public boolean isOnAir()
	{
		return this.onAir;
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
		return this.weapon;
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
			this.weapon = weapon;
		}
		
		return true;
	}
	
	public void reload()
	{
		if(weapon == null || weapon.getAmmo() == weapon.getMaxAmmo() || getAmmo(weapon.getAmmoType()) < 1)
		{
			return;
		}
		
		int result = getAmmo(weapon.getAmmoType()) - (weapon.getMaxAmmo() - weapon.getAmmo());
		
		if(result >= 0)
    {
      setAmmo(weapon.getAmmoType(), result);
      weapon.setAmmo(weapon.getMaxAmmo());
      return;
    }
		
		setAmmo(weapon.getAmmoType(), 0);
		weapon.setAmmo(weapon.getMaxAmmo() - getAmmo(weapon.getAmmoType()));
	}
	
	public int getAmmo(EntityAmmoType type)
	{
		switch(type)
		{
			case RPG:
				return ammoRpg;
			case AK:
				return ammoAk;
			case SHOTGUN:
				return ammoShotgun;
			case REVOLVER:
				return ammoRevolver;
		}
		
		return -1;
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
	
	public void setAmmo(EntityAmmoType type, int amount)
  {
    switch(type)
    {
      case AK:
        ammoAk = amount;
        break;
    
      case RPG:
        ammoRpg = amount;
        break;
    
      case REVOLVER:
        ammoRevolver = amount;
        break;
    
      case SHOTGUN:
        ammoShotgun = amount;
        break;
    }
  }
	
	public void checkHeal()
	{
		life += 10;
		
		if(life >= maxLife)
		{
			life = maxLife;
		}
	}
	
	public void shootDamage(int damage)
	{
		life -= damage;
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
		
		weapon = weapons.get(weaponIndex);
	}
	
	public int getLife()
	{
		return this.life;
	}
	
	public int getMaxLife()
	{
		return this.maxLife;
	}
	
	public void setLife(int life)
	{
		this.life = life;
	}
	
	public void setMaxLife(int maxLife)
	{
		this.maxLife = maxLife;
	}
}
