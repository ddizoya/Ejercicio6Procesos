
public class Productor{
	Thread productor;
	Monitor monitor;

	public Productor(Monitor monitor) {
		this.monitor = monitor;
		productor = new Thread() {
			@Override
			public synchronized void run() {
				int i = 0;
				while (i < 10){
					monitor.producir();
					i++;
				}
				
			}
		};
	}
}
