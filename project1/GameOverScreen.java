import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This world appears when the player has lost the game.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class GameOverScreen extends World
{

    /**
     * Constructor for objects of class GameOverScreen.
     * Creates a new world with 580x580 cells with a cell size of 1x1 pixels.
     */
    public GameOverScreen()
    {    
        super(580, 580, 1); 
        prepare();
    }
    
    /**
     * Creates the objects in the game over screen and adds them to the world.
     */
    private void prepare()
    {
       /**
       * Creates and adds one object of class Fail and one object of class GameOver.
       * Sets the location of the two objects.
       * This creates the words present on the Game Over screen.
       */
        GameOver end = new GameOver();
        addObject(end, 290, 290);
        Fail fail = new Fail();
        addObject(fail, 297, 442);
        fail.setLocation(289, 435);
    }
}
