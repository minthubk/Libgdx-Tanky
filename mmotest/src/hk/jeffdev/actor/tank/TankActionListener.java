package hk.jeffdev.actor.tank;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class TankActionListener extends InputListener {
	
	private Tank tank;
	
	public TankActionListener(Tank tank){
		this.setTank(tank);
	}
	
	@Override
	public boolean keyDown(InputEvent event, int keyCode){
		tank.startAcce();
		if(keyCode == Keys.W){
			tank.moveForwardStart();
		}
		if(keyCode == Keys.A){
			tank.turnLeftStart();
		}
		if(keyCode == Keys.S){
			tank.moveBackwardStart();
		}
		if(keyCode == Keys.D){
			tank.turnRightStart();	
		}
		return true;
	}
	
	@Override
	public boolean keyUp(InputEvent evemt, int keyCode){
		tank.endAcce();
		if(keyCode == Keys.W){
			tank.moveForwardEnd();
		}
		if(keyCode == Keys.A){
			tank.turnLeftEnd();
		}
		if(keyCode == Keys.S){
			tank.moveBackwardEnd();
		}
		if(keyCode == Keys.D){
			tank.turnRightEnd();	
		}
		return true;
	}

	/**
	 * @return the tank
	 */
	public Tank getTank() {
		return tank;
	}

	/**
	 * @param tank the tank to set
	 */
	public void setTank(Tank tank) {
		this.tank = tank;
	}
}
