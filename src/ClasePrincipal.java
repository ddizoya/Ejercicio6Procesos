
public class ClasePrincipal {
	public static void main(String[] args) {
		Monitor objetoMonitor = new Monitor(); //Objeto monitor, que se le pasará a ambos, consumidor y productor, por parámetro para llevar el control. 
		 new Productor(objetoMonitor).productor.start();
		 new Consumidor(objetoMonitor).consumir.start();
	}
}
