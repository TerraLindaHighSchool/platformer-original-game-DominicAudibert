import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gem extends collectable
{
    /**
     * Act - do whatever the Gem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }


    
    protected void removeOutOfBounds(Gem gem)
    {
        if(gem.getY() > 
           getWorld().getHeight()+gem.getImage().getWidth() /2)
        {
            getWorld().removeObject(gem);
        }
    }
}