public class BotClean {

    public static void main(String[] args) {
        /*
        *   When creating the game object, three parameters are given:
        *   int width: the width in tiles of the grid.
        *   int height: the height in tiles of the grid.
        *   double density: the % of tiles to be dirtied.
        *   
        *   You can vary this to test your strategy!
        */
        BotCleanGame game = new BotCleanGame(10, 10, 0.1);
        
        while(!game.isOver()) {
            /*
            *   This is where you can decide how to make your move and make it!
            *   You can use the following methods as much as you want:
            *   game.move(String): make a move, takes in either "UP", "DOWN", "LEFT" or "RIGHT".
            *   game.seeFloor(): prints the board to the screen, can be useful!
            *   game.getFloor(): get a copy of the current board as a 2D array
            *   game.getPosition(): get your current position as an int array {y,x}
            */
            
            break; //Remove this when you actually have something to make the loop stop!
            
        }
        
        //Print the final move count & the final board.
        System.out.println("You finished the task in " + game.getTotalMoves() + " moves!");
        game.seeFloor();
    }
    
}
