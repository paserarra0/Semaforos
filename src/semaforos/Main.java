package semaforos;

public class Main {

	static unidadesDisponibles unidadesDisponibles = new unidadesDisponibles();

	public static void main(String[] args) {
		new liberar(unidadesDisponibles);
		new reservar(unidadesDisponibles);
	}

}
