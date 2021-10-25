import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @DominicAudibert 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    private final float GRAVITY = 0.08f;
    private final GreenfootSound MUSIC = new GreenfootSound("TheJazz.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 4.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = Level2.class;
    
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level1()
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
        Health health = new Health();

        Bomb bomb = new Bomb(0.667f);
        addObject(bomb,177,325);
        bomb.setLocation(187,330);
        bomb.setLocation(182,336);
        bomb.setLocation(195,333);
        bomb.setLocation(185,314);
        bomb.setLocation(240,324);
        bomb.setLocation(160,337);
        bomb.setLocation(189,338);
        bomb.setLocation(172,332);
        bomb.setLocation(196,348);
        bomb.setLocation(183,327);
        bomb.setLocation(183,327);
        bomb.setLocation(183,327);
        bomb.setLocation(183,327);
        Bomb bomb2 = new Bomb(0.0667f);
        addObject(bomb2,856,498);
        Bomb bomb3 = new Bomb(0.0667f);
        addObject(bomb3,333,606);
        removeObject(brickWall);
        removeObject(brickWall4);
        removeObject(brickWall3);
        brickWall2.setLocation(776,346);
        wooden wooden = new wooden();
        addObject(wooden,776,346);
        removeObject(brickWall2);
        wooden wooden2 = new wooden();
        addObject(wooden2,331,664);
        wooden wooden3 = new wooden();
        addObject(wooden3,179,386);
        wooden wooden4 = new wooden();
        addObject(wooden4,1040,685);
        wooden wooden5 = new wooden();
        addObject(wooden5,898,539);
        wooden5.setLocation(893,552);
        wooden wooden6 = new wooden();
        addObject(wooden6,26,552);
        wooden wooden7 = new wooden();
        addObject(wooden7,477,608);
        wooden wooden8 = new wooden();
        addObject(wooden8,611,460);
        wooden6.setLocation(20,629);
        wooden6.setLocation(18,624);
        wooden3.setLocation(173,433);
        wooden3.setLocation(206,469);
        bomb3.setLocation(361,616);
        bomb.setLocation(267,427);
        bomb.setLocation(232,427);
        wooden3.setLocation(184,484);
        bomb.setLocation(208,443);
    }
    
    
    
    
    
    
}

