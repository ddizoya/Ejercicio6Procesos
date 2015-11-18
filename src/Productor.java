
public class Productor implements MetodosComunes {
	Thread productor;
	Monitor monitor;

	public Productor(Monitor monitor) {
		this.monitor = monitor;
		productor = new Thread() {
			@Override
			public synchronized void run() {
				int i = 0;
				while (i < 10) {
					try {
						sleep(1000);
						System.out.println(">> Produciendo...");
						int ingreso = nuevaCantidad();
						System.out.println("Ingreso: " + "+" + ingreso);
						Monitor.ingresos += ingreso;
						saldo(Monitor.ingresos);
						i++;
						monitor.seguirProduciendo();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (i == 10)
						System.out.println("Fin de la ejecución.");
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
