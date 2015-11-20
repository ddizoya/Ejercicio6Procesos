
public class Consumidor  {
	Thread consumir; //Hilo
	Monitor monitor; //Se lo vamos a pasar por par�metro. 

	public Consumidor(Monitor monitor) {
		this.monitor = monitor;
		consumir = new Thread() {
			@Override
			public synchronized void run() {
				while(Monitor.contadorConsumos < 10){ //Usamos contador est�tico de monitor para cada vez que se consume. 
					monitor.consumir();  
				}		
			}
		};
	}
}
