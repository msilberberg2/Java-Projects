import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents the opening title.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class Title extends Actor
{
    /**
     * This method is called whenever the game environment acts or runs.
     * It creates the title image.
     */
    public void act() 
    {
        prepare();
    }    

    /**
     * Prepare the first paragraph (the next text box).
     */
    private void prepare()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            World world = getWorld();
            world.removeObject(this);
            OpeningParagraph openingparagraph = new OpeningParagraph();
            world.addObject(openingparagraph, 287, 177);
        }
    }
    
    /**
     * Constructor for objects of class Title.
     */
    public Title()
    {
    }
}
