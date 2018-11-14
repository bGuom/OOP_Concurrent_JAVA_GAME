


/*
 * Classname : Warrior
*
 * Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */


public class Warrior extends Player{
    private boolean has_Swim_Fins;
    private boolean can_Swim;
    private boolean is_Alive;
    private boolean immotal;
    private boolean has_Binoculars;
    private boolean can_See_Warriors;
    private boolean can_See_Fish;
    private boolean can_See_Lotus;
    private boolean got_The_Chest;
    private boolean playing;
    long Starting_Time;
    long Finishing_Time;
    

    
    public Warrior(String name, Locatable position){
        super(name,"Warrior",position);
        this.has_Swim_Fins=true;
        this.can_Swim=true;
        this.is_Alive=true;
        this.immotal=false;
        this.has_Binoculars=false;
        this.can_See_Warriors=true;
        this.can_See_Fish=false;
        this.can_See_Lotus=false;
        this.got_The_Chest=false;
        this.playing=true;
        this.Starting_Time=System.currentTimeMillis();
    }
    
    
    
        
    
    //----------------------Eat Method----------------------------

    
    @Override
    public void eat(){}
    //------------------------------------------------------------
    
    //-------------------------Sleep Method-----------------------
    @Override
    public void sleep(){}
    //------------------------------------------------------------
    
    //---------------------------Swim Method----------------------
    @Override
    public void swim(int X, int Y){
        this.position = new Location(X,Y);       
    }
    //------------------------------------------------------------
    

    //---------------- Lost fins -------------------------
    public void lostFins(){
        this.can_Swim=false;
        this.has_Swim_Fins=false;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    
    
    //---------------- get killed -------------------------
    public void killed(){
        this.is_Alive=false;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    
    
    //---------------- is winner -------------------------
    public void makeWinner(){
        this.got_The_Chest=true;
        this.Finishing_Time = System.currentTimeMillis();
        long timeElapsed = (this.Finishing_Time-this.Starting_Time);
        String time= timeElapsed +" milliseconds";
        System.out.println(GameEngine.saveToFile(this.getName(), time));
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    
    
    //---------------- return fins status  -----------------
    public boolean getFinsStatus(){
        return this.has_Swim_Fins;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    
    
    //---------------- return alive or not -----------------
    public boolean getLifeStatus(){
        return this.is_Alive;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    
    
    //---------------- become immotal ---------------------
    public void setImmotalStatusTrue(){
        this.immotal=true;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    
    
    //---------------- return immotal or not --------------
    public boolean getImmotalStatus(){
        return this.immotal;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    
    
    //--------------- return has bino or not --------------
    public boolean getBinoStatus(){
        return this.has_Binoculars;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    
    
    //---------------- set has bino true ------------------
    public void setBinoStatusTrue(){
        this.has_Binoculars=true;
        this.can_See_Lotus=true;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    
    
    public void getNotification(boolean status){
        if (status==true){
            this.playing=false;
            System.out.println(this.getName()+" has notified by the chest\n"+this.getName()+" Stopped Playing");
        }
                       
    }
   
    public void notifyChest(Treasure_Chest chest){
        chest.addNewPlayer(this);
        System.out.println(this.getName()+" Notified to the Chest");
    }
    
   
 

}

//=============================================================================================================================
//                                       END      OF       THE         CLASS
//=============================================================================================================================