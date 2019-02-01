package helpers;

public class Helpers {
	public void sleepSeconds(int seconds) {//HACE UNA PAUSA
			try {
				Thread.sleep(seconds*1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
