/*
 * Classname : Gamedemo
*
 * Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */

import java.util.ArrayList;

public class GameDemo {

    public static void main(String[] args) {
        
        GameEngine NozamaEngine = new GameEngine();
        
        //-------------- Create GameEnvironment -------------------------
        GameEnvironment gameEnvironment = new GameEnvironment(10,10,4,6,5);
        //------------------------------------------------------------

        //===========================================================
        gameEnvironment.initiateGame();
           
       
        ArrayList<GameObject> ObjectArray = gameEnvironment.getObjectArray();
        
        
        //==========================================================
        for(int i=0; i<gameEnvironment.getNoOfWarriors(); i++){
            Warrior aWarrior = (Warrior)ObjectArray.get(i);
            aWarrior.notifyChest(gameEnvironment.getWinningTarget());
        }        
        
            
        Thread thread1=new Thread(new PlayerSimulation((Warrior)gameEnvironment.getObjectArray().get(0),gameEnvironment));
        Thread thread2=new Thread(new PlayerSimulation((Warrior)gameEnvironment.getObjectArray().get(1),gameEnvironment));
        Thread thread3=new Thread(new PlayerSimulation((Warrior)gameEnvironment.getObjectArray().get(2),gameEnvironment));
        Thread thread4=new Thread(new PlayerSimulation((Warrior)gameEnvironment.getObjectArray().get(3),gameEnvironment));
           
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        
   
      
            
        
            
    }
}

//=============================================================================================================================
//                                       END      OF       THE         CLASS
//=============================================================================================================================