
public class ClasePrincipal {
	public static void main(String[] args) {
		Monitor m = new Monitor();
		 new Productor(m).productor.start();
		 new Consumidor(m).consumir.start();
		

	}
}
