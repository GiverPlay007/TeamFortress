package me.giverplay.supermario.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class Spritesheet
{
	private static BufferedImage chars;
	private static BufferedImage map;
	
	private BufferedImage getSprite(BufferedImage spritesheet, int x, int y, int width, int height)
	{
		return spritesheet.getSubimage(x, y, width, height);
	}
	
	// -----------------------------------------------------------------------------------------------
	public static BufferedImage[] mineiroPinkIdle;
	public static BufferedImage[] mineiroPinkWalking;
	public static BufferedImage[] mineiroPinkJumping;
	
	public static BufferedImage[] mineiroBlueIdle;
	public static BufferedImage[] mineiroBlueWalking;
	public static BufferedImage[] mineiroBlueJumping;
	
	public static BufferedImage[] soldadoPinkIdle;
	public static BufferedImage[] soldadoPinkWalking;
	public static BufferedImage[] soldadoPinkJumping;
	
	public static BufferedImage[] soldadoBlueIdle;
	public static BufferedImage[] soldadoBlueWalking;
	public static BufferedImage[] soldadoBlueJumping;
	
	public static BufferedImage[] fuzileiroPinkIdle;
	public static BufferedImage[] fuzileiroPinkWalking;
	public static BufferedImage[] fuzileiroPinkJumping;
	
	public static BufferedImage[] fuzileiroBlueIdle;
	public static BufferedImage[] fuzileiroBlueWalking;
	public static BufferedImage[] fuzileiroBlueJumping;
	
	public static BufferedImage[] carecaPinkIdle;
	public static BufferedImage[] carecaPinkWalking;
	public static BufferedImage[] carecaPinkJumping;
	
	public static BufferedImage[] carecaBlueIdle;
	public static BufferedImage[] carecaBlueWalking;
	public static BufferedImage[] carecaBlueJumping;
	
	public static BufferedImage[] terroristaPinkIdle;
	public static BufferedImage[] terroristaPinkWalking;
	public static BufferedImage[] terroristaPinkJumping;
	
	public static BufferedImage[] terroristaBlueIdle;
	public static BufferedImage[] terroristaBlueWalking;
	public static BufferedImage[] terroristaBlueJumping;
	
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
