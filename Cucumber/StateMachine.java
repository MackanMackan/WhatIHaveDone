package info.cukes.cucumber_junit;

public class StateMachine {
	private enum State {
		ON, OFF
	}

	private State state;

	public StateMachine() {
		this.state = State.OFF;
	}

	public boolean isOff() {
		return state == State.OFF;
	}

	public boolean isOn() {
		return state == State.ON;
	}

	public void turnOn() {
		if (state != State.ON)
			state = State.ON;
	}

	public void turnOff() {
		if (state != State.OFF)
			state = State.OFF;
	}
}
