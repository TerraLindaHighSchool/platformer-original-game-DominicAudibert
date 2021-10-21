import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinSplash extends World
{
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public WinSplash()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1100, 800, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Door door = new Door();
        addObject(door,1155,50);
       
    }
}

