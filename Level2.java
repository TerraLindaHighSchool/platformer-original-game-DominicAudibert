import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @DominicAudibert 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level2()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.

        super(1100, 800, 1, false); 
        
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Player.class, platform.class, Obstacle.class, collectable.class,
            Door.class, HUD.class);

        Player player = new Player(3, 5.6f, GRAVITY, 3, 3, Level3.class, MUSIC);
        addObject(player,55,692);
        Door door = new Door();
        addObject(door,1200,59);

        BrickWall brickWall = new BrickWall();
        addObject(brickWall,565,501);
        Gem gem = new Gem();
        addObject(gem,1050,192);
        BrickWall brickWall2 = new BrickWall();
        addObject(brickWall2,958,122);
        BrickWall brickWall3 = new BrickWall();
        addObject(brickWall3,329,261);
      
        gem.setLocation(1050,76);
        BrickWall brickWall4 = new BrickWall();
        addObject(brickWall4,954,411);
        gem.setLocation(143,204);
        Floor floor = new Floor();
        addObject(floor,595,779);
        Floor floor2 = new Floor();
        addObject(floor2,896,649);
        floor2.setLocation(916,649);
        removeObject(floor2);

        addObject(floor2,596,729);
        player.setLocation(53,668);
        removeObject(floor2);
        player.setLocation(53,708);
        floor.setLocation(639,791);
        player.setLocation(56,743);
        floor.setLocation(759,743);
        player.setLocation(68,661);
        floor.setLocation(102,729);
        removeObject(floor);

        addObject(floor,600,800);
        player.setLocation(49,750);
        removeObject(gem);
        brickWall.setLocation(252,660);
        brickWall4.setLocation(795,488);
        brickWall3.setLocation(528,404);
        brickWall2.setLocation(864,277);
        door.setLocation(755,251);
        brickWall3.setLocation(392,420);
        brickWall4.setLocation(869,553);
        brickWall2.setLocation(947,344);
        door.setLocation(749,286);
        brickWall3.setLocation(426,401);
        Trapdoor trapdoor = new Trapdoor(3.2f);
        addObject(trapdoor,533,398);
        AcidRain acidRain = new AcidRain(2.3f);
        addObject(acidRain,512,208);
        brickWall3.setLocation(196,400);
        door.setLocation(950,242);
        removeObject(door);

        addObject(door,763,292);
        brickWall3.setLocation(86,392);
        brickWall3.setLocation(128,392);
        brickWall3.setLocation(172,393);
        trapdoor.setLocation(452,394);
        brickWall3.setLocation(313,392);
        trapdoor.setLocation(356,388);
        removeObject(acidRain);
        trapdoor.setLocation(407,324);
        removeObject(trapdoor);
        
    }
    
    public void act()
    {
        spawn();   
    }
    
    private void spawn()
    {
        if(Math.random() < 0.0080)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
}

