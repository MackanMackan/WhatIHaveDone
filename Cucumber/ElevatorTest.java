package info.cukes.cucumber_junit;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ElevatorTest {
	Elevator elevator = new Elevator();

	public class InvalidStateException extends Exception {
	}

	// Given and Then method
	@Given("^Elevator should be (.*)$")
	public void elevator_check_open_or_closed(String doorState) throws Exception {
		if (doorState.equalsIgnoreCase("open")) {
			if (!elevator.isOpen()) {
				throw new InvalidStateException();
			}
		} else {
			if (!elevator.isClosed()) {
				throw new InvalidStateException();
			}
		}
	}

	// Given and Then method
	@Given("^Elevator is open$")
	public void elevator_is_open() throws Exception {
		if (!elevator.isOpen()) {
			elevator.openDoors();
		}
	}

	@Given("^Elevator is closed$")
	public void elevator_is_closed() throws Exception {
		if (!elevator.isClosed()) {
			elevator.closeDoors();
		}
	}

	@Given("^Elevator is on floor (\\d+)$")
	public void elevator_check_floor(int floor) throws Exception {
		if (floor != elevator.checkFloor()) {
			throw new InvalidStateException();
		}
		elevator.openDoors();

	}

	@When("^I push a floor button$")
	public void set_elevator_to_close() throws Throwable {
		elevator.closeDoors();
	}

	@When("^Arrive at my floor$")
	public void set_elevator_to_open() throws Throwable {
		elevator.openDoors();
	}

	@When("^Floorbutton (\\d+) is pressed$")
	public void floorbutton_is_pressed(int arg1) throws Throwable {
		elevator.changeFloor(arg1);
	}

}
