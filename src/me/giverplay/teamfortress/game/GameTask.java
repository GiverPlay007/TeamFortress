package me.giverplay.teamfortress.game;

public class GameTask implements Runnable
{
  private Game game;
  
  private boolean shouldTick = false;
  private boolean shouldRender = false;
  
  private int ticks;
  private int fps;
  private int tps;
  private int fpsAvg;
  
  public GameTask(Game game)
  {
    this.game = game;
    
    new Thread(this, "Game Looping - Main").start();
    new Thread(GameTask.this::tick, "Game Looping - Tick").start();
    new Thread(GameTask.this::render, "Game Looping - Render").start();
  }
  
  private void tick()
  {
    if(!shouldTick)
    {
      return;
    }
    
    game.tick();
    ticks++;
    shouldTick = false;
  }
  
  private void render()
  {
    if(!shouldRender)
    {
      return;
    }
  
    game.render();
    fps++;
    shouldRender = false;
  }
  
  @Override
  public void run()
  {
    long lastTime = System.nanoTime();
    long timer = System.currentTimeMillis();
    long now;
    
    double nsPerTick = 1_000_000_000  / 60D;
    double unprocessed = 0.0D;
    
    while(game.isRunning())
    {
      now = System.nanoTime();
      unprocessed += (now - lastTime) / nsPerTick;
      lastTime = now;
      
      while(unprocessed >= 1)
      {
        shouldTick = true;
        unprocessed--;
      }
      
      shouldRender = true;
      
      if(System.currentTimeMillis() - timer >= 1000)
      {
        this.tps = ticks;
        this.fpsAvg = fps;
        ticks = 0;
        fps = 0;
        timer += 1000;
      }
    }
  }
}
