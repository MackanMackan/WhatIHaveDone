package bankomat;

public class Bankomat {
	private static int myBalance = 500;
	private static int bankBalance = 5000;
	private static boolean loggedIn = false;

	public Bankomat() {
		loggedIn = false;
	}

	public boolean bankWithdrawl(int amount) {
			if (!loggedIn || amount > myBalance || amount > bankBalance) {
				System.err.println("Insufficient Balance");
				return false;
			}
			myBalance -= amount;
			return true;
	}

	public int showMyBalance() {
		return myBalance;
	}

	public void logIn(int pin) {
		if (pin == 1234) {
			loggedIn = true;
		}
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
}
