import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor spawns enemies.
 * 
 * @author Martin Silberberg
 * @version 4/25/2013
 */
public class MediumAIDirector extends AIDirector
{
    /**
     * This method is called whenever the game environment acts or runs.
     * This method decides how often to spawn enemies.
     */
    public void act() 
    {
        OpeningText world = (OpeningText) getWorld(); 
        if(world.rank.g == 0){
            int x = Greenfoot.getRandomNumber(9500);
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
            if(x < 1055 && x >= 1050)
                spawnBoss(world);
            if(x < 1070 && x >= 1055)
                spawnTeleporter(world); 
        }
        else{
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
}
