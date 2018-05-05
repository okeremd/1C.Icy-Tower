package model.entity;

import javafx.scene.image.Image;

public class Character extends GameObject {

    public static final int JUMP_POWER = 30;
    public static final double ACCELERATION = 1;

    /**
     * the horizontal and vertical velocities of the character
     */
    private double verticalVelocity, horizontalVelocity;

    /**
     * Holds the jump power of the character
     */
    private int jumpPower;

    /**
     * Holds the score of the character
     */
    private int score;
    /**
     * Hold the current situation of the character
     */
	private boolean movingLeft, movingRight, standing, comboJumping;
	private static Character character;

    /**
     * Holds the current acceleration of the character
     */
	private double currentAccelleration;

	public Character(){
	    jumpPower = JUMP_POWER;
	    horizontalVelocity = 1;
	    movingLeft = false;
	    movingRight = false;
	    standing = true;
	    comboJumping = false;
	    score=0;
	    currentAccelleration = ACCELERATION;
    }

    public Character(Image[] images) {
	    super(images);
        jumpPower = JUMP_POWER;
        horizontalVelocity = 10;
        movingLeft = false;
        movingRight = false;
        comboJumping = false;
        score=0;

    }

    /**
     * According to the character's moves, returns the proper image
     * @return image
     */
    public Image getCurrentImage(){
	    if(isComboJumping()){
	        return getImages()[6];
        }
	    else if(!isStanding() && isMovingRight())
        {
            return getImages()[4];
        }
        else if(!isStanding() && isMovingLeft())
        {
            return  getImages()[5];
        }
	    else if(isMovingLeft()){
            return getImages()[2];
        }
        else if(isMovingRight()){
            return getImages()[1];
        }
        else if(isStanding()){
            return getImages()[0];
        }
        else{
	        return getImages()[3];
        }
    }

    /**
     * Singleton method
     * @return this
     */
    public static Character getInstance(){
        if(character== null)
            character = new Character();
        return character;
    }

    public boolean isComboJumping() {
        return comboJumping;
    }

    public void setComboJumping(boolean comboJumping) {
        this.comboJumping = comboJumping;
    }

    public double getVerticalVelocity() {
        return verticalVelocity;
    }

    public void setVerticalVelocity(double verticalVelocity) {
        this.verticalVelocity = verticalVelocity;
    }

    public int getJumpPower() {
        return jumpPower;
    }

    public void setJumpPower(int jumpPower) {
        this.jumpPower = jumpPower;
    }

    public void setStanding(boolean standing){
	    this.standing = standing;
    }

    public boolean isStanding(){
        return standing;
    }

    public boolean isMovingLeft() {
	    return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public double getHorizontalVelocity() {
        return horizontalVelocity;
    }

    public void setHorizontalVelocity(double horizontalVelocity) {
        this.horizontalVelocity = horizontalVelocity;
    }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public static double getACCELERATION() {
        return ACCELERATION;
    }

    public double getCurrentAccelleration() {
        return currentAccelleration;
    }

    public void setCurrentAccelleration(double currentAccelleration) {
        this.currentAccelleration = currentAccelleration;
    }

    public void accelerate(){
	    if(isMovingRight() && isMovingLeft()){
	        setHorizontalVelocity(0);
        }
	    else if(isMovingRight()){
	        setHorizontalVelocity(horizontalVelocity + currentAccelleration);
        }
        else if(isMovingLeft()){
	        setHorizontalVelocity(horizontalVelocity - currentAccelleration);
        }

    }
}