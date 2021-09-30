import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level1()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.

        super(1200, 800, 1, false); 
        setPaintOrder(Player.class, platform.class, obstacle.class, collectable.class,
            Door.class, HUD.class);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player(3, 5.6f, GRAVITY, 3, 3, Level2.class, MUSIC);
        addObject(player,55,692);
        Door door = new Door();
        addObject(door,1150,59);

        BrickWall brickWall = new BrickWall();
        addObject(brickWall,565,501);
        Gem gem = new Gem();
        addObject(gem,478,192);
        BrickWall brickWall2 = new BrickWall();
        addObject(brickWall2,958,122);
        BrickWall brickWall3 = new BrickWall();
        addObject(brickWall3,329,261);
        brickWall.setLocation(318,606);
        gem.setLocation(806,76);
        BrickWall brickWall4 = new BrickWall();
        addObject(brickWall4,954,411);
        gem.setLocation(143,204);
    }
    
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
}

