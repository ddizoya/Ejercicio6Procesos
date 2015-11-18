

public interface MetodosComunes {
	
	default int nuevaCantidad() {
		return (int) (Math.random() * 100);
	}

	default void saldo(int ingresos) {
		System.out.println("Saldo: " + ingresos + "€.");
	}
}
