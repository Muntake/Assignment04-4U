/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * create dalek class
 *
 * @author munta
 */
public class Dalek {

    private int row;

    private int col;

    private boolean dCrash = false;//boolean for conditon of dalek

    /**
     * class for daleks row and col(constructor
     *
     * @param row row that is randomized
     * @param col the col that is randomized
     */
    public Dalek(int row, int col) {
        this.row = row;
        this.col = col;

    }

    /**
     * advanced to doctor method, doc
     *
     * @param doc the doctor that daleks are advancing toward
     */
    public void advanceTowards(Doctor doc) {
        //if dalek has not crashed (move daleks)

        int docRow = doc.getRow();
        int docCol = doc.getCol();
        //if dalkes row is more than doctors row, remove one from daleks row 
        if (this.row > docRow) {
            this.row -= 1;

            //if daleks row  is less  than doctors col,add one to daleks row
        } else if (this.row < docRow) {
            this.row += 1;
        }

        //if dalkes col is more than doctors col, remove one from daleks col
        if (this.col > docCol) {
            this.col -= 1;
            //if daleks col row is less than doctors col,add one to daleks col
        } else if (this.col < docCol) {
            this.col += 1;

        }

    }

    /**
     * return the current row of dalek
     *
     * @return the current row of dalek
     */
    public int getRow() {
        return this.row;

    }

    /**
     * return the current row of dalek
     *
     * @return the current row of dalek
     */
    public int getCol() {
        return this.col;
    }

    /**
     * check if dalek has crashed
     *
     * @return ture of false (if dalek is crashed or not
     */
    public boolean hasCrashed() {
        return this.dCrash;

    }

    /**
     * check to see if daleks have collided(method)
     *
     */
    public void crash() {
        this.dCrash = true;

    }
}
