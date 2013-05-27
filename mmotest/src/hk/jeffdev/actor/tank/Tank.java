package hk.jeffdev.actor.tank;

import hk.jeffdev.actor.tank.data.TankGunPara;
import hk.jeffdev.actor.tank.data.TankPara;
import hk.jeffdev.actor.tank.data.TankTypeSetting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Tank extends Actor{
	
	private TextureRegion region;
	private TankTypeSetting setting;
	private TankPara tankPara;
	private TankGun gun;
	
	private float acceDuration;
	private boolean isAcce;
	
	private boolean isTurningLeft = false;
	private boolean isTurningRight = false;
	private boolean isWalkingForward = false;
	private boolean isWalkingBackward = false;
	
	public static float ENGINE_CONSTANT = 10000;
	
	public Tank(TankPara tankPara, TankTypeSetting setting){
		setTankPara(tankPara);
		setSetting(setting);
		Texture tabkBody = new Texture(Gdx.files.internal(setting.getBodyImage()));
		region = new TextureRegion(tabkBody, 0, 0, setting.getBodyWidth(), setting.getBodyLong());
		
		// Add Gun
		gun = new TankGun(new TankGunPara(getRotation()));
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha){
		super.draw(batch, parentAlpha);
		batch.draw(region, getTankPara().getX(), getTankPara().getY(), setting.getBodyWidth()/2, setting.getBodyLong()/2, setting.getBodyWidth(), setting.getBodyLong(), 1, 1, getTankPara().getRotation());
		if(isAcce)
			setAcceDuration(getAcceDuration() + getSetting().getTankEngineFactor());
		if(isTurningLeft)
			turnLeft(getSetting().getRotationSpeed());
		if(isTurningRight)
			turnRight(getSetting().getRotationSpeed());		
		if(isWalkingForward)
			moveForward(ENGINE_CONSTANT, getSetting().getSpeed(), getAcceDuration());
		if(isWalkingBackward)
			moveBackward(ENGINE_CONSTANT, getSetting().getSpeed(), getAcceDuration());
	}
	
	public void moveForwardStart(){
		setWalkingForward(true);
	}
	
	public void moveBackwardStart(){
		setWalkingBackward(true);
	}
	
	public void turnLeftStart(){
		setTurningLeft(true);
	}
	
	public void turnRightStart(){
		setTurningRight(true);
	}
	
	public void moveForwardEnd(){
		setWalkingForward(false);
	}
	
	public void moveBackwardEnd(){
		setWalkingBackward(false);
	}
	
	public void turnLeftEnd(){
		setTurningLeft(false);
	}
	
	public void turnRightEnd(){
		setTurningRight(false);
	}
	
	public void turnLeft(float speed){
		tankPara.setRotation(tankPara.getRotation() + speed* Gdx.graphics.getDeltaTime());
	}
	
	public void turnRight(float speed){
		tankPara.setRotation(tankPara.getRotation() - speed* Gdx.graphics.getDeltaTime());
	}
	
	
	public void moveForward(float tankEngineFactor, float speed, float accelerationTime){
		float angle = tankPara.getRotation();
		float rAngle = angle * (float)Math.PI/(float)180;
		float xSpeed = 0;
		float ySpeed = 0;
		xSpeed = (float) (speed * Math.sin(rAngle));
		ySpeed = (float) (speed * Math.cos(rAngle));
		tankPara.setX(tankPara.getX() - acceleration(tankEngineFactor, accelerationTime, xSpeed)* Gdx.graphics.getDeltaTime());
		tankPara.setY(tankPara.getY() + acceleration(tankEngineFactor, accelerationTime, ySpeed)* Gdx.graphics.getDeltaTime());
		System.out.println(acceleration(tankEngineFactor, accelerationTime, xSpeed));
	}
	
	public void moveBackward(float tankEngineFactor, float speed, float accelerationTime){
		float angle = tankPara.getRotation();
		float rAngle = angle * (float)Math.PI/(float)180;
		float xSpeed = 0;
		float ySpeed = 0;
		xSpeed = (float) (speed * Math.sin(rAngle));
		ySpeed = (float) (speed * Math.cos(rAngle));
		tankPara.setX(tankPara.getX() + acceleration(tankEngineFactor, accelerationTime, xSpeed)* Gdx.graphics.getDeltaTime());
		tankPara.setY(tankPara.getY() - acceleration(tankEngineFactor, accelerationTime, ySpeed)* Gdx.graphics.getDeltaTime());
	}
	
	private float acceleration(float factor, float time, float speed){
		float offset = (float) factor/ (float) (-speed);
		float y = (-(float)factor/((float)((float)time*speed/(float)factor - offset))) + (float)speed;
		return y;
	}
	
	public void startAcce(){
		isAcce = true;
	}
	
	public void endAcce(){
		isAcce = false;
	}

	/**
	 * @return the region
	 */
	public TextureRegion getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(TextureRegion region) {
		this.region = region;
	}

	/**
	 * @return the tankPara
	 */
	public TankPara getTankPara() {
		return tankPara;
	}


	/**
	 * @param tankPara the tankPara to set
	 */
	public void setTankPara(TankPara tankPara) {
		this.tankPara = tankPara;
	}



	/**
	 * @return the gun
	 */
	public TankGun getGun() {
		return gun;
	}


	/**
	 * @param gun the gun to set
	 */
	public void setGun(TankGun gun) {
		this.gun = gun;
	}


	/**
	 * @return the isTurningLeft
	 */
	public boolean isTurningLeft() {
		return isTurningLeft;
	}


	/**
	 * @param isTurningLeft the isTurningLeft to set
	 */
	public void setTurningLeft(boolean isTurningLeft) {
		this.isTurningLeft = isTurningLeft;
	}


	/**
	 * @return the isTurningRight
	 */
	public boolean isTurningRight() {
		return isTurningRight;
	}


	/**
	 * @param isTurningRight the isTurningRight to set
	 */
	public void setTurningRight(boolean isTurningRight) {
		this.isTurningRight = isTurningRight;
	}


	/**
	 * @return the isWalkingForward
	 */
	public boolean isWalkingForward() {
		return isWalkingForward;
	}


	/**
	 * @param isWalkingForward the isWalkingForward to set
	 */
	public void setWalkingForward(boolean isWalkingForward) {
		this.isWalkingForward = isWalkingForward;
	}


	/**
	 * @return the isWalkingBackward
	 */
	public boolean isWalkingBackward() {
		return isWalkingBackward;
	}


	/**
	 * @param isWalkingBackward the isWalkingBackward to set
	 */
	public void setWalkingBackward(boolean isWalkingBackward) {
		this.isWalkingBackward = isWalkingBackward;
	}

	/**
	 * @return the setting
	 */
	public TankTypeSetting getSetting() {
		return setting;
	}

	/**
	 * @param setting the setting to set
	 */
	public void setSetting(TankTypeSetting setting) {
		this.setting = setting;
	}

	/**
	 * @return the acceDuration
	 */
	public float getAcceDuration() {
		return acceDuration;
	}

	/**
	 * @param f the acceDuration to set
	 */
	public void setAcceDuration(float f) {
		this.acceDuration = f;
	}
	
}
