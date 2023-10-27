
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;

public class GridState {
    //size of the grid
    private int gridSize;
    // The 2D grid
    private int[][] CurrentGrid;

    // Prepare the Entity classes 
    private MonsterEntity Regina;
    private PlayerEntity Player;
    private Entity Doughnut;


    // Constructor for GridState
    public GridState(int Size)
        {
            // populate the grid with 0s initially
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

        this.InitialiseEntityPositions();
        this.PlacePosOnGrid();
        }


        // populates the three fields playerPos, treasurePos, reginaPOs with three two-tuples from a random uniform distribution.
    public void InitialiseEntityPositions() {
        
        // Ge
        ArrayList<int[]> coordinatesList = ArrayFunctions.generateDistinctCoordinates(3,gridSize);
        
        //instantiate Player, Doughnut and Monster with these positions.
        Player = new PlayerEntity("Player", coordinatesList.get(0),1);
        Doughnut = new Entity("Dougnut",coordinatesList.get(1),2);
        Regina = new MonsterEntity("Regina",coordinatesList.get(2),5);
        
        }

    
    //Print the CurrentGrid to the terminal (loop row b)
    public void PrintGrid()
        {   
            // loop through each row
            for(int i = 0; i < CurrentGrid.length; i++)
            {   
                //p
                if (i>0)
                {
                    System.out.println();
                }                    
                for(int j = 0; j < CurrentGrid.length; j++){
                    // print each element of that row on the same line (no ln)
                    System.out.print(CurrentGrid[i][j] + "  ");

                }
            }
            //Formatting adding an empty line
            System.out.println();
        }

    // Updates the elements coincident with playerPos, treasurePos and reginaPos with corresponding numeric values 
    public void PlacePosOnGrid()
        {   
            // Place a one on the ithgrid location coincident with player position

            // FETCH THIS FROM ENTITY_ID
            CurrentGrid[Player.getEntityPos()[0]][Player.getEntityPos()[1]]=Player.getEntityId();
            CurrentGrid[Doughnut.getEntityPos()[0]][Doughnut.getEntityPos()[1]]=Doughnut.getEntityId();
            CurrentGrid[Regina.getEntityPos()[0]][Regina.getEntityPos()[1]]=Regina.getEntityId();
        }
        

    // Sets all non-zero tiles back to zero.
    public void CleanSlate()
        {
            // Place a zero on the the grid location coincident with player position
            CurrentGrid[Player.getEntityPos()[0]][Player.getEntityPos()[1]]=0;
            // CurrentGrid[Doughnut.getEntityPos()[0]][Doughnut.getEntityPos()[1]]=0;
            // CurrentGrid[Regina.getEntityPos()[0]][Regina.getEntityPos()[1]]=0;
        }
    
    // Update the playerPos field based on the player-inputted MoveString.
    // Edge case handling for playerPos at grid boundary.
    public void UpdateGrid(String MoveString)
        {
        // Convert the grid back to all zeros
        this.CleanSlate();

        //Move the player (does automatic validation internal to MovePlayer!)
        Player.MovePlayer(MoveString, gridSize);

        // Update the grid
        this.PlacePosOnGrid();

        }

    public String FindGameState() 
    {
        if (Arrays.equals(Player.getEntityPos(),Doughnut.getEntityPos())) {
            return "Win";
        }

        else if (Arrays.equals(Player.getEntityPos(),Regina.getEntityPos())) {
            return "Lose";
        }
        else {
            return "InProgress";
        }

        
    }

    public void FindPlayerDistanceFromDoughnut() {
        //Compute distance simple pythagoras theorem.
        double distDouble = Math.sqrt(Math.pow(Doughnut.getEntityPos()[0]-Player.getEntityPos()[0], 2) + Math.pow(Doughnut.getEntityPos()[1]-Player.getEntityPos()[1], 2));
        //Print the rounded distance to the terminal
        System.out.println(StringMessages.getDistanceFromDougnutMessage(distDouble));
    }
    
}

    


    
    
