package me.giverplay.teamfortress.entity;

import java.awt.image.BufferedImage;
import java.util.Objects;
import me.giverplay.teamfortress.RandomUtils;


import static me.giverplay.teamfortress.graphics.Spritesheet.*;

public enum EntityHumanType
{
  MINEIRO_BLUE("Mineiro", mineiroBlueIdle, mineiroBlueWalking, mineiroBlueJumping, SPRITE_SIZE, SPRITE_SIZE),
  TERRORISTA_BLUE("Terrorista", terroristaBlueIdle, terroristaBlueWalking, terroristaBlueJumping, SPRITE_SIZE, SPRITE_SIZE),
  FUZILEIRO_BLUE("Fuzileiro", fuzileiroBlueIdle, fuzileiroBlueWalking, fuzileiroBlueJumping, SPRITE_SIZE, SPRITE_SIZE),
  SOLDADO_BLUE("Soldado", soldadoBlueIdle, soldadoBlueWalking, soldadoBlueJumping, SPRITE_SIZE, SPRITE_SIZE),
  CARECA_BLUE("Careca", carecaBlueIdle, carecaBlueWalking, carecaBlueJumping, SPRITE_SIZE, SPRITE_SIZE),
  MINEIRO_PINK("Mineiro", mineiroPinkIdle, mineiroPinkWalking, mineiroPinkJumping,SPRITE_SIZE, SPRITE_SIZE),
  TERRORISTA_PINK("Terrorista", terroristaPinkIdle, terroristaPinkWalking, terroristaPinkJumping, SPRITE_SIZE, SPRITE_SIZE),
  FUZILEIRO_PINK("Fuzileiro", fuzileiroPinkIdle, fuzileiroPinkWalking, fuzileiroPinkJumping, SPRITE_SIZE, SPRITE_SIZE),
  SOLDADO_PINK("Soldado", soldadoPinkIdle, soldadoPinkWalking, soldadoPinkJumping, SPRITE_SIZE, SPRITE_SIZE),
  CARECA_PINK("Careca", carecaPinkIdle, carecaPinkWalking, carecaPinkJumping,SPRITE_SIZE, SPRITE_SIZE);
  
  private final String name;
  private final BufferedImage[] IDLE, JUMP, WALKING;
  private final int WIDTH, HEIGHT;
  
  EntityHumanType(String name, BufferedImage[] idle, BufferedImage[] walk, BufferedImage[] jump, int width, int height)
  {
    this.name = name;
    this.IDLE = idle;
    this.WALKING = walk;
    this.JUMP = jump;
   
    this.WIDTH = width;
    this.HEIGHT = height;
  }
  
  public static EntityHumanType choose(EntityHumanType... types)
  {
    return RandomUtils.choose(types);
  }
  
  public static EntityHumanType getRandomBlue()
  {
    return choose(CARECA_BLUE, FUZILEIRO_BLUE, MINEIRO_BLUE, SOLDADO_BLUE, TERRORISTA_BLUE);
  }
  
  public static EntityHumanType getRandomPink()
  {
    return choose(CARECA_PINK, FUZILEIRO_PINK, MINEIRO_PINK, SOLDADO_PINK, TERRORISTA_PINK);
  }
  
  public String getName()
  {
    return name;
  }
  
  public BufferedImage[] getIdle()
  {
    return this.IDLE;
  }
  
  public BufferedImage[] getJump()
  {
    return this.JUMP;
  }
  
  public BufferedImage[] getWalking()
  {
    return this.WALKING;
  }
  
  public int getHeight()
  {
    return HEIGHT;
  }
  
  public int getWidth()
  {
    return WIDTH;
  }
}
