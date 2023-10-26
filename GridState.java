
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;



public class GridState {
    //size of the grid
    private int gridSize;
    // The 2D grid
    private int[][] CurrentGrid;
    //player position
    private int[] playerPos;
    private int[] doughnutPos;
    private int[] reginaPos;


    private Random rand = new Random();
    //treasure position
    //regina position

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

        // populates the three fields playerPos, treasurePos, reginaPOs with three two-tuples from a random uniform distribution.
    public void InitialiseGridPositions() {
        // populate the position fields with random integers between 0 and gridSize
        // but how do we make sure that none of the randomly generates arrays specify the same point on creation?
        rand.nextInt(this.gridSize);
                
        // Need three UNIQUE positions!

        // generate playerPos and treasurePos (at this point, there is a chance they are equal)
        playerPos = ArrayFunctions.GenerateRandomIntegerArray(0,this.gridSize,2);
        doughnutPos = ArrayFunctions.GenerateRandomIntegerArray(0,this.gridSize,2);
        
        // while they are equal, keep trying to generate a treasurePos which is not equal. If they are distinct, continue onwards.
        while (Arrays.equals(playerPos,doughnutPos)) {
            doughnutPos = ArrayFunctions.GenerateRandomIntegerArray(0,this.gridSize,2);
        }

        // do the same with reginaPos, checking coincidence with playerPos and treasurePos.
        reginaPos = ArrayFunctions.GenerateRandomIntegerArray(0,this.gridSize,2);

        while (Arrays.equals(playerPos, reginaPos) || Arrays.equals(doughnutPos,reginaPos)) {
            reginaPos = ArrayFunctions.GenerateRandomIntegerArray(0,this.gridSize,2);
        }        
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
            CurrentGrid[playerPos[0]][playerPos[1]]=1;
            // CurrentGrid[doughnutPos[0]][doughnutPos[1]]=5;
            // CurrentGrid[reginaPos[0]][reginaPos[1]]=2;
            }
        }

    // Sets all non-zero tiles back to zero.
    public void CleanSlate()
        {
            // Place a zero on the the grid location coincident with player position
            CurrentGrid[playerPos[0]][playerPos[1]]=0;
            // PLace a zero where the grid location is coincident with treasurePos
            // CurrentGrid[doughnutPos[0]][doughnutPos[1]]=0;
            // CurrentGrid[reginaPos[0]][reginaPos[1]]=0;
        }
    
    // Update the playerPos field based on the player-inputted MoveString.
    // Edge case handling for playerPos at grid boundary.
    public void UpdateGrid(String MoveString)
        {

        // Remember the previous position, in case we move off the board.    
        int[] previousPos = new int[]{playerPos[0], playerPos[1]};

        // Convert the grid back to all zeros
        this.CleanSlate();

        try 
        {
            switch (MoveString) {
                case "u":
                        playerPos[0]-=1;
                        break;
                case"d": 
                        playerPos[0]+=1;
                        break;
                case"l": 
                        playerPos[1]-=1;
                        break;
                case"r":
                        playerPos[1]+=1;
                        break;
                default:
                    // Don't need default as we did input validation on MoveString.
                    break;
        }
            // Place the entities back on the grid, with the updated player position playerPos
            PlacePosOnGrid();
        }

        catch (ArrayIndexOutOfBoundsException e) 
        {
            // Inform the player they are off the board.
            System.out.println("You're at the edge of the board! Moving nowhere.");   
            // Revert back to the latest "on-board" position.
            playerPos[0] = previousPos[0];
            playerPos[1] = previousPos[1];
            // Place the entities back on the board.
            PlacePosOnGrid();
        }
        
            
                
        }

    
    public String FindGameState() {
        if (Arrays.equals(playerPos,doughnutPos)) {
            return "Win";
        }

        else if (Arrays.equals(playerPos,reginaPos)) {
            return "Lose";
        }
        else {
            return "InProgress";
        }

        
    }

    public void FindPlayerDistanceFromDoughnut() {
        //Compute distance simple pythagoras theorem.
        double distDouble = Math.sqrt(Math.pow(doughnutPos[0]-playerPos[0], 2) + Math.pow(doughnutPos[1]-playerPos[1], 2));
        //Print the rounded distance to the terminal
        System.out.println("Donald's distance from the doughnut is: " + Math.round(distDouble));
    }
    

    }
    


    
    
