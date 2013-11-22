import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This world appears when the game begins.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class OpeningText extends World
{
    /**
     * Constructs a new actor of class Rank.
     * This actor represents the player's current rank throughout the game.
     */
    public Rank rank = new Rank();
    /**
     * Constructs a new actor of class Health.
     * This actor represents the player's current health throughout the game.
     */
    public Health health = new Health();
    /**
     * Constructor for objects of class OpeningText.
     * Creates a new world with 580x580 cells with a cell size of 1x1 pixels.
     */
    public OpeningText()
    {    
        super(580, 580, 1);
        prepare();
    }

    /**
     * Prepares the world for the start of the program. That is: creates the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
       /**
       * Constructs a new object of class Title.
       * Adds the title, rank, and health objects to the screen.
       * Creates a new sound that is played on a loop throughout the game as background music.
       * Royalty free music from artist Kevin Macleod.
       */
        Title title = new Title();
        addObject(title, 296, 244);
        addObject(rank, 50, 30);
        addObject(health, 460, 30);
        GreenfootSound backgroundMusic = new GreenfootSound("backgroundMusic.wav");
        backgroundMusic.setVolume(55);
        backgroundMusic.playLoop();
    }
}
