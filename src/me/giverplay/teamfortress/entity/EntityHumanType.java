package me.giverplay.teamfortress.entity;

import static me.giverplay.teamfortress.graphics.Spritesheet.carecaBlueIdle;
import static me.giverplay.teamfortress.graphics.Spritesheet.carecaBlueJumping;
import static me.giverplay.teamfortress.graphics.Spritesheet.carecaBlueWalking;
import static me.giverplay.teamfortress.graphics.Spritesheet.carecaPinkIdle;
import static me.giverplay.teamfortress.graphics.Spritesheet.carecaPinkJumping;
import static me.giverplay.teamfortress.graphics.Spritesheet.carecaPinkWalking;
import static me.giverplay.teamfortress.graphics.Spritesheet.fuzileiroBlueIdle;
import static me.giverplay.teamfortress.graphics.Spritesheet.fuzileiroBlueJumping;
import static me.giverplay.teamfortress.graphics.Spritesheet.fuzileiroBlueWalking;
import static me.giverplay.teamfortress.graphics.Spritesheet.fuzileiroPinkIdle;
import static me.giverplay.teamfortress.graphics.Spritesheet.fuzileiroPinkJumping;
import static me.giverplay.teamfortress.graphics.Spritesheet.fuzileiroPinkWalking;
import static me.giverplay.teamfortress.graphics.Spritesheet.mineiroBlueIdle;
import static me.giverplay.teamfortress.graphics.Spritesheet.mineiroBlueJumping;
import static me.giverplay.teamfortress.graphics.Spritesheet.mineiroBlueWalking;
import static me.giverplay.teamfortress.graphics.Spritesheet.mineiroPinkIdle;
import static me.giverplay.teamfortress.graphics.Spritesheet.mineiroPinkJumping;
import static me.giverplay.teamfortress.graphics.Spritesheet.mineiroPinkWalking;
import static me.giverplay.teamfortress.graphics.Spritesheet.soldadoBlueIdle;
import static me.giverplay.teamfortress.graphics.Spritesheet.soldadoBlueJumping;
import static me.giverplay.teamfortress.graphics.Spritesheet.soldadoBlueWalking;
import static me.giverplay.teamfortress.graphics.Spritesheet.soldadoPinkIdle;
import static me.giverplay.teamfortress.graphics.Spritesheet.soldadoPinkJumping;
import static me.giverplay.teamfortress.graphics.Spritesheet.soldadoPinkWalking;
import static me.giverplay.teamfortress.graphics.Spritesheet.terroristaBlueIdle;
import static me.giverplay.teamfortress.graphics.Spritesheet.terroristaBlueJumping;
import static me.giverplay.teamfortress.graphics.Spritesheet.terroristaBlueWalking;
import static me.giverplay.teamfortress.graphics.Spritesheet.terroristaPinkIdle;
import static me.giverplay.teamfortress.graphics.Spritesheet.terroristaPinkJumping;
import static me.giverplay.teamfortress.graphics.Spritesheet.terroristaPinkWalking;
import static me.giverplay.teamfortress.graphics.Spritesheet.SPRITE_SIZE;


import java.awt.image.BufferedImage;

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
