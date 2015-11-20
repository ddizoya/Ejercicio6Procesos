
public class Productor{
	static Thread productor;
	Monitor monitor;

	public Productor(Monitor monitor) {
		this.monitor = monitor;
		productor = new Thread() {
			@Override
			public synchronized void run() {
				while (Monitor.contadorIngresos < 10){
					monitor.producir();
				}		
			}
		};
	}
}
