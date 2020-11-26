import java.util.ArrayList;

public class node  
{
    boolean isGoal; //boolean node tujuan atau bukan
    ArrayList<node> parrent = new ArrayList<node>();
    int lastTurn; // 1 atas // 2 kanan // 3 bawah // 4 kiri
    int turnCounter; //menghitung banyak perubahan arah
    int mapB, mapK; //menyimpan posisi baris dan kolom node pada matriks
    
    
    node up;
    node right;
    node down;
    node left;
    
    
    node(boolean isGoal,int lastTurn, int turnCounter, int mapB, int mapK) {
        this.isGoal = isGoal;
        this.lastTurn = lastTurn;
        this.turnCounter = turnCounter;
        this.mapB = mapB;
        this.mapK = mapK;

        up = null;
        right = null;
        down = null;
        left = null;
    }
    
    
}
