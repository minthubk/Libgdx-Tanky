package hk.jeffdev.actor.tank;

import hk.jeffdev.actor.tank.data.TankGunPara;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class TankGun extends Actor{
	
	private TankGunPara para;

	public TankGun(TankGunPara tankGunPara) {
		// TODO Auto-generated constructor stub
		setPara(tankGunPara);
	}

	/**
	 * @return the para
	 */
	public TankGunPara getPara() {
		return para;
	}

	/**
	 * @param para the para to set
	 */
	public void setPara(TankGunPara para) {
		this.para = para;
	}
	
}
