
public class Monitor {

	private static boolean consumiendo = false;
	private int ingresos = 0;

	public synchronized void producir() {
		while (consumiendo == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(">> Produciendo...");
		int ingreso = nuevaCantidad();
		System.out.println("Ingreso: " + "+" + ingreso);
		ingresos += ingreso;
		saldo(ingresos);

		consumiendo = true;
		notify();
	}

	public synchronized void consumir() {
		while (consumiendo == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

		consumiendo = false;
		notify();
	}

	public int nuevaCantidad() {
		return (int) (Math.random() * 100);
	}

	public void saldo(int ingresos) {
		System.out.println("Saldo: " + ingresos + "€.");
	}

}
