/************************************************************
* Nombre: Pablo Serna Arrazola
* Asignatura: Programación concurrente y distribuida.
* Actividad Unidad 2: Semáforos + Monitores
************************************************************/
package semaforos;

public class Main {

	static unidadesDisponibles unidadesDisponibles = new unidadesDisponibles();

	public static void main(String[] args) {
		new liberar(unidadesDisponibles);
		new reservar(unidadesDisponibles);
	}

}
