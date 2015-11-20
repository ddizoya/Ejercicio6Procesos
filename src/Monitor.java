
public class Monitor {

	private static boolean consumiendo = false;
	private int ingresos = 0;
	static int contadorIngresos = 0;
	static int contadorConsumos = 0;

	public synchronized void producir() {
		while (consumiendo == true) { //Si no estamos consumiento, producimos. 
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Producimos. 
		System.out.println(">> Produciendo...");
		int ingreso = nuevaCantidad();
		System.out.println("Ingreso: " + "+" + ingreso);
		ingresos += ingreso;
		saldo(ingresos);

		consumiendo = true; //Le decimos que ya hemos acabado de producir y se dispone a consumir. 
		notify(); //Le decimos al hilo que ejecute este método que se despierte. 
		contadorIngresos++; //Incrementamos un ingreso. 
	}

	public synchronized void consumir() {
		while (consumiendo == false) { // Si no estamos produciendo, consumimos.  
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (contadorIngresos >= 5) { //Cuando pase de 5 consumos, no volveremos a consumir. 
			consumiendo = false;     //Simplemente daremos vía libre para que el método producir pueda seguir ejecutándose
			notify();				// 10 veces, mientras que consumir lo hará sólo 5.
			contadorConsumos++;
			return;
		}
		System.out.println(">> Consumiendo...");
		int extraccion = nuevaCantidad();
		if (ingresos - extraccion > 0) {
			System.out.println("Extracción: " + "-" + extraccion);
			ingresos -= extraccion;
			saldo(ingresos);
		} else {
			System.out.println("Saldo insuficiente. Pretendes sacar " + extraccion + "€.");
		}
		consumiendo = false; // Le decimos que ya hemos acabado de consumir. 
		notify();
		contadorConsumos++; // Se incrementa un consumo. 
	}

	public int nuevaCantidad() { //Genera una cantidad aleatoria de dinero para ingresar/extraer. 
		return (int) (Math.random() * 100);
	}

	public void saldo(int ingresos) { //Método de impresión del atributo. 
		System.out.println("Saldo: " + ingresos + "€.");
	}

}
