import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class jerman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class jerman extends card
{
    int baris,kolom;
    
    public jerman(int b,int k,board myBoard){
        super(myBoard);
        // Store the board the piece is on.
        this.myBoard = myBoard;
        baris = b;
        kolom = k;
    };
    
    /**
     * Act - do whatever the jerman wants to do. This method is called whenever
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
