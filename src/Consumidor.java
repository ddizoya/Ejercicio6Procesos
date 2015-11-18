
public class Consumidor implements MetodosComunes {
	Thread consumir;
	Monitor monitor;

	public Consumidor(Monitor monitor) {
		this.monitor = monitor;
		consumir = new Thread() {
			@Override
			public synchronized void run() {
				int i = 0;
				while (i < 5) {
					try {
						sleep(1000);
						System.out.println(">> Consumiendo...");
						int extraccion = nuevaCantidad();
						if (Monitor.ingresos - extraccion > 0) {
							System.out.println("Extracción: " + "-" + extraccion);
							Monitor.ingresos -= extraccion;
							saldo(Monitor.ingresos);
							i++;
							monitor.seguirConsumiendo();
						} else {
							System.out.println("Saldo insuficiente. Pretendes sacar " + extraccion + "€.");
							i++;
							monitor.seguirConsumiendo();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		};
	}

	@Override
	public int nuevaCantidad() {
		return MetodosComunes.super.nuevaCantidad();
	}

	@Override
	public void saldo(int ingresos) {
		MetodosComunes.super.saldo(ingresos);
	}

}
