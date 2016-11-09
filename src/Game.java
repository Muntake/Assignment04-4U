
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author munta
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create game board
        Board board = new Board(12, 12);
        //create daleks 
        Dalek[] dalek = new Dalek[3];
        //for loop to place daleks on board
        for (int i = 0; i <= 2; i++) {
            int dalCol = (int) (Math.random() * 12);
            int dalRow = (int) (Math.random() * 12);
            dalek[i] = new Dalek(dalRow, dalCol);
            
        }

        //generate randome place for Doc to start in,row,col
        int docRow = (int) (Math.random() * 12);
        int docCol = (int) (Math.random() * 12);
        //create new Doc
        Doctor Doc = new Doctor(docRow, docCol);

        //check to see if the docotr has landed on any of thr daleks 
        //if docotr lands on dalek 1 then 
        while (Doc.getRow() == dalek[0].getRow() && Doc.getCol() == dalek[0].getCol()) {
            // remove Doc
            board.removePeg(Doc.getRow(), Doc.getCol());
            // place Doc at new location 
            Doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        //check doc and dalek 2
        while (Doc.getRow() == dalek[1].getRow() && Doc.getCol() == dalek[1].getCol()) {
            // remove doc
            board.removePeg(Doc.getRow(), Doc.getCol());
            //place doc at new location 
            Doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        //check docc and  dalek 3
        while (Doc.getRow() == dalek[2].getRow() && Doc.getCol() == dalek[2].getCol()) {
            // remove doc 
            board.removePeg(Doc.getRow(), Doc.getCol());
            // place doc at new location
            Doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }

        //check to see if anyof the dalkes have crashed wiht each other 
        //if daleks have, then only respawn the one tha has not crashed
        //check dalek at position 1 and 2 
        while (dalek[0].getRow() == dalek[1].getRow() && dalek[0].getCol() == dalek[1].getCol()) {
            // remove the dalek 
            board.removePeg(dalek[0].getRow(), dalek[0].getCol());
            // Create a new location for the Dalek 1
            dalek[0] = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        // check dalek 1 and 3 
        while (dalek[0].getRow() == dalek[2].getRow() && dalek[0].getRow() == dalek[2].getCol()) {
            // Remove the daleks peg 
            board.removePeg(dalek[0].getRow(), dalek[0].getCol());
            // place dalek one again 
            dalek[0] = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }
        //  check dalek 2 and 3 
        while (dalek[1].getRow() == dalek[2].getRow() && dalek[1].getCol() == dalek[2].getCol()) {
            // Remove Dalek 2 peg
            board.removePeg(dalek[1].getRow(), dalek[1].getCol());
            // Create a new location for Dalek 2
            dalek[1] = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }

        //place all pegs before game starts 
        //place Doc 
        board.putPeg(Color.GREEN, Doc.getRow(), Doc.getCol());
        //place all dalkes
        for (int i = 0; i <= 2; i++) {
            board.putPeg(Color.BLACK, dalek[i].getRow(), dalek[i].getCol());
        }
        board.displayMessage("Click anyhere to move the doctor!GOOD LUCK FAM!");

        //game loop(start of game)
        while (true) {
            //check if daleks have capatured Doc 

            if (dalek[0].getRow() == Doc.getRow() && dalek[0].getCol() == Doc.getCol()
                    || dalek[1].getRow() == Doc.getRow() && dalek[1].getCol() == Doc.getCol()
                    || dalek[2].getRow() == Doc.getRow() && dalek[2].getCol() == Doc.getCol()) {
                //place peg where doc and dalek crash 
                board.putPeg(Color.YELLOW, Doc.getRow(), Doc.getCol());
                // Tell the player they have lost 
                board.displayMessage("The Doc has been captured,You Lose!");
                //break game loop (end game)
                break;
                
            }

            //check to see if an of thr daleks have crashed with eachother
            if (dalek[0].getCol() == dalek[1].getCol() && dalek[0].getRow() == dalek[1].getRow()
                    && dalek[0].getRow() == dalek[2].getRow() && dalek[0].getCol() == dalek[2].getCol()
                    && dalek[1].getRow() == dalek[2].getRow() && dalek[1].getCol() == dalek[2].getCol()) {
                //make all daleks crash 
                dalek[0].crash();
                dalek[1].crash();
                dalek[2].crash();
                // place a peh where they have crashed 
                board.putPeg(Color.RED, dalek[0].getRow(), dalek[0].getCol());
                // Tell they player they have won  
                board.displayMessage("All Daleks have crashed,You win!!!!");
                // End the game if all dalkes have crashed 
                break;
            }
            //check to seeif dalek 1 and 2 have crashed if so ,put peg at crash site 
            if (dalek[0].getRow() == dalek[1].getRow() && dalek[0].getCol() == dalek[1].getCol()) {
                //dalek 1 and 2 crash
                dalek[0].crash();
                dalek[1].crash();
                // put red peg at crash site 
                board.putPeg(Color.RED, dalek[0].getRow(), dalek[0].getCol());
            }
            //check to see if dalek 1 and 3 have crashed if so ,put peg at crash site 
            if (dalek[0].getRow() == dalek[2].getRow() && dalek[0].getCol() == dalek[2].getCol()) {
                //dalek 1 and 3 crash
                dalek[0].crash();
                dalek[2].crash();
                //put red  peg a crash site 
                board.putPeg(Color.RED, dalek[2].getRow(), dalek[2].getCol());
            }
            // //check to see if dalek 2 and 3 have crashed if so ,put peg at crash site 
            if (dalek[1].getRow() == dalek[2].getRow() && dalek[1].getCol() == dalek[2].getCol()) {
                // dalek 2 and 3 crash 
                dalek[1].crash();
                dalek[2].crash();
                // Put a red peg at crash site
                board.putPeg(Color.RED, dalek[1].getRow(), dalek[1].getCol());
            }

            // get the cordinates of the click 
            Coordinate click = board.getClick();
            //remove the previuse doc peg 
            board.removePeg(Doc.getRow(), Doc.getCol());
            // Move the dco to the location (call for move method)
            Doc.move(click.getRow(), click.getCol());
            //put the Doc at new location 
            board.putPeg(Color.GREEN, Doc.getRow(), Doc.getCol());

            //dalkes turn, move all the daleks toward Doc 
            // if dalek at i has not crahsed move dalek
            //for loop that goes thrught all dalkes 
            for (int i = 0; i <= 2; i++) {

                //if no daleks have crashed ,move the daleks 
                if (dalek[i].hasCrashed() == false) {
                    // Remove the dalek peg 
                    board.removePeg(dalek[i].getRow(), dalek[i].getCol());
                    // move daleks toward Doc(call for advance towards command
                    dalek[i].advanceTowards(Doc);
                    
                }
                
            }

            //place all daleks again 
            for (int i = 0; i <= 2; i++) {
                board.putPeg(Color.black, dalek[i].getRow(), dalek[i].getCol());
                
            }
            
        }
        
    }
    
}
