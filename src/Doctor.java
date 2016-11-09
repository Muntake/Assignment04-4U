/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author munta
 */
public class Doctor {

    private int row;
    private int col;
    private boolean crash = false;//boolean for doctors state;

    /**
     * constructor to create doctor
     *
     * @param row the row that is being passed through by user
     * @param col the col that is being passed through the user
     */
    public Doctor(int row, int col) {
        this.row = row;
        this.col = col;

    }

    /**
     * method that moves the doctor based on the click passed through
     *
     * @param newRow the row that is passed through (click)
     * @param newCol the col that is passed through (click)
     */
    public void move(int newRow, int newCol) {
        //if the click cordinates that are passed through are 1 sapce away from doctors current postion move doctor to that space
        if (this.row - newRow <= 1
                && this.row - newRow >= -1
                && this.col - newCol <= 1
                && this.col - newCol >= -1) {
            //set new spot for doctor 
            this.row = newRow;
            this.col = newCol;

            //else spawn doctor at random location 
        } else {
            this.row = (int) (Math.random() * 12);
            this.col = (int) (Math.random() * 12);
        }

    }

    /**
     * returns current row of doc
     *
     * @return the current row of doc
     */
    public int getRow() {
        return this.row;

    }

    /**
     * return the current col of doc
     *
     * @return the current col of doc
     */
    public int getCol() {
        return this.col;

    }
}
