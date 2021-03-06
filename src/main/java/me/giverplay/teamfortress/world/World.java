package me.giverplay.teamfortress.world;

import static me.giverplay.teamfortress.graphics.Spritesheet.TILE_SIZE;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.giverplay.teamfortress.entity.NonHumanEntityType;
import me.giverplay.teamfortress.entity.collectibles.RocketLauncherWeaponEntity;
import me.giverplay.teamfortress.entity.entities.EnemyEntity;
import me.giverplay.teamfortress.game.Game;
import me.giverplay.teamfortress.game.Camera;
import me.giverplay.teamfortress.graphics.Cores;

public class World
{
	private static Tile[] tiles;
	
	private BufferedImage map;
	private Camera camera;
	private Game game;
	
	private int width;
	private int height;
	
	public World()
	{
		game = Game.getGame();
		camera = game.getCamera();
		
		try
		{
			map = ImageIO.read(getClass().getResource("/images/Level.png"));
		}
		catch (IOException e)
		{
			System.out.println("Falha ao ler o mapa");
		}
		
		initializeWorld();
	}
	
	private void initializeWorld()
	{
		width = map.getWidth();
		height = map.getHeight();
		
		int length = width * height;
		int[] pixels = new int[length];
		
		tiles = new Tile[length];
		
		map.getRGB(0, 0, width, height, pixels, 0, width);
		
		for(int xx = 0; xx < width; xx++)
		{
			for(int yy = 0; yy < height; yy++)
			{
				final int index = xx + (yy * width);
				
				tiles[index] = new Tile(TileType.AIR, xx * TILE_SIZE, yy * TILE_SIZE);
				
				checkTiles(index, pixels[index]);
				checkCollectibles(xx, yy, pixels[index]);
				checkHumanEntities(xx, yy, pixels[index]);
			}
		}
	}
	
	private void checkTiles(int index, int pixel)
	{
		for(TileType type : TileType.values())
		{
			if(type.getHexaColor() == pixel)
			{
				tiles[index].setType(type);
			}
		}
	}
	
	private void checkCollectibles(int x, int y, int pixel)
	{
		for(NonHumanEntityType type : NonHumanEntityType.values())
		{
			if(pixel == type.getHexaColor())
			{
				game.getEntities().add(type.getNewInstance(x * TILE_SIZE, y * TILE_SIZE));
				break;
			}
		}
	}
	
	private void checkHumanEntities(int x, int y, int pixel)
	{
		switch(pixel)
		{
			case Cores.LOC_ENEMY:
				game.getEntities().add(new EnemyEntity(x * TILE_SIZE, y * TILE_SIZE));
				break;
				
			case Cores.LOC_ENEMY_FRANCO:
				EnemyEntity enemy = new EnemyEntity(x * TILE_SIZE, y * TILE_SIZE);
				enemy.checkWeaponCollect(new RocketLauncherWeaponEntity(x, y));
				game.getEntities().add(enemy);
				break;
				
			case Cores.LOC_PLAYER:
				game.getPlayer().setLocation(x * TILE_SIZE, y * TILE_SIZE);
				break;
		}
	}
	
	public void render(Graphics g)
	{
		int xs = camera.getX() / TILE_SIZE;
		int ys = camera.getY() / TILE_SIZE;
		int xf = (camera.getX() + Game.WIDTH) / TILE_SIZE;
		int yf = (camera.getY() + Game.HEIGHT) / TILE_SIZE;
		
		for (int xx = xs; xx <= xf; xx++)
		{
			for (int yy = ys; yy <= yf; yy++)
			{
				if (xx < xs || yy < ys || xx >= width || yy >= height)
				{
					continue;
				}
				
				Tile tile = tiles[xx + yy * width];
				
				if (tile != null)
					tile.render(g);
			}
		}
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public Tile[] getTiles()
	{
		return tiles;
	}
	
	public static boolean moveAllowed(int xn, int yn)
	{
		int x1 = xn / TILE_SIZE;
		int y1 = yn / TILE_SIZE;
		
		int x2 = (xn + TILE_SIZE -1) / TILE_SIZE;
		int y2 = yn / TILE_SIZE;
		
		int x3 = xn / TILE_SIZE;
		int y3 = (yn + TILE_SIZE -1) / TILE_SIZE;
		
		int x4 = (xn + TILE_SIZE -1) / TILE_SIZE;
		int y4 = (yn + TILE_SIZE -1) / TILE_SIZE;
		
		World world = Game.getGame().getWorld();
		
		int index1 = x1 + (y1 * world.getWidth());
		int index2 = x2 + (y2 * world.getWidth());
		int index3 = x3 + (y3 * world.getWidth());
		int index4 = x4 + (y4 * world.getWidth());
		
		return !(tiles[index1].isRigid()
				|| tiles[index2].isRigid()
				|| tiles[index3].isRigid()
				|| tiles[index4].isRigid());
	}
}
