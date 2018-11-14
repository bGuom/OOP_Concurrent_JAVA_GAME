/*
 * Interface : Locatable
*
 * Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerSimulation implements Runnable{
    
      
    
    private Warrior aWarrior;
    private static GameEnvironment gameEnvironment;
    
    private static WinningTarget winnig_target;
    private static String[] winningTargetSurroundArray;
    private static int mapWidth;
    private static int mapLength;
        
    
    
    public PlayerSimulation(Warrior aWarrior, GameEnvironment gameEnvironment){
        
        this.aWarrior=aWarrior;
        this.gameEnvironment=gameEnvironment;
        this.winningTargetSurroundArray=GameEngine.getSurroundArray(gameEnvironment.getWinningTarget().getPosition());
        this.mapWidth = gameEnvironment.getMap().getMapWidth();
        this.mapLength = gameEnvironment.getMap().getMapLength();
               
    }
    

   
    
    
    
    
    //==============================================================================================================================================================================================
    //                                                   LOGIC       OF       THE         GAME
    //==============================================================================================================================================================================================
    
    @Override
    public void run(){
        
        winnig_target = gameEnvironment.getWinningTarget(); 
     
               
                
        while ( !winnig_target.isAchieved() && (gameEnvironment.getNoOfPlayingWarriors()>0)){
            
            synchronized(this) {
                gameEnvironment.updatePositionArray();            
            }


            Random randV = new Random(); 
            int currentCoordinateX;
            int currentCoordinateY;
            
            int newCoordinateX;
            int newCoordinateY;
            
            boolean playerMoved = false;


            while(playerMoved==false){

                currentCoordinateX=aWarrior.getPosition().getLocationX();
                currentCoordinateY=aWarrior.getPosition().getLocationY();
                newCoordinateX = currentCoordinateX;
                newCoordinateY = currentCoordinateY;

                if ((aWarrior.getLifeStatus()) &&(aWarrior.getFinsStatus())){  // Warrior is alive and can swim

                    Locatable NowLocation = aWarrior.getPosition();
                 
                    if (GameEngine.checkNearWin(winnig_target.getPosition(),NowLocation)){   // if Warrior is near the chest go to chest
                        playerMoved=true;
                        aWarrior.setPosition(winnig_target.getPosition());
                        System.out.println(aWarrior.getName()+" Moved to : " + winnig_target.getPosition().getLocationAsString() +"\n");
                        winnig_target.setAsAchieved();
                        aWarrior.makeWinner();
                        

                        System.out.println("==================================================");
                        System.out.println("                  TADAAAAAA");
                        System.out.println("             "+aWarrior.getName()+" Won the Game ");
                        System.out.println("==================================================\n");
                        System.exit(0);
                    }
                    else{


                        int rVal1 = randV.nextInt(4)+1; // Generate random number (For select random swim direction)

                        switch(rVal1){

                            case 1:
                                if (currentCoordinateX<mapWidth){
                                    newCoordinateX=currentCoordinateX+1;
                                    newCoordinateY=currentCoordinateY;
                                }
                                else{
                                    newCoordinateX=currentCoordinateX-1;
                                    newCoordinateY=currentCoordinateY;
                                }
                                break;

                            case 2:
                                if (currentCoordinateX>0){
                                    newCoordinateX=currentCoordinateX-1;
                                    newCoordinateY=currentCoordinateY;
                                }
                                else{
                                    newCoordinateX=currentCoordinateX+1;
                                    newCoordinateY=currentCoordinateY;
                                }
                                break;

                            case 3:
                                if (currentCoordinateY<mapLength){
                                    newCoordinateX=currentCoordinateX;
                                    newCoordinateY=currentCoordinateY+1;
                                }
                                else{
                                    newCoordinateX=currentCoordinateX;
                                    newCoordinateY=currentCoordinateY-1;
                                }
                                break;
                            case 4:

                                if (currentCoordinateY>0){
                                    newCoordinateX=currentCoordinateX;
                                    newCoordinateY=currentCoordinateY-1;
                                }
                                else{
                                    newCoordinateX=currentCoordinateX;
                                    newCoordinateY=currentCoordinateY+1;
                                }
                                break;
                        }

                        Locatable NewLocation = new Location(newCoordinateX,newCoordinateY);

                        if (NewLocation.getLocationAsString().equals(winnig_target.getPosition().getLocationAsString())){
                            winnig_target.setAsAchieved();
                            aWarrior.makeWinner();
                            System.out.println("==================================================");
                            System.out.println("                  TADAAAAA");

                            System.out.println("             "+aWarrior.getName()+" Won the Game ");
                            System.out.println("==================================================\n");
                            System.exit(0);

                         }

                        //--------------------------------------- Super Warriors with bino can see lotus----------------------------------
                        if (aWarrior.getBinoStatus()==true){
                            String[] SurroundArray = GameEngine.getSurroundArray(aWarrior.getPosition());
                            for (int i = 0; i < gameEnvironment.getNoOfLotus(); i++){
                                for (int j = 0; j < SurroundArray.length; j++){
                                    if (gameEnvironment.getLotusPositionArray().get(i).getLocationAsString()==SurroundArray[j]){                          
                                        int x = (gameEnvironment.getLotusPositionArray().get(i).getLocationX());
                                        int y = (gameEnvironment.getLotusPositionArray().get(i).getLocationY());
                                        aWarrior.swim(x,y);
                                        playerMoved=true;
                                        System.out.println(aWarrior.getName()+" Moved to : " + NewLocation);
                                    }
                                }
                            }
                        }
                        //------------------------------------------------------------------------------------------------------------------


                        //------------------Check new location to see whether it is occupied ---------------------------------------------
                        if (Arrays.asList(gameEnvironment.getWarriorPositionArray()).contains(NewLocation)){
                            playerMoved=false;
                            System.out.println(aWarrior.getName()+" Can not Move to : " + NewLocation.getLocationAsString() + ", There is a Warrior");
                        }
                        else {                 
                            aWarrior.swim(newCoordinateX,newCoordinateY);
                            playerMoved=true;
                            System.out.println(aWarrior.getName()+" Moved to : " + NewLocation.getLocationAsString());
                        }
                        //----------------------------------------------------------------------------------------------------------------
                    }

                } 
                else{   //---------- If not alive or hasn't fins---------------------
                    System.out.println(aWarrior.getName()+" is not playing");
                    playerMoved=true;                
                }
            }
            //**********************************
            // PLAYER MOVED TO A NEW LOCATION


            String MovedLocation = aWarrior.getPosition().getLocationAsString();
            
            
            
    
            //---------------------------- Check new location for lotus -------------
            if (GameEngine.getLocationArrayAsStringArray(gameEnvironment.getLotusPositionArray()).indexOf(MovedLocation)!=-1){
                aWarrior.setImmotalStatusTrue();
                System.out.println(aWarrior.getName()+" is now IMMOTAL");
            }
            //-----------------------------------------------------------------------

            //---------------------------- Check new location for fish --------------
            else if (GameEngine.getLocationArrayAsStringArray(gameEnvironment.getFishPositionArray()).indexOf(MovedLocation)!=-1){
                for(int i = 0; i < gameEnvironment.getNoOfFishes(); i++){
                    if(gameEnvironment.getFishPositionArray().get(i).getLocationAsString().equals(MovedLocation)){
                        switch (i){
                            case 0:
                                System.out.println(aWarrior.getName()+" is on innocent fish");
                                break;
                                
                            case 1:
                                System.out.println(aWarrior.getName()+" is on innocent fish");
                                break;
                                
                            case 2:
                                if (aWarrior.getFinsStatus()==true){
                                    aWarrior.lostFins();
                                    gameEnvironment.setNoOfPlayingWarriors(gameEnvironment.getNoOfPlayingWarriors()-1);
                                    System.out.println(aWarrior.getName()+" lost his fins");
                                }  
                                break;
                                
                            case 3:
                                if (aWarrior.getFinsStatus()==true){
                                    aWarrior.lostFins();
                                    gameEnvironment.setNoOfPlayingWarriors(gameEnvironment.getNoOfPlayingWarriors()-1);
                                    System.out.println(aWarrior.getName()+" lost his fins");
                                }  
                                break;

                            case 4:
                                if (aWarrior.getImmotalStatus()==false && aWarrior.getLifeStatus()==true){
                                    aWarrior.killed();
                                    gameEnvironment.setNoOfPlayingWarriors(gameEnvironment.getNoOfPlayingWarriors()-1);
                                    System.out.println(aWarrior.getName()+" is killed by Killer fish");
                                    break;
                                } else if (aWarrior.getImmotalStatus()) {
                                    System.out.println("Killer fish couldn't kill IMMOTAL "+aWarrior.getName());                                
                                }

                            case 5:
                                if (aWarrior.getImmotalStatus()==false && aWarrior.getLifeStatus()==true ){
                                    aWarrior.killed();
                                    gameEnvironment.setNoOfPlayingWarriors(gameEnvironment.getNoOfPlayingWarriors()-1);
                                    System.out.println(aWarrior.getName()+" is killed by Killer fish");
                                    break;

                                }else if (aWarrior.getImmotalStatus()) {
                                    System.out.println("Killer fish couldn't kill IMMOTAL "+aWarrior.getName());                                
                                }
                                

                        }
                    }
                }
                
                if (gameEnvironment.getNoOfPlayingWarriors()==0) {
                    System.out.println("==================================================\n                        OOPS\n                      GAME OVER\n==================================================\n");
                    System.exit(0);
                    break;
                    
                }  

            }
            try {
                //------------------------------------------------------------------------
                Thread.sleep(50);
         
            } catch (InterruptedException ex) {
                Logger.getLogger(PlayerSimulation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //==============================================================================================================================================================================================
    //                                                   END        OF       THE         LOGIC
    //==============================================================================================================================================================================================
  
}
