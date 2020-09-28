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
  MINEIRO_BLUE("Mineiro", mineiroBlueIdle, mineiroBlueWalking, mineiroBlueJumping, 16, 16),
  TERRORISTA_BLUE("Terrorista", terroristaBlueIdle, terroristaBlueWalking, terroristaBlueJumping, 16, 16),
  FUZILEIRO_BLUE("Fuzileiro", fuzileiroBlueIdle, fuzileiroBlueWalking, fuzileiroBlueJumping, 16, 16),
  SOLDADO_BLUE("Soldado", soldadoBlueIdle, soldadoBlueWalking, soldadoBlueJumping, 16, 16),
  CARECA_BLUE("Careca", carecaBlueIdle, carecaBlueWalking, carecaBlueJumping, 16, 16),
  MINEIRO_PINK("Mineiro", mineiroPinkIdle, mineiroPinkWalking, mineiroPinkJumping,16, 16),
  TERRORISTA_PINK("Terrorista", terroristaPinkIdle, terroristaPinkWalking, terroristaPinkJumping, 16, 16),
  FUZILEIRO_PINK("Fuzileiro", fuzileiroPinkIdle, fuzileiroPinkWalking, fuzileiroPinkJumping, 16, 16),
  SOLDADO_PINK("Soldado", soldadoPinkIdle, soldadoPinkWalking, soldadoPinkJumping, 16, 16),
  CARECA_PINK("Careca", carecaPinkIdle, carecaPinkWalking, carecaPinkJumping,16, 16);
  
  private final String name;
  private final BufferedImage[] IDLE, JUMP, WALKING;
  private final int WIDTH, HEIGHT;
  
  EntityType(String name, BufferedImage[] idle, BufferedImage[] walk, BufferedImage[] jump, int width, int height)
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
