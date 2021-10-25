import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private final GreenfootImage[] WALK_ANIMATION;
    private Health[] health;
    private Powerup[] powerup;
    private int healthCount;
    private int speed;
    private int walkIndex;
    private int frame;
    private float yVelocity;
    private boolean isWalking;
    private boolean isJumping;
    private boolean isFacingLeft;
    private final GreenfootImage STANDING_IMAGE;
    private final float JUMP_FORCE;
    private final float GRAVITY;
    private final Class NEXT_LEVEL;
    private final GreenfootSound MUSIC;
    private final int MAX_POWERUP;
    private final int MAX_HEALTH;

    public Player(int speed, float jumpForce, float gravity, int maxHealth, int maxPowerup, Class nextLevel, GreenfootSound music)
    {
        WALK_ANIMATION = new GreenfootImage[]
        { new GreenfootImage("walk0.png"),
            new GreenfootImage("walk1.png"),
            new GreenfootImage("walk2.png"),
            new GreenfootImage("walk3.png"),
            new GreenfootImage("walk4.png"),
            new GreenfootImage("walk5.png"),
        };
        health = new Health[maxHealth];
        STANDING_IMAGE = new GreenfootImage("standing.png");
        JUMP_FORCE = jumpForce;
        GRAVITY = gravity;
        healthCount = 3;
        health = new Health[healthCount];
        NEXT_LEVEL = nextLevel;
        MAX_POWERUP = maxPowerup;
        MAX_HEALTH = maxHealth;
        MUSIC = music;
        this.speed = speed;
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        walk();
        jump();
        fall();
        onCollision();
        gameOver();
    }
    private void animator()
    {
        if(frame % (15 - 2 * speed) == 0)
        {
            if(walkIndex < WALK_ANIMATION.length)
            {
                setImage(WALK_ANIMATION[walkIndex]);
                walkIndex++;
            }
            else
            {
                walkIndex = 0;
            }
        }
        frame++;
    }

    private void jump()
    { 
        if(Greenfoot.isKeyDown("space") && isOnGround())
        {
            yVelocity = JUMP_FORCE;
            isJumping = true;
        }

        if(Greenfoot.isKeyDown("up") && isOnGround())
        {
            yVelocity = JUMP_FORCE;
            isJumping = true;
        }
        
        if(isJumping && yVelocity > 0.0)
        {
            setLocation(getX(), getY() - (int) yVelocity);
            yVelocity -= GRAVITY;
        }
        else
        {
            isJumping = false;
        }
    }

    private void fall()
    {
        if(!isOnGround() && !isJumping)
        {
            setLocation(getX(), getY() - (int) yVelocity);
            yVelocity -= GRAVITY;
        }
    }

    private void mirrorImages()
    {
        for(int i = 0; i < WALK_ANIMATION.length; i++)
        {
            WALK_ANIMATION[i].mirrorHorizontally();

        }
    }

    private boolean isOnGround()
    {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, 
                platform.class);
        return ground != null;
    }

    private void onCollision( )
    {
        if(isTouching(Door.class))
        {
            World world = null;
            GreenfootSound sound = new GreenfootSound("collectable.wav");
            try 
            {
                world = (World) NEXT_LEVEL.newInstance();
            }   
            catch (InstantiationException e) 
            {
                System.out.println("Class cannot be instantiated");
            } catch (IllegalAccessException e) {
                System.out.println("Cannot access class constructor");
            } 
            Greenfoot.setWorld(world);
        }
        
        if(isTouching(Gem.class))
        {
            World world = null;
            try 
            {
                world = (World) NEXT_LEVEL.newInstance();
            }   
            catch (InstantiationException e) 
            {
                System.out.println("Class cannot be instantiated");
            } catch (IllegalAccessException e) {
                System.out.println("Cannot access class constructor");
            } 
            Greenfoot.setWorld(new WinSplash());
            Greenfoot.stop();
        }

        if(isTouching(Obstacle.class))
        {
            removeTouching(Obstacle.class);
            getWorld().removeObject(health[healthCount - 1]);
            healthCount--;
        }

        if(isTouching(platform.class) && !isOnGround())
        {
            yVelocity = -1;
            fall();
        }
    }

    private void walk()
    {
        if(isWalking)
        {
            animator();
        }
        else
        {
            setImage(STANDING_IMAGE);
            walkIndex = 0;
        }

        if(Greenfoot.isKeyDown("right"))
        {
            if(!MUSIC.isPlaying())
            {
                MUSIC.playLoop();
            }
            
            if(isFacingLeft)
            {
                mirrorImages();
            }
            isFacingLeft = false;
            isWalking = true;

            move(speed);
        }

        if(Greenfoot.isKeyDown("left"))
        {
            if(!isFacingLeft)
            {
                mirrorImages();
            }
            isFacingLeft = true;
            isWalking = true;
            move(-speed);
        }

        if(!(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right")))
        {
            isWalking = false;
        }
    } 

      private void gameOver()
    {
        if(healthCount == 0)
        {
            Greenfoot.setWorld(new gameOver());
        }
    }

    public void addedToWorld(World world)
    {   
        health[0] = new Health();
        world.addObject(health[0], 30, 100);
        health[1] = new Health();
        world.addObject(health[1], 72, 100);
        health[2] = new Health();
        world.addObject(health[2], 114, 100);
    }
}

        
        
