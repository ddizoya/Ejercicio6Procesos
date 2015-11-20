
public class Consumidor  {
	static Thread consumir;
	Monitor monitor;

	public Consumidor(Monitor monitor) {
		this.monitor = monitor;
		consumir = new Thread() {
			@Override
			public synchronized void run() {
				while(Monitor.contadorConsumos < 10){
					monitor.consumir();
				}		
			}
		};
	}
}
