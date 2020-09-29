package me.giverplay.teamfortress.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class Spritesheet
{
	public static final int TILE_SIZE = 32;
	
	private static BufferedImage chars;
	private static BufferedImage map;
	
	private BufferedImage getSprite(BufferedImage spritesheet, int x, int y, int width, int height)
	{
		return spritesheet.getSubimage(x, y, width, height);
	}
	
	// -----------------------------------------------------------------------------------------------
	public static BufferedImage[] mineiroPinkWalking;
	public static BufferedImage[] mineiroPinkJumping;
	public static BufferedImage[] mineiroPinkIdle;
	
	public static BufferedImage[] mineiroBlueWalking;
	public static BufferedImage[] mineiroBlueJumping;
	public static BufferedImage[] mineiroBlueIdle;
	
	public static BufferedImage[] soldadoPinkWalking;
	public static BufferedImage[] soldadoPinkJumping;
	public static BufferedImage[] soldadoPinkIdle;
	
	public static BufferedImage[] soldadoBlueWalking;
	public static BufferedImage[] soldadoBlueJumping;
	public static BufferedImage[] soldadoBlueIdle;
	
	public static BufferedImage[] fuzileiroPinkWalking;
	public static BufferedImage[] fuzileiroPinkJumping;
	public static BufferedImage[] fuzileiroPinkIdle;
	
	public static BufferedImage[] fuzileiroBlueWalking;
	public static BufferedImage[] fuzileiroBlueJumping;
	public static BufferedImage[] fuzileiroBlueIdle;
	
	public static BufferedImage[] carecaPinkWalking;
	public static BufferedImage[] carecaPinkJumping;
	public static BufferedImage[] carecaPinkIdle;
	
	public static BufferedImage[] carecaBlueWalking;
	public static BufferedImage[] carecaBlueJumping;
	public static BufferedImage[] carecaBlueIdle;
	
	public static BufferedImage[] terroristaPinkWalking;
	public static BufferedImage[] terroristaPinkJumping;
	public static BufferedImage[] terroristaPinkIdle;
	
	public static BufferedImage[] terroristaBlueWalking;
	public static BufferedImage[] terroristaBlueJumping;
	public static BufferedImage[] terroristaBlueIdle;
	
	public static BufferedImage TILE_WHITE_BRICKS;
	public static BufferedImage TILE_WOODEN_BOX;
	public static BufferedImage TILE_PURPLE_BOX;
	public static BufferedImage TILE_BRICKS;
	public static BufferedImage TILE_STONE;
	public static BufferedImage TILE_GRASS;
	
	public static BufferedImage LIFE_PACK;
	
	public static BufferedImage WEAPON_REVOLVER;
	public static BufferedImage WEAPON_SHOTGUN;
	public static BufferedImage WEAPON_RPG;
	public static BufferedImage WEAPON_AK;
	
	public static BufferedImage AMMO_REVOLVER;
	public static BufferedImage AMMO_SHOTGUN;
	public static BufferedImage AMMO_RPG;
	public static BufferedImage AMMO_AK;
	// -----------------------------------------------------------------------
	
	private Spritesheet() {	}
	
	public static void init()
	{
		try
		{
			chars = ImageIO.read(Spritesheet.class.getResource("/images/Characters.png"));
			map = ImageIO.read(Spritesheet.class.getResource("/images/Sprites.png"));
		}
		catch (IOException e)
		{
			System.out.println("Erro na leitura do Spritesheet");
			e.printStackTrace();
			System.exit(1);
		}
		
		TILE_PURPLE_BOX   = map.getSubimage(0, 0, 16, 16);
		TILE_WOODEN_BOX   = map.getSubimage(16, 0, 16, 16);
		TILE_WHITE_BRICKS = map.getSubimage(32, 0, 16, 16);
		TILE_BRICKS       = map.getSubimage(48, 0, 16, 16);
		TILE_STONE        = map.getSubimage(64, 0, 16, 16);
		
		WEAPON_RPG      = map.getSubimage(0, 16, 47, 21);
		WEAPON_SHOTGUN  = map.getSubimage(0, 37, 36, 13);
		WEAPON_AK       = map.getSubimage(0, 50, 36, 16);
		WEAPON_REVOLVER = map.getSubimage(0, 66, 21, 15);
		
		AMMO_RPG      = map.getSubimage(50, 22, 17, 15);
		AMMO_SHOTGUN  = map.getSubimage(41, 41, 9, 6);
		AMMO_AK       = map.getSubimage(38, 52, 19, 13);
		AMMO_REVOLVER = map.getSubimage(25, 74, 8, 5);
		
		LIFE_PACK = map.getSubimage(36, 84, 10, 10);
	}
}
