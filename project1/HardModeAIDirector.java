import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor spawns enemies in hard mode.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class HardModeAIDirector extends AIDirector
{
    /**
     * Constructor for objects of class HardModeAIDirector.
     */
    public HardModeAIDirector()
    {
    }
    
    /**
     * This method is called whenever the game environment acts or runs.
     * This method decides how often to spawn enemies.
     */
    public void act() 
    {
        World world = getWorld();
        int x = Greenfoot.getRandomNumber(4200);
        if(x < 500)
            spawnBasicEnemy(world);
        if(x < 800 && x >= 500)
            spawnSideUpEnemy(world);
        if(x < 1000 && x >= 800)
            spawnSideDownEnemy(world);
        if(x < 1050 && x >= 1000)
            spawnInvulnUpEnemy(world);
        if(x < 1050 && x >= 1000)
            spawnInvulnDownEnemy(world);
        if(x == 1050 || x == 1051)
            spawnBoss(world);
        if(x < 1060 && x >= 1052)
            spawnTeleporter(world); 
    }    
}
