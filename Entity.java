// Monster class (base class for different monster variants, MovingRegina, Hi, angryregina

public class Entity
{

    private String entityName;
    private int[] entityPos;
    private int entityId;
    
    public Entity(String name,  int[] pos, int Id){
        this.entityName = name;
        this.entityPos = pos;
        this.entityId = Id;
    }

    public String getName(){
        return entityName;
    }


    public int[] getEntityPos(){
        return entityPos;
    }

    public int getEntityId()
    {
        return entityID;
    }

    public void setEntityPos(int[] pos){
        entityPos = pos;
    }

}