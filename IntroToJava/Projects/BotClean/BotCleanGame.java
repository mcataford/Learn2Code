import java.util.Random;

public class BotCleanGame {
    private boolean[][] grid;
    private int x, y;
    private Random randomGenerator;
    private int totalMoves;
    
    /*
    *   Initializes the game
    *
    *   @param width Width of the grid.
    *   @param height Height of the grid.
    *   @param density Percentage of the grid to be dirtied between 0 and 1.
    */
    
    public BotCleanGame(int width, int height, double density) {
        this.randomGenerator = new Random();
        this.grid = new boolean[height][width];
        this.totalMoves = 0;
        
        //Calculate the total number of tiles, and the tiles to dirty.
        int totalTiles = width * height;
        int totalDirty = (int) (totalTiles * density);
        
        //As long as there are tiles to dirty...
        for(int i = 0 ; i < totalDirty ;) {
            //Pick a random coordinate
            int randX = this.randomGenerator.nextInt(width);
            int randY = this.randomGenerator.nextInt(height);
            
            //If the tile isn't dirty yet AND isn't the start point, dirty it.
            if(!this.grid[randY][randX] && !(randX == 0 && randY == 0)) {
                this.grid[randY][randX] = true;
                i++;
            }
        }
        
        //Setting the initial position.
        this.x = 0;
        this.y = 0;
    }
    
    /*
    * Prints hte whole floorplan. C represents the player, X represents dirt and -, empties.
    */
    
    public void seeFloor() {
        for(int y = 0 ; y < this.grid.length ; y++) {
            for(int x = 0 ; x < this.grid[0].length ; x++) {
                if(x == this.x && y == this.y) {
                    System.out.print("C");
                } else if(this.grid[y][x]) {
                    System.out.print("X");
                } else {
                    System.out.print("-");
                }
                
                System.out.print(" ");
            }
            System.out.println("");
        }
        
        System.out.println("");
    }
    
    /*
    * Executes one move given by the user, if possible. Returns if the move was valid or not.
    *
    * @param direction One of ["UP","DOWN","LEFT","RIGHT"] representing the direction to move in.
    * @return A boolean representing the validity of the move.
    */
    public boolean move(String direction) {
        boolean validMove = true;
        
        if(direction.equals("UP") && this.y > 0) {
            this.y -= 1;
        } else if(direction.equals("DOWN") && this.y < this.grid.length - 1) {
            this.y += 1;
        } else if(direction.equals("LEFT") && this.x > 0) {
            this.x -= 1;
        } else if(direction.equals("RIGHT") && this.x < this.grid[0].length - 1) {
            this.x += 1;
        } else {
            validMove = false;
        }
        
        if(validMove && this.grid[this.y][this.x]) {
            this.grid[this.y][this.x] = false;
        }
        
        if(validMove) {
            this.totalMoves++;
        }
        
        return validMove;
    }
    
    /*
    * Verifies if the game is still on. The game is over if there are no more dirty tiles.
    *
    * @return A boolean representing whether the game is over.
    */
    public boolean isOver() {
        for(int y = 0 ; y < this.grid.length ; y++) {
            for(int x = 0 ; x < this.grid[0].length ; x++) {
                if(this.grid[y][x]) return false;
            }
        }
        
        return true;
    }
    
    public boolean[][] getFloor() { return this.grid; }
    public int[] getPosition() { return new int[]{this.y, this.x}; }
    public int getTotalMoves() { return this.totalMoves; }
}
