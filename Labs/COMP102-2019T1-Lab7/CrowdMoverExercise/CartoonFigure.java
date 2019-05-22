// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Exercise for COMP102 - 2019T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;

/**
 * A CartoonFigure object is a cartoon character, displayed on the screen
 * that can 
 *   move around,
 *   change the direction the character is facing,
 *   change its emotion (smiling or frowning)
 *   speak or "think" a phrase
 * NOTE:
 *   This is very similar to CartoonCharacter, except:
 *    - it does not redraw itself when it changes.
 *    - it has an  isOn(..) method
 *    - it does not have speak and think methods
 *    - when created, it is randomly left or right, smile or frown
 */

public class CartoonFigure {

    /* Fields representing the state of a CartoonFigure */
    private String imagePrefix;
    private double characterX = -100;   // top left corner of character
    private double characterY = -100;
    private String direction;
    private String emotion;

    /* Fields containing dimensions of CartoonFigures */

    private int characterHeight = 100;
    private int characterWidth = 70;

    private int wordsWidth = 150;
    private int wordsHeight = 35;

    /** Constructor requires the coordinates (left, top) of where it should be placed,
     *    and the prefix of the image file names
     *  For example
     *    new CartoonFigure(100, 50, "casey");
     */
    public CartoonFigure(double x, double y, String name ){
        this.characterX = x;
        this.characterY = y;
        this.imagePrefix=name;
        if (Math.random()>0.5) {this.direction = "left";} else {this.direction = "right";}
        if (Math.random()>0.5) {this.emotion = "smile";} else {this.emotion = "frown";}
    }

    /**
     * Returns true if the point (x, y) is on top of the character.
     * Returns false otherwise
     */
    public boolean isOn(double x, double y){
        return (x>this.characterX && x< this.characterX+this.characterWidth &&
            y>this.characterY && y<this.characterY+this.characterHeight);        
    }

    /**
     * Makes the CartoonFigure turn to the left
     */
    public void lookLeft() {
        this.direction = "left";
    }

    /**
     * Makes the CartoonFigure turn to the right
     */
    public void lookRight() {
        this.direction = "right";
    }

    /**
     * Makes the CartoonFigure smile
     */
    public void smile() {
        this.emotion = "smile";
    }

    /**
     * Makes the CartoonFigure frown
     */
    public void frown() {
        this.emotion = "frown";
    }

    /**
     * Makes the CartoonFigure walk in the direction it is facing
     */
    public void walk(double dist) {
        if (this.direction.equals("right")){
            this.characterX = this.characterX + dist;
        }
        else{
            this.characterX = this.characterX - dist;
        }
    }

    /**
     * Draw the CartoonFigure
     */

    public void draw(){
        String fname = null;
        fname = this.imagePrefix + "-" + this.direction + "-" + this.emotion + ".png"; 
        UI.drawImage(fname, this.characterX, this.characterY, this.characterWidth, this.characterHeight);
    }

}

