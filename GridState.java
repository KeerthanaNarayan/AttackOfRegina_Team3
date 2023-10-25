
import java.util.Arrays;
import java.util.Random;



public class GridState {
    //size of the grid
    private int gridSize;
    // The 2D grid
    private int[][] CurrentGrid;
    //player position
    private int[] playerPos;
    private int[] treasurePos;
    private int[] monsterPos;

    private Random rand = new Random();
    //treasure position
    //monster position

    // Constructor for GridState
    public GridState(int Size)
        {
            gridSize = Size;
            // Create a 2D array of a size specified by gridSize
            CurrentGrid = new int[gridSize][gridSize];
            
            // loop through the 2D array and populate it with zeroes
            for(int i = 0; i < gridSize; i++)
            {
                for(int j = 0; j < gridSize; j++)
                {
                    CurrentGrid[i][j] = 0;
                }
            }

        this.InitialiseGridPositions();
        this.PlacePosOnGrid();

        }

        // populates the three fields playerPos, treasurePos, monsterPOs with three two-tuples from a random uniform distribution.
    public void InitialiseGridPositions() {
        // populate the position fields with random integers between 0 and gridSize
        // but how do we make sure that none of the randomly generates arrays specify the same point on creation?
        rand.nextInt(this.gridSize);
                
        // Need three UNIQUE positions!

        // generate playerPos and treasurePos (at this point, there is a chance they are equal)
        playerPos = ArrayFunctions.GenerateRandomIntegerArray(0,this.gridSize,2);
        treasurePos = ArrayFunctions.GenerateRandomIntegerArray(0,this.gridSize,2);
        
        // while they are equal, keep trying to generate a treasurePos which is not equal. If they are distinct, continue onwards.
        while (Arrays.equals(playerPos,treasurePos)) {
            treasurePos = ArrayFunctions.GenerateRandomIntegerArray(0,this.gridSize,2);
        }

        // do the same with monsterPos, checking coincidence with playerPos and treasurePos.
        monsterPos = ArrayFunctions.GenerateRandomIntegerArray(0,this.gridSize,2);

        while (Arrays.equals(playerPos, monsterPos) || Arrays.equals(treasurePos,monsterPos)) {
            monsterPos = ArrayFunctions.GenerateRandomIntegerArray(0,this.gridSize,2);
        }        
    }

    
    //Print the CurrentGrid to the terminal (loop row b)
    public void PrintGrid()
        {   
            // loop through each row
            for(int i = 0; i < CurrentGrid.length; i++)
            {
                // print a new line for each row
                System.out.println("\n");
                for(int j = 0; j < CurrentGrid.length; j++){
                    // print each element of that row on the same line (no ln)
                    System.out.print(CurrentGrid[i][j] + "  ");

                }
            }
        }

    // Updates the elements coincident with playerPos, treasurePos and monsterPos with corresponding numeric values 
    public void PlacePosOnGrid(){

        // loop through all indices of the array
         for(int i = 0; i < this.gridSize; i++)
            {
                for(int j = 0; j < this.gridSize; j++)
                {
                    // if the indices are coincident with the location of the player, update that tile from 0 to 1
                    if (i == playerPos[0] && j == playerPos[1]){
                        CurrentGrid[i][j] = 1;
                    }  
                    // if the indices are coincident with the location of the treasure, update that tile from 0 to 5
                    if (i == treasurePos[0] && j == treasurePos[1]){
                        CurrentGrid[i][j] = 5;
                    }
                    // if the indices are coincident with the location of the monster, update that tile from 0 to 2
                    if (i == monsterPos[0] && j == monsterPos[1]){
                        CurrentGrid[i][j] = 2;
                    }
                }
            }
    }

    public  int[][] getCurrentGrid() 
    {
        return CurrentGrid;
    }

    public void UpdateGrid(String MoveString)
    {
    
    switch (MoveString) {
        case "u":case"d": case"l": case"r": break;
    }


    }
    
}


    
    