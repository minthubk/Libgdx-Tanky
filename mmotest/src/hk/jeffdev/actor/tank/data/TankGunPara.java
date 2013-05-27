package hk.jeffdev.actor.tank.data;

public class TankGunPara {
	
	private float rotation;
	
	public TankGunPara(float rotation){
		setRotation(rotation);
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
