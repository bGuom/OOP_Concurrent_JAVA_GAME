
import java.util.ArrayList;

/*
 * Classname : Treasue_Chest
*
 * Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */


public class Treasure_Chest extends GameObject implements WinningTarget {
    private boolean taken;
    private ArrayList<Warrior> notifyList;
    
    public Treasure_Chest(String name, Locatable position){
        super(name,"Chest",position);
        notifyList = new ArrayList<Warrior>();
        this.taken=false; 
    }
    
    //------- getters & setters for Chest status------
    @Override
    public void setAsAchieved(){
        this.taken=true;
        notifyPlayers(notifyList,this.taken);  
    }
    
    public void addNewPlayer(Warrior aWarrior){
        notifyList.add(aWarrior);
    }
    
    private void notifyPlayers(ArrayList<Warrior> warriorArray,Boolean status){ 
        for(Warrior aWarrior: warriorArray)
            aWarrior.getNotification(status);
                   
        
    }
         
 
    
    public boolean isAchieved(){
        return this.taken;
    }
    //-------------------------------------------------
    //-------------------------------------------------
    
}

//=============================================================================================================================
//                                       END      OF       THE         CLASS
//=============================================================================================================================