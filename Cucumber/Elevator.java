package info.cukes.cucumber_junit;

public class Elevator {
	private int floor=1;
	private boolean doorIsClosed = false;
	
	public void closeDoors() {
		if(doorIsClosed!=true) {
			doorIsClosed = true;
		}
	}
	public void openDoors() {
		if(doorIsClosed!=false) {
			doorIsClosed = false;
			
			CloseThread t = new CloseThread();
			t.start();
		}
	}
	public void changeFloor(int floor) throws Exception{
		if(!(floor < 1 || floor > 5)) {
			this.floor=floor;
		}else {
			throw new Exception("Invalid floor!");
		}
	}
	public int checkFloor() {
		return floor;
	}
	public boolean isClosed(){
		return doorIsClosed == true;
	}
	public boolean isOpen(){
		return doorIsClosed == false;
	}
	class CloseThread extends Thread{
		public void run() {
			try {
				Thread.sleep(9000);
			} catch(InterruptedException e) {
			}
			closeDoors();
		}
	}
}
