public class Character extends GameObject {

	private int velocity;
	private int jumpPower;
	private int IMAGE_NO;

	public int getVelocity() {
		return this.velocity;
	}

	/**
	 * 
	 * @param velocity
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getJumpPower() {
		return this.jumpPower;
	}

	/**
	 * 
	 * @param jumpPower
	 */
	public void setJumpPower(int jumpPower) {
		this.jumpPower = jumpPower;
	}

}