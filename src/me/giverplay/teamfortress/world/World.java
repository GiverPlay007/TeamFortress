package me.giverplay.teamfortress.world;

import static me.giverplay.teamfortress.graphics.Spritesheet.TILE_SIZE;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.giverplay.teamfortress.game.Game;
import me.giverplay.teamfortress.game.Camera;
import me.giverplay.teamfortress.graphics.Cores;

public class World
{
	private static Tile[] tiles;
	
	private Game game;
	private Camera camera;
	
	private int width;
	private int height;
	
	public World()
	{
		game = Game.getGame();
		camera = game.getCamera();
		
		initializeWorld("/images/Level.png");
	}
	
	private void initializeWorld(String path)
	{
		try
		{
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			
			width = map.getWidth();
			height = map.getHeight();
			
			int lenght = width * height;
			int[] pixels = new int[lenght];
			
			tiles = new Tile[lenght];
			
			map.getRGB(0, 0, width, height, pixels, 0, width);
			
			for(int xx = 0; xx < width; xx++)
			{
				for(int yy = 0; yy < height; yy++)
				{
					int index = xx + (yy * width);
					
					tiles[index] = new Tile(TileType.AIR, xx * 32, yy * 32);
					
					switch (pixels[index])
					{
							
						case Cores.LOC_PLAYER:
							//game.getPlayer().setX(xx * TILE_SIZE);
							//game.getPlayer().setY(yy * TILE_SIZE);
							break;
							
						default:
							break;
					}
				}
			}
			
		} catch (IOException e)
		{
			System.out.println("Falha ao ler o mapa");
		}
	}
	
	public void render(Graphics g)
	{
		int xs = camera.getX() >> 4;
		int ys = camera.getY() >> 4;
		int xf = (camera.getX() + Game.WIDTH) >> 4;
		int yf = (camera.getX() + Game.HEIGHT) >> 4;
		
		for(int xx = xs; xx <= xf; xx++)
		{
			for(int yy = ys; yy <= yf; yy++)
			{
				if(xx < xs || yy < ys || xx >= width || yy >= height)
					continue;
				
				Tile tile = tiles[xx + yy * width];
				
				if(tile != null)
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
