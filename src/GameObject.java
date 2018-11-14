/*
 * Classname : GameObject
*
 * Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */


public abstract class GameObject {
    protected String name;
    protected String type;
    protected Locatable position;
    
    public GameObject(String name, String type, Locatable position){
        this.name=name;
        this.type=type;
        this.position=position;
    
    }
      
    
    //------------- getter & setters for name ---------------
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    //------------------------------------------------------
    //------------------------------------------------------
    
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type=type;
    }
        
    
    public Locatable getPosition(){
        return position;    
    }
    
    public void setPosition(Locatable position){
        this.position = position;    
    }
    
}

//=============================================================================================================================
//                                       END      OF       THE         ABSTRACT         CLASS
//=============================================================================================================================