package me.giverplay.teamfortress.entity;

public interface Collectible
{
  void collect();
  
  default boolean isCollected()
  {
    return false;
  }
}
