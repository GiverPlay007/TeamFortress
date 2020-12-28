package me.giverplay.teamfortress.game;

public enum State
{
  NORMAL("Running", false, true),
  GAME_OVER("Game Over", false, false),
  VICTORY("Victory", false, false),
  START("Main Menu", true, false),
  READING("Reading info", false, false),
  LOADING("Loading game", false, false),
  PAUSED("Game Paused", true, false);
  
  private String name;
  private boolean doGameTick;
  private boolean doMenuTick;
  
  State(String displayName, boolean menuTick, boolean entityTick)
  {
    this.name = displayName;
    this.doMenuTick = menuTick;
    this.doGameTick = entityTick;
  }
  
  public boolean doGameTick()
  {
    return doGameTick;
  }
  
  public boolean doMenuTick()
  {
    return this.doMenuTick;
  }
  
  public String getDisplayName()
  {
    return name;
  }
}
