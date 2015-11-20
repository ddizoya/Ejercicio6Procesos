
public class Productor{
	Thread productor; //Hilo
	Monitor monitor; //Se lo pasaremos por par�metro.

	public Productor(Monitor monitor) {
		this.monitor = monitor;
		productor = new Thread() {
			@Override
			public synchronized void run() {
				while (Monitor.contadorIngresos < 10){ //Contador est�tico de monitor para cada ingreso. 
					monitor.producir();
				}		
			}
		};
	}
}
