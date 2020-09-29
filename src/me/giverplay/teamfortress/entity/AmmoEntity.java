package me.giverplay.teamfortress.entity;

public abstract class AmmoEntity extends Entity implements Collectible
{
  private EntityAmmoType type;
  private String name;
  
  private int currentItems;
  private int maxItems;
  
  public AmmoEntity(String name, EntityAmmoType type, int currentItems, int maxItems, int x, int y, int width, int height)
  {
    super(x, y, width, height, 0);
    
    this.name = name;
    this.type = type;
    this.currentItems = currentItems;
    this.maxItems = maxItems;
  }
  
  public void setCurrentItems(int currentItems)
  {
    this.currentItems = currentItems;
  }
  
  public EntityAmmoType getType()
  {
    return type;
  }
  
  public String getName()
  {
    return name;
  }
  
  public int getCurrentItems()
  {
    return currentItems;
  }
  
  public int getMaxItems()
  {
    return maxItems;
  }
}
