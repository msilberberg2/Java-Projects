import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This world appears when the player has won the game.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class VictoryScreen extends World
{

    /**
     * Constructor for objects of class VictoryScreen.
     * Creates a new world with 580x580 cells with a cell size of 1x1 pixels.
     */
    public VictoryScreen()
    {    
        super(580, 580, 1); 
        prepare();
    }


    /**
     * Creates the actor in the victory screen and adds it to the world.
     * This creates the words present on the Victory screen.
     */
    private void prepare()
    {
        Victory victory = new Victory();
        addObject(victory, 290, 290);
        Vic vic = new Vic();
        addObject(vic, 306, 84);
        vic.setLocation(362, 84);
        vic.setLocation(337, 85);
    }
}
