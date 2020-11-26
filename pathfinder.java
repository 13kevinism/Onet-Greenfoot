import java.util.ArrayList;

public class pathfinder  
{
    pathfinder(){}
    
    board myBoard;
    pathfinder(board myBoard){
        // Store the board the card is on.
        super();
        this.myBoard = myBoard;
    }
    
    public boolean findPath(int[][] gameMap, int startX, int startY, int goalX, int goalY){
        System.out.println("Find Path Called");
        ArrayList<node> path = new ArrayList<node>();
        path = BFS(gameMap, startX, startY, goalX, goalY);
        highlight pathHighlight = new highlight();
        
        if(path != null){
            
            
            for(int i=0 ; i < path.size() ; i++ ){
                //getWorld().removeObjects(getWorld().getObjects(highlight.class));
                myBoard.addObject(pathHighlight, 52+(path.get(i).mapK*52),52+(path.get(i).mapB*52) );
            }
            System.out.println("Flag true");
            return true;
        }
        System.out.println("Flag false");
        return false;
    }
    public ArrayList<node> BFS(int[][] gameMap,int startX, int startY, int goalX, int goalY)
    {
        System.out.println("BFS Called");
        ArrayList<node> queue = new ArrayList<node>();
        int x = startX, y = startY, i = 0;
        int goalValue = gameMap[startX][startY];
        
        
        //tree myTree = new tree();
        node root = new node(false, 0, -1, x, y);
        queue.add(root);
        
        while (i < queue.size()){
            int b = queue.get(i).mapB;
            int k = queue.get(i).mapK;
            int turnCounter = queue.get(i).turnCounter;
            ArrayList<node> myParrent =  queue.get(i).parrent;
            int lastTurn = queue.get(i).turnCounter;
            
            //addParrent();
            if(turnCounter >= 3) {i++;continue;}
            //atas
            int nilaiAtas = gameMap[b-1][k];
            boolean cekParrentAtas = cekParrent(myParrent, b-1, k);
            if((nilaiAtas == 0 || cekGoal(b-1,k,goalX,goalY)) && !cekParrentAtas){
                //System.out.println("atas"+cekParrentAtas);
                queue.get(i).up = new node(nilaiAtas == goalValue, 1, turnCounter + ((lastTurn==1)?0:1), b-1, k);
                queue.add(queue.get(i).up);
                addParrent(queue.get(i).up.parrent, myParrent);
                queue.get(i).up.parrent.add(queue.get(i));
                //System.out.println("atas"+(b-1)+","+k);
                if(cekGoal(b-1,k,goalX,goalY))return queue.get(i).up.parrent;//queue.get(i).up.parrent;
            }
            
            
            //kanan
            int nilaiKanan = gameMap[b][k+1];
            boolean cekParrentKanan = cekParrent(myParrent, b, k+1);
            if((nilaiKanan == 0 || cekGoal(b,k+1,goalX,goalY)) && !cekParrentKanan){
                //System.out.println("kanan"+cekParrentKanan);
                queue.get(i).right = new node(nilaiKanan == goalValue, 2, turnCounter + ((lastTurn==2)?0:1), b, k+1);
                queue.add(queue.get(i).right);
                addParrent(queue.get(i).right.parrent, myParrent);
                queue.get(i).right.parrent.add(queue.get(i));
                //System.out.println("kanan"+b+","+(k+1));
                if(cekGoal(b,k+1,goalX,goalY))return queue.get(i).right.parrent;//queue.get(i).right.parrent;
            }
            
            //bawah
            int nilaiBawah = gameMap[b+1][k];
            boolean cekParrentBawah = cekParrent(myParrent, b+1, k);
            if((nilaiBawah == 0 || cekGoal(b+1,k,goalX,goalY)) && !cekParrentBawah){
                //System.out.println("bawah"+cekParrentBawah);
                queue.get(i).down = new node(nilaiBawah == goalValue, 3, turnCounter + ((lastTurn==3)?0:1), b+1, k);
                queue.add(queue.get(i).down);
                addParrent(queue.get(i).down.parrent, myParrent);
                queue.get(i).down.parrent.add(queue.get(i));
                //System.out.println("bawah"+(b+1)+","+k); 
                if(cekGoal(b+1,k,goalX,goalY))return queue.get(i).down.parrent;//queue.get(i).down.parrent;
            }
            
            //kiri
            int nilaiKiri = gameMap[b][k-1];
            boolean cekParrentKiri = cekParrent(myParrent, b, k-1);
            if((nilaiKiri == 0 || cekGoal(b,k-1,goalX,goalY)) && !cekParrentKiri){
                //System.out.println("kiri"+cekParrentKiri);
                queue.get(i).left = new node(nilaiKiri == goalValue, 4, turnCounter + ((lastTurn==4)?0:1), b, k-1);
                queue.add(queue.get(i).left);
                addParrent(queue.get(i).left.parrent, myParrent);
                queue.get(i).left.parrent.add(queue.get(i));
                //System.out.println("kiri"+b+","+(k-1));
                if(cekGoal(b,k-1,goalX,goalY))return queue.get(i).left.parrent;//queue.get(i).left.parrent;
            }
            /*
            if(nilaiAtas == goalValue || nilaiKanan == goalValue || nilaiBawah == goalValue || nilaiKiri == goalValue) {
                System.out.println("yey temu");
                break;}
            */
            i++;
        }
        return null;//null;
    }
    
    private boolean cekParrent(ArrayList<node> myParrent, int nextB, int nextK){
        //System.out.println("nextB "+nextB+" nextk "+nextK);
        for(int i = 0; i < myParrent.size(); i++){
            //System.out.println(i+" baris parrent "+myParrent.get(i).mapB + "kolom parrent "+myParrent.get(i).mapK);
            if(nextB == myParrent.get(i).mapB && nextK == myParrent.get(i).mapK) {
                return true;
                //return true jika next node merupakan parrent
            }
        }
        //return false jika node berikutnya bukan parrent
        return false;
    }
    
    private void addParrent(ArrayList<node> myParrent, ArrayList<node> ancestors){
        for(int i = 0; i < ancestors.size(); i++){
            myParrent.add(ancestors.get(i));
        }
        
    }
    
    private boolean cekGoal(int currentX, int currentY, int goalX, int goalY){
        if(currentX == goalX && currentY == goalY)return true;
        return false;
    }
}
