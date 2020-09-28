package me.giverplay.teamfortress.world;

import static me.giverplay.teamfortress.graphics.Spritesheet.*;

import java.awt.image.BufferedImage;

public enum TileType
{
	AIR("Air", false, null),
	STONE("Stone", true, TILE_STONE),
	GRASS("Grass", true, TILE_GRASS),
	BRICKS("Bricks", true, TILE_BRICKS),
	WHITE_BRICKS("White Bricks", true, TILE_WHITE_BRICKS),
	WOODEN_BOX("Wooden Box", true, TILE_WOODEN_BOX),
	PURPLE_BOX("Purple Box", true, TILE_PURPLE_BOX);
	
	// ---------------------------------------------------------------------
	
	private final BufferedImage sprite;
	private final String name;
	
	private final boolean isRigid;
	
	TileType(String name, boolean isRigid, BufferedImage sprite)
	{
		this.name = name;
		this.isRigid = isRigid;
		this.sprite = sprite;
	}
	
	public BufferedImage getSprite()
	{
		return sprite;
	}
	
	public boolean isRigid()
	{
		return isRigid;
	}
	
	public String getDisplayName()
	{
		return name;
	}
}
