
public class Consumidor  {
	Thread consumir;
	Monitor monitor;

	public Consumidor(Monitor monitor) {
		this.monitor = monitor;
		consumir = new Thread() {
			@Override
			public synchronized void run() {
				int i = 0;
				while(i < 5){
					monitor.consumir();
					i++;
				}
			
			}
		};
	}
}
