
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
* Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */


public class GameEnvironment {
    
    private static int NO_OF_WARRIORS,NO_OF_FISHES,NO_OF_LOTUS;
    private static int mapWidth,mapLength;
    private static int no_Of_Playing_Warriors;
    private boolean showAllNames=true;
    
    private GameGround game_ground;
    private Treasure_Chest winning_target;
    private ArrayList<GameObject> objectArray;
    private ArrayList<Locatable> objectPositionArray;
    
    
    public GameEnvironment(int mapWidth, int mapLength, int NOW,int NOF,int NOL){
        this.mapWidth=mapWidth;
        this.mapLength=mapLength;
        this.NO_OF_WARRIORS=NOW;
        this.NO_OF_FISHES=NOF;
        this.NO_OF_LOTUS=NOL;
        this.no_Of_Playing_Warriors=NOW;    
        this.objectArray = new ArrayList<GameObject>();
        this.objectPositionArray = new ArrayList<Locatable>();
    }
    
    
    public GameGround getMap(){return game_ground;}
    
    
    //-- getters & setters for No of Objects--
    public int getNoOfWarriors(){
        return NO_OF_WARRIORS;    
    }
    
    public int getNoOfFishes(){
        return NO_OF_FISHES;    
    }
    
    public int getNoOfLotus(){
        return NO_OF_LOTUS;    
    }
    
    public void setNoOfPlayingWarriors(int X){
        no_Of_Playing_Warriors=X;
    }
    
    public int getNoOfPlayingWarriors(){
        return no_Of_Playing_Warriors;
    }
    //-----------------------------------------
  
    
    //-----Getters & Setters for Arrays-------
    public ArrayList<GameObject> getObjectArray(){return objectArray;}
    public ArrayList<Locatable> getPositionArray(){return objectPositionArray;}
    public Treasure_Chest getWinningTarget(){return winning_target;}
    //----------------------------------------
    
    
    public ArrayList<Locatable> getWarriorPositionArray(){
        return new ArrayList<Locatable>(objectPositionArray.subList(0,NO_OF_WARRIORS));    
    }
    
    public ArrayList<Locatable> getFishPositionArray(){
        return new ArrayList<Locatable>(objectPositionArray.subList(NO_OF_WARRIORS,NO_OF_WARRIORS+NO_OF_FISHES));    
    }
    
    public ArrayList<Locatable> getLotusPositionArray(){
        return new ArrayList<Locatable>(objectPositionArray.subList(NO_OF_WARRIORS+NO_OF_FISHES,NO_OF_WARRIORS+NO_OF_FISHES+NO_OF_LOTUS));    
    }
    
    
     public void initiateGame(){
        
        Random RandV = new Random();
        
        System.out.println("==================================================");
        System.out.println("                Game is Initiating..\n");
        
        //----------------------- Create a Lake -----------
        game_ground = new Lake(mapWidth,mapLength);
        //-------------------------------------------------
        
        //---------------------- Create a Treasure chest and place it in the center of the Map--------------------
        winning_target = new Treasure_Chest("HiddenTreasure", game_ground.getCenterCoordinate());
        System.out.println("Chest Located at : "+winning_target.getPosition().getLocationAsString()+"\n");
        
        //----------------------------------------------------------------------------------------------------------
        
        
        //Placing Warriors Randomly in boder------------------------------------------------------------------------
        int RVal = RandV.nextInt(game_ground.getMapLength())+0;
        GameObject warrior1 = new Warrior("Player1",new Location(0,RVal));
        System.out.println("Warrior1 Starting from : "+warrior1.getPosition().getLocationAsString());
        objectArray.add(warrior1);
        objectPositionArray.add(warrior1.getPosition());
        
        RVal = RandV.nextInt(game_ground.getMapLength())+0;
        GameObject warrior2 = new Warrior("Player2",new Location(game_ground.getMapWidth(),RVal));
        System.out.println("Warrior2 Starting from : "+warrior2.getPosition().getLocationAsString());
        objectArray.add(warrior2);
        objectPositionArray.add(warrior2.getPosition());
        
        RVal = RandV.nextInt(game_ground.getMapWidth())+0;
        GameObject warrior3 = new Warrior("Player3",new Location(RVal,0));
        System.out.println("Warrior3 Starting from : "+warrior3.getPosition().getLocationAsString());
        objectArray.add(warrior3);
        objectPositionArray.add(warrior3.getPosition());
        
        RVal = RandV.nextInt(game_ground.getMapWidth())+0;
        GameObject warrior4 = new Warrior("Player4",new Location(RVal,game_ground.getMapLength()));
        System.out.println("Warrior4 Starting from : "+warrior4.getPosition().getLocationAsString());
        objectArray.add(warrior4);
        objectPositionArray.add(warrior4.getPosition());
        
         System.out.println("\n");
                    
        //-------------------------------------------------------------------------------------------------------------
        
        
        //---------------------Fish--------------------------------------------------------------------------------
     
        Locatable location;
        
        //Fish randominize >>>>>>>>>>>
                
        location = GameEngine.LocateNonPlayingObject(winning_target.getPosition(),game_ground.getMapWidth(),game_ground.getMapLength());
        GameObject Fish1 = new InnocentFish("Nemo",location);
        
        location = GameEngine.LocateNonPlayingObject(winning_target.getPosition(),game_ground.getMapWidth(),game_ground.getMapLength());
        GameObject Fish2 = new InnocentFish("Boo",location);
        
        location = GameEngine.LocateNonPlayingObject(winning_target.getPosition(),game_ground.getMapWidth(),game_ground.getMapLength());
        GameObject Fish3 = new RubberEatingFish("Goldie",location);
        
        location = GameEngine.LocateNonPlayingObject(winning_target.getPosition(),game_ground.getMapWidth(),game_ground.getMapLength());
        GameObject Fish4 = new RubberEatingFish("Spike",location);
        
        location = GameEngine.LocateNonPlayingObject(winning_target.getPosition(),game_ground.getMapWidth(),game_ground.getMapLength());
        GameObject Fish5 = new KillerFish("Blue Whale",location); 
        
        location = GameEngine.LocateNonPlayingObject(winning_target.getPosition(),game_ground.getMapWidth(),game_ground.getMapLength());
        GameObject Fish6 = new KillerFish("Pile O' Skulls",location);
        //---------------------------------------------------------------------------------------------------------
        
        //--------------------------- Adding Fish to array---------------------------------------------------------
         
        objectArray.add(Fish1);
        objectArray.add(Fish2);
        objectArray.add(Fish3);
        objectArray.add(Fish4);
        objectArray.add(Fish5);
        objectArray.add(Fish6);
        
        objectPositionArray.add(Fish1.getPosition());
        objectPositionArray.add(Fish2.getPosition());
        objectPositionArray.add(Fish3.getPosition());
        objectPositionArray.add(Fish4.getPosition());
        objectPositionArray.add(Fish5.getPosition());
        objectPositionArray.add(Fish6.getPosition());
        
        System.out.println(">>>6 Fish Created");
        System.out.println (GameEngine.getLocationArrayAsStringArray(getFishPositionArray()));
        System.out.println("\n");
            
        //----------------------------------------------------------------------------------------------------------
        
        
        
        //-----------lotus------------------------------------------------------------------------------------------
                   
        //Lotus randominize >>>>>>>>>>>
        
        location = GameEngine.LocateNonPlayingObject(winning_target.getPosition(),game_ground.getMapWidth(),game_ground.getMapLength());
        Lotus Lotus1 = new Lotus("Nelumbo",location);
               
        location = GameEngine.LocateNonPlayingObject(winning_target.getPosition(),game_ground.getMapWidth(),game_ground.getMapLength());
        Lotus Lotus2 = new Lotus("Nucifera",location);
               
        location = GameEngine.LocateNonPlayingObject(winning_target.getPosition(),game_ground.getMapWidth(),game_ground.getMapLength());
        Lotus Lotus3 = new Lotus("Amazonica",location);
                
        location = GameEngine.LocateNonPlayingObject(winning_target.getPosition(),game_ground.getMapWidth(),game_ground.getMapLength());
        Lotus Lotus4 = new Lotus("Nymphaea",location);
      
        location = GameEngine.LocateNonPlayingObject(winning_target.getPosition(),game_ground.getMapWidth(),game_ground.getMapLength());
        Lotus Lotus5 = new Lotus("Marsilea",location);
        //----------------------------------------------------------------------------------------------------------
        
        //----------------------------------- Adding Lotus to Array ------------------------------------------------
        
        objectArray.add(Lotus1);
        objectArray.add(Lotus2);
        objectArray.add(Lotus3);
        objectArray.add(Lotus4);
        objectArray.add(Lotus5);
        
        
        objectPositionArray.add(Lotus1.getPosition());
        objectPositionArray.add(Lotus2.getPosition());
        objectPositionArray.add(Lotus3.getPosition());
        objectPositionArray.add(Lotus4.getPosition());
        objectPositionArray.add(Lotus5.getPosition());
           
        System.out.println(">>>5 Lotus Created");
        System.out.println (GameEngine.getLocationArrayAsStringArray(getLotusPositionArray()));
        System.out.println("\n");
        //------------------------------------------------------------------------------------------------------------
        
     
        
        //----------------------------------------Showing names of inhabits --------------------------------------------
        System.out.println("\n");
        System.out.println("==================================================");
        System.out.println("                  Game Started");
        System.out.println("==================================================\n");
        System.out.println("Object Array :");
        System.out.println(objectArray);
        System.out.println("\n");
        System.out.println("*****************Names of the inhabits*****************");
                
        
        for (GameObject object: objectArray) {
              
            if (showAllNames==false && object.getClass()==Warrior.class){
                System.out.println(object.getName());
            
            }
            else if(showAllNames=true){
                System.out.println(object.getName());
            }
        }
        System.out.println("*******************************************************\n");
        System.out.println("==================================================");
        System.out.println("                  Start Playing");
        System.out.println("==================================================\n");
        
        //-----------------------------------------------------------------------------------------------------------------
    
    }
     
     
     
     public void updatePositionArray(){
         for(int i=1; i<5; i++){
                GameObject aPlayer = objectArray.get(i);
                objectPositionArray.set(i, aPlayer.getPosition());  
            }
     }
    
}
