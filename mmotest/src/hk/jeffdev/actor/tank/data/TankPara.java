package hk.jeffdev.actor.tank.data;

public class TankPara {
	
	public TankPara(float x, float y, float rotation){
		setX(x);
		setY(y);
		setRotation(rotation);
	}
	
	private float x;
	private float y;
	private float rotation;
	
	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
	/**
	 * @return the rotation
	 */
	public float getRotation() {
		return rotation;
	}
	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
}
