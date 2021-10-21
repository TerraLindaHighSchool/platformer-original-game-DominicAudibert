import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Obstacle
{  public Rock(float gravity)
    {
        GRAVITY = gravity;
    }

    private float yVelocity;
    private final float GRAVITY;

    public void act()
    {
        fall();
    }

    protected void fall()
    { 
    if(!isOnGround())
    {
        yVelocity += GRAVITY;
        setLocation(getX(), getY() + (int) yVelocity);
    }
}

}