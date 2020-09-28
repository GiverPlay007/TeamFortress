package me.giverplay.supermario.entity;

import static me.giverplay.supermario.graphics.Spritesheet.carecaBlueIdle;
import static me.giverplay.supermario.graphics.Spritesheet.carecaBlueJumping;
import static me.giverplay.supermario.graphics.Spritesheet.carecaBlueWalking;
import static me.giverplay.supermario.graphics.Spritesheet.carecaPinkIdle;
import static me.giverplay.supermario.graphics.Spritesheet.carecaPinkJumping;
import static me.giverplay.supermario.graphics.Spritesheet.carecaPinkWalking;
import static me.giverplay.supermario.graphics.Spritesheet.fuzileiroBlueIdle;
import static me.giverplay.supermario.graphics.Spritesheet.fuzileiroBlueJumping;
import static me.giverplay.supermario.graphics.Spritesheet.fuzileiroBlueWalking;
import static me.giverplay.supermario.graphics.Spritesheet.fuzileiroPinkIdle;
import static me.giverplay.supermario.graphics.Spritesheet.fuzileiroPinkJumping;
import static me.giverplay.supermario.graphics.Spritesheet.fuzileiroPinkWalking;
import static me.giverplay.supermario.graphics.Spritesheet.mineiroBlueIdle;
import static me.giverplay.supermario.graphics.Spritesheet.mineiroBlueJumping;
import static me.giverplay.supermario.graphics.Spritesheet.mineiroBlueWalking;
import static me.giverplay.supermario.graphics.Spritesheet.mineiroPinkIdle;
import static me.giverplay.supermario.graphics.Spritesheet.mineiroPinkJumping;
import static me.giverplay.supermario.graphics.Spritesheet.mineiroPinkWalking;
import static me.giverplay.supermario.graphics.Spritesheet.soldadoBlueIdle;
import static me.giverplay.supermario.graphics.Spritesheet.soldadoBlueJumping;
import static me.giverplay.supermario.graphics.Spritesheet.soldadoBlueWalking;
import static me.giverplay.supermario.graphics.Spritesheet.soldadoPinkIdle;
import static me.giverplay.supermario.graphics.Spritesheet.soldadoPinkJumping;
import static me.giverplay.supermario.graphics.Spritesheet.soldadoPinkWalking;
import static me.giverplay.supermario.graphics.Spritesheet.terroristaBlueIdle;
import static me.giverplay.supermario.graphics.Spritesheet.terroristaBlueJumping;
import static me.giverplay.supermario.graphics.Spritesheet.terroristaBlueWalking;
import static me.giverplay.supermario.graphics.Spritesheet.terroristaPinkIdle;
import static me.giverplay.supermario.graphics.Spritesheet.terroristaPinkJumping;
import static me.giverplay.supermario.graphics.Spritesheet.terroristaPinkWalking;


import java.awt.image.BufferedImage;

public enum EntityType
{
  MINEIRO("Mineiro", mineiroPinkIdle, mineiroPinkWalking, mineiroPinkJumping, mineiroBlueIdle, mineiroBlueWalking, mineiroBlueJumping, 16, 16),
  TERRORISTA("Terrorista", terroristaPinkIdle, terroristaPinkWalking, terroristaPinkJumping, terroristaBlueIdle, terroristaBlueWalking, terroristaBlueJumping, 16, 16),
  FUZILEIRO("Fuzileiro", fuzileiroPinkIdle, fuzileiroPinkWalking, fuzileiroPinkJumping, fuzileiroBlueIdle, fuzileiroBlueWalking, fuzileiroBlueJumping, 16, 16),
  SOLDADO("Soldado", soldadoPinkIdle, soldadoPinkWalking, soldadoPinkJumping, soldadoBlueIdle, soldadoBlueWalking, soldadoBlueJumping, 16, 16),
  CARECA("Careca", carecaPinkIdle, carecaPinkWalking, carecaPinkJumping, carecaBlueIdle, carecaBlueWalking, carecaBlueJumping, 16, 16);
  
  private final String name;
  private final BufferedImage[] ROSA_IDLE, ROSA_WALK, ROSA_JUMP, BLUE_IDLE, BLUE_WALK, BLUE_JUMP;
  private final int WIDTH, HEIGHT;
  
  EntityType(String name, BufferedImage[] rosaIdle, BufferedImage[] rosaRun, BufferedImage[] rosaJump, BufferedImage[] blueIdle, BufferedImage[] blueRun, BufferedImage[] blueJump, int width, int height)
  {
    this.name = name;
    this.ROSA_IDLE = rosaIdle;
    this.ROSA_WALK = rosaRun;
    this.ROSA_JUMP = rosaJump;
    this.BLUE_JUMP = blueJump;
    this.BLUE_IDLE = blueIdle;
    this.BLUE_WALK = blueRun;
    this.WIDTH = width;
    this.HEIGHT = height;
  }
  
  public String getName()
  {
    return name;
  }
  
  public BufferedImage[] getIdlePink()
  {
    return this.ROSA_IDLE;
  }
  
  public BufferedImage[] getIdleBlue()
  {
    return this.BLUE_IDLE;
  }
  
  public BufferedImage[] getWalkingBlue()
  {
    return this.BLUE_WALK;
  }
  
  public BufferedImage[] getWalkingPink()
  {
    return this.ROSA_WALK;
  }
  
  public BufferedImage[] getJumpPink()
  {
    return this.ROSA_JUMP;
  }
  
  public BufferedImage[] getJumpBlue()
  {
    return this.BLUE_JUMP;
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
