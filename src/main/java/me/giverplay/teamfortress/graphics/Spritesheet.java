package me.giverplay.teamfortress.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class Spritesheet
{
	public static final int TILE_SIZE = 40;
	public static final int SPRITE_SIZE = 40;
	
	private static BufferedImage chars;
	private static BufferedImage map;
	
	private BufferedImage getSprite(BufferedImage spritesheet, int x, int y, int width, int height)
	{
		return spritesheet.getSubimage(x, y, width, height);
	}
	
	// -----------------------------------------------------------------------------------------------
	public static BufferedImage[] mineiroPinkWalking = new BufferedImage[6];
	public static BufferedImage[] mineiroPinkJumping = new BufferedImage[2];
	public static BufferedImage[] mineiroPinkIdle = new BufferedImage[4];
	
	public static BufferedImage[] mineiroBlueWalking = new BufferedImage[6];
	public static BufferedImage[] mineiroBlueJumping = new BufferedImage[2];
	public static BufferedImage[] mineiroBlueIdle = new BufferedImage[4];
	
	public static BufferedImage[] soldadoPinkWalking = new BufferedImage[6];
	public static BufferedImage[] soldadoPinkJumping = new BufferedImage[2];
	public static BufferedImage[] soldadoPinkIdle = new BufferedImage[4];
	
	public static BufferedImage[] soldadoBlueWalking = new BufferedImage[6];
	public static BufferedImage[] soldadoBlueJumping = new BufferedImage[2];
	public static BufferedImage[] soldadoBlueIdle = new BufferedImage[4];
	
	public static BufferedImage[] fuzileiroPinkWalking = new BufferedImage[6];
	public static BufferedImage[] fuzileiroPinkJumping = new BufferedImage[2];
	public static BufferedImage[] fuzileiroPinkIdle = new BufferedImage[4];
	
	public static BufferedImage[] fuzileiroBlueWalking = new BufferedImage[6];
	public static BufferedImage[] fuzileiroBlueJumping = new BufferedImage[2];
	public static BufferedImage[] fuzileiroBlueIdle = new BufferedImage[4];
	
	public static BufferedImage[] carecaPinkWalking = new BufferedImage[6];
	public static BufferedImage[] carecaPinkJumping = new BufferedImage[2];
	public static BufferedImage[] carecaPinkIdle = new BufferedImage[4];
	
	public static BufferedImage[] carecaBlueWalking = new BufferedImage[6];
	public static BufferedImage[] carecaBlueJumping = new BufferedImage[2];
	public static BufferedImage[] carecaBlueIdle = new BufferedImage[4];
	
	public static BufferedImage[] terroristaPinkWalking = new BufferedImage[6];
	public static BufferedImage[] terroristaPinkJumping = new BufferedImage[2];
	public static BufferedImage[] terroristaPinkIdle = new BufferedImage[4];
	
	public static BufferedImage[] terroristaBlueWalking = new BufferedImage[6];
	public static BufferedImage[] terroristaBlueJumping = new BufferedImage[2];
	public static BufferedImage[] terroristaBlueIdle = new BufferedImage[4];
	
	public static BufferedImage TILE_WHITE_BRICKS;
	public static BufferedImage TILE_WOODEN_BOX;
	public static BufferedImage TILE_PURPLE_BOX;
	public static BufferedImage TILE_BRICKS;
	public static BufferedImage TILE_STONE;
	public static BufferedImage TILE_GRASS;
	public static BufferedImage TILE_DIRT;
	
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
		TILE_DIRT         = map.getSubimage(80, 0, 16, 16);
		TILE_GRASS        = map.getSubimage(96, 0, 16, 16);
		
		WEAPON_RPG      = map.getSubimage(0, 16, 47, 21);
		WEAPON_SHOTGUN  = map.getSubimage(0, 37, 36, 13);
		WEAPON_AK       = map.getSubimage(0, 50, 36, 16);
		WEAPON_REVOLVER = map.getSubimage(0, 66, 21, 15);
		
		AMMO_RPG      = map.getSubimage(50, 22, 17, 15);
		AMMO_SHOTGUN  = map.getSubimage(41, 41, 9, 6);
		AMMO_AK       = map.getSubimage(38, 52, 19, 13);
		AMMO_REVOLVER = map.getSubimage(25, 74, 8, 5);
		
		LIFE_PACK = map.getSubimage(36, 84, 10, 10);
		
		for(int i = 0; i < 4; i++)
		{
			mineiroPinkIdle[i] = chars.getSubimage(i * SPRITE_SIZE, 0, SPRITE_SIZE, SPRITE_SIZE);
			mineiroBlueIdle[i] = chars.getSubimage(160 + i * SPRITE_SIZE, 0, SPRITE_SIZE, SPRITE_SIZE);
			
			fuzileiroPinkIdle[i] = chars.getSubimage(i * SPRITE_SIZE, 141, SPRITE_SIZE, SPRITE_SIZE);
			fuzileiroBlueIdle[i] = chars.getSubimage(160 + i * SPRITE_SIZE, 141, SPRITE_SIZE, SPRITE_SIZE);
			
			carecaPinkIdle[i] = chars.getSubimage(i * SPRITE_SIZE, 285, SPRITE_SIZE, SPRITE_SIZE);
			carecaBlueIdle[i] = chars.getSubimage(160 + i * SPRITE_SIZE, 285, SPRITE_SIZE, SPRITE_SIZE);
			
			soldadoPinkIdle[i] = chars.getSubimage(i * SPRITE_SIZE, 429, SPRITE_SIZE, SPRITE_SIZE);
			soldadoBlueIdle[i] = chars.getSubimage(160 + i * SPRITE_SIZE, 429, SPRITE_SIZE, SPRITE_SIZE);
			
			terroristaPinkIdle[i] = chars.getSubimage(i * SPRITE_SIZE, 573, SPRITE_SIZE, SPRITE_SIZE);
			terroristaBlueIdle[i] = chars.getSubimage(160 + i * SPRITE_SIZE, 573, SPRITE_SIZE, SPRITE_SIZE);
		}
		
		for(int i = 0; i < 6; i++)
		{
			mineiroPinkWalking[i] = chars.getSubimage(i * SPRITE_SIZE, 93, SPRITE_SIZE, SPRITE_SIZE);
			mineiroBlueWalking[i] = chars.getSubimage(240 + i * SPRITE_SIZE, 93, SPRITE_SIZE, SPRITE_SIZE);
			
			fuzileiroPinkWalking[i] = chars.getSubimage(i * SPRITE_SIZE, 237, SPRITE_SIZE, SPRITE_SIZE);
			fuzileiroBlueWalking[i] = chars.getSubimage(240 + i * SPRITE_SIZE, 237, SPRITE_SIZE, SPRITE_SIZE);
			
			carecaPinkWalking[i] = chars.getSubimage(i * SPRITE_SIZE, 381, SPRITE_SIZE, SPRITE_SIZE);
			carecaBlueWalking[i] = chars.getSubimage(240 + i * SPRITE_SIZE, 381, SPRITE_SIZE, SPRITE_SIZE);
			
			soldadoPinkWalking[i] = chars.getSubimage(i * SPRITE_SIZE, 525, SPRITE_SIZE, SPRITE_SIZE);
			soldadoBlueWalking[i] = chars.getSubimage(240 + i * SPRITE_SIZE, 525, SPRITE_SIZE, SPRITE_SIZE);
			
			terroristaPinkWalking[i] = chars.getSubimage(i * SPRITE_SIZE, 669, SPRITE_SIZE, SPRITE_SIZE);
			terroristaBlueWalking[i] = chars.getSubimage(240 + i * SPRITE_SIZE, 669, SPRITE_SIZE, SPRITE_SIZE);
		}
		
		for(int i = 0; i < 2; i++)
		{
			mineiroPinkJumping[i] = chars.getSubimage(i * SPRITE_SIZE, 45, SPRITE_SIZE, SPRITE_SIZE);
			mineiroBlueJumping[i] = chars.getSubimage(80 + i * SPRITE_SIZE, 45, SPRITE_SIZE, SPRITE_SIZE);
			
			fuzileiroPinkJumping[i] = chars.getSubimage(i * SPRITE_SIZE, 189, SPRITE_SIZE, SPRITE_SIZE);
			fuzileiroBlueJumping[i] = chars.getSubimage(80 + i * SPRITE_SIZE, 189, SPRITE_SIZE, SPRITE_SIZE);
			
			carecaPinkJumping[i] = chars.getSubimage(i * SPRITE_SIZE, 331, SPRITE_SIZE, SPRITE_SIZE);
			carecaBlueJumping[i] = chars.getSubimage(80 + i * SPRITE_SIZE, 331, SPRITE_SIZE, SPRITE_SIZE);
			
			soldadoPinkJumping[i] = chars.getSubimage(i * SPRITE_SIZE, 475, SPRITE_SIZE, SPRITE_SIZE);
			soldadoBlueJumping[i] = chars.getSubimage(80 + i * SPRITE_SIZE, 475, SPRITE_SIZE, SPRITE_SIZE);
			
			terroristaPinkJumping[i] = chars.getSubimage(i * SPRITE_SIZE, 620, SPRITE_SIZE, SPRITE_SIZE);
			terroristaBlueJumping[i] = chars.getSubimage(80 + i * SPRITE_SIZE, 620, SPRITE_SIZE, SPRITE_SIZE);
		}
	}
}
