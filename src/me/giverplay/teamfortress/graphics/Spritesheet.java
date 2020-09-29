package me.giverplay.teamfortress.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class Spritesheet
{
	public static final int TILE_SIZE = 16;
	
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
		}
	}
}
