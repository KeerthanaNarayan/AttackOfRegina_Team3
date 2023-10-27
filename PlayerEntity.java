       
public class PlayerEntity extends Entity
{
    public PlayerEntity(String name, int[] pos, int Id)
    {
        super(name,pos, Id);
    }

        
    // Moves player but validates against grid size
    public void MovePlayer(String MoveString, int gridSize)
    {
        // Make a dummy grid
        int[][] dummyGrid = new int[gridSize][gridSize];

        // Remember the previous position, in case we move off the board.    
        int[] previousPos = new int[]{this.getEntityPos()[0], this.getEntityPos()[1]};

        try 
        {
            //Move the player
            changePlayerPos(MoveString);
            // attempt to access the element at that grid location
            dummyGrid[getEntityPos()[0]][getEntityPos()[1]]=getEntityId();

        }

        catch (ArrayIndexOutOfBoundsException e) 
        {
            // Inform the player they are off the board.
            System.out.println(StringMessages.getOutOfBoundsMessage());   
            // Revert back to the latest "on-board" position.
            setEntityPos(previousPos);
        }

    }

    //function which updates the player position based on MoveString

    // ONLY THING ABOUT THIS CODE IS THAT IT NEEDS TO BE CALLED INSIDE THE TRY BLOCK IN GRID STATE!
    // Otherwise might get some exception errors!
    public void changePlayerPos(String MoveString)
    { 
        // get the current position
        int[] currentPos = this.getEntityPos();
        switch (MoveString) 
        {
            case "u":
                    //update the row number
                    currentPos[0]-=1;
                    break;
            case"d": 
                    //update the row number
                    currentPos[0]+=1;
                    break;
            case"l": 
                    //update the row number
                    currentPos[1]-=1;
                    break;
            case"r":
                    //update the row number
                    currentPos[1]+=1;
                    break;
            default:
                // Don't need default as we did input validation on MoveString.
                break;
        }
        // set the new entity position
        setEntityPos(currentPos);
        }       

}