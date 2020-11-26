import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class italia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class italia extends card
{
    int baris,kolom;
    
    public italia(int b,int k,board myBoard){
        super(myBoard);
        // Store the board the piece is on.
        this.myBoard = myBoard;
        baris = b;
        kolom = k;
    };
    
    /**
     * Act - do whatever the italia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {if(Greenfoot.mouseClicked(this))
        {
            nextTurn(baris,kolom);
            
        }
        
        // Add your action code here.
    }    
}
