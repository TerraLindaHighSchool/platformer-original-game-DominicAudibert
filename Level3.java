import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @DominicAudibert 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = WinSplash.class;
    
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level3()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.

        super(1100, 800, 1, false); 
        
        prepare();
    }
    public void act()
    {
        spawn();   
    }
    
    private void spawn()
    {
        if(Math.random() < 0.0050)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Player.class, platform.class, Obstacle.class, collectable.class,
            Door.class, HUD.class);

        Player player = new Player(3, 5.6f, GRAVITY, 3, 3, Level2.class, MUSIC);
        addObject(player,55,692);
        Gem gem = new Gem();
        addObject(gem,100,150);

        purple purple = new purple();
        addObject(purple, 1000,650);
        purple purple2 = new purple();
        addObject(purple2, 850, 450);
        purple purple3 = new purple();
        addObject(purple3, 325,450);
        purple purple4 = new purple();
        addObject(purple4, 100,300);
        purple purple5 = new purple();
        addObject(purple5,650,450 );
       Floor floor = new Floor();
        addObject(floor,595,800);


       
        Health health = new Health();

        Bomb bomb = new Bomb(0.667f);
        addObject(bomb,650,400);
        Bomb bomb2 = new Bomb(0.0667f);
        addObject(bomb2,300,750);
        Bomb bomb3 = new Bomb(0.0667f);
        addObject(bomb2,900,750);
    }
} 


