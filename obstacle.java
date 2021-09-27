import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class obstacle extends Actor
{
    protected abstract void fall();
    
    protected boolean isOnground()
    {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, 
                       platform.class);
        return ground != null;
    }
    
    protected void removeOutOfBounds(obstacle obstacle)
    {
        if(obstacle.getY() > 
           getWorld().getHeight()+obstacle.getImage().getWidth() /2)
        {
            getWorld().removeObject(obstacle);
        }
    }
}

