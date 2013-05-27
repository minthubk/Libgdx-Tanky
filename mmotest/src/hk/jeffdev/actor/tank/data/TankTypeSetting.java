package hk.jeffdev.actor.tank.data;

public class TankTypeSetting {
	
	public TankTypeSetting(float speed, float rotationSpeed, float tankEngineFactor, String bodyImage, int bodyLong, int bodyWidth){
		setSpeed(speed);
		setRotationSpeed(rotationSpeed);
		setBodyImage(bodyImage);
		setBodyLong(bodyLong);
		setBodyWidth(bodyWidth);
		setTankEngineFactor(tankEngineFactor);
	}
	
	private float speed;
	private float rotationSpeed;
	private String bodyImage;
	private int bodyLong;
	private int bodyWidth;
	private float tankEngineFactor;

	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @return the rotationSpeed
	 */
	public float getRotationSpeed() {
		return rotationSpeed;
	}

	/**
	 * @param rotationSpeed the rotationSpeed to set
	 */
	public void setRotationSpeed(float rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}

	/**
	 * @return the bodyImage
	 */
	public String getBodyImage() {
		return bodyImage;
	}

	/**
	 * @param bodyImage the bodyImage to set
	 */
	public void setBodyImage(String bodyImage) {
		this.bodyImage = bodyImage;
	}

	/**
	 * @return the bodyLong
	 */
	public int getBodyLong() {
		return bodyLong;
	}

	/**
	 * @param bodyLong the bodyLong to set
	 */
	public void setBodyLong(int bodyLong) {
		this.bodyLong = bodyLong;
	}

	/**
	 * @return the bodyWidth
	 */
	public int getBodyWidth() {
		return bodyWidth;
	}

	/**
	 * @param bodyWidth the bodyWidth to set
	 */
	public void setBodyWidth(int bodyWidth) {
		this.bodyWidth = bodyWidth;
	}

	/**
	 * @return the tankEngineFactor
	 */
	public float getTankEngineFactor() {
		return tankEngineFactor;
	}

	/**
	 * @param tankEngineFactor the tankEngineFactor to set
	 */
	public void setTankEngineFactor(float tankEngineFactor) {
		this.tankEngineFactor = tankEngineFactor;
	}
	
}
