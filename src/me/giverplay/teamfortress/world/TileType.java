package me.giverplay.teamfortress.world;

import static me.giverplay.teamfortress.graphics.Cores.LOC_TILE_AIR;
import static me.giverplay.teamfortress.graphics.Cores.LOC_TILE_BRICKS;
import static me.giverplay.teamfortress.graphics.Cores.LOC_TILE_GRASS;
import static me.giverplay.teamfortress.graphics.Cores.LOC_TILE_PURPLE_BOX;
import static me.giverplay.teamfortress.graphics.Cores.LOC_TILE_STONE;
import static me.giverplay.teamfortress.graphics.Cores.LOC_TILE_WHITE_BRICKS;
import static me.giverplay.teamfortress.graphics.Cores.LOC_TILE_WOODEN_BOX;
import static me.giverplay.teamfortress.graphics.Spritesheet.TILE_BRICKS;
import static me.giverplay.teamfortress.graphics.Spritesheet.TILE_GRASS;
import static me.giverplay.teamfortress.graphics.Spritesheet.TILE_PURPLE_BOX;
import static me.giverplay.teamfortress.graphics.Spritesheet.TILE_STONE;
import static me.giverplay.teamfortress.graphics.Spritesheet.TILE_WHITE_BRICKS;
import static me.giverplay.teamfortress.graphics.Spritesheet.TILE_WOODEN_BOX;


import java.awt.image.BufferedImage;

public enum TileType
{
	AIR("Air", false, null, LOC_TILE_AIR),
	STONE("Stone", true, TILE_STONE, LOC_TILE_STONE),
	GRASS("Grass", true, TILE_GRASS, LOC_TILE_GRASS),
	BRICKS("Bricks", true, TILE_BRICKS, LOC_TILE_BRICKS),
	WHITE_BRICKS("White Bricks", true, TILE_WHITE_BRICKS, LOC_TILE_WHITE_BRICKS),
	WOODEN_BOX("Wooden Box", true, TILE_WOODEN_BOX, LOC_TILE_WOODEN_BOX),
	PURPLE_BOX("Purple Box", true, TILE_PURPLE_BOX, LOC_TILE_PURPLE_BOX);
	
	// ---------------------------------------------------------------------
	
	private final BufferedImage sprite;
	private final String name;
	
	private final boolean isRigid;
	private final int hexa;
	
	TileType(String name, boolean isRigid, BufferedImage sprite, int hexa)
	{
		this.name = name;
		this.isRigid = isRigid;
		this.sprite = sprite;
		this.hexa = hexa;
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
	
	public int getHexaColor()
	{
		return this.hexa;
	}
}
