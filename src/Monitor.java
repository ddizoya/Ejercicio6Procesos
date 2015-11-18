
public class Monitor {
	
	private static boolean verde = false;
	public static int ingresos  = 0;
	
	public synchronized void seguirProduciendo(){
		while (verde == true){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		verde = true;
		notify();
	}
	
	public synchronized void seguirConsumiendo(){
		while(verde == false){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		verde = false;
		notify();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
