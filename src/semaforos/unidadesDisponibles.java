package semaforos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class unidadesDisponibles {
	public final int sizeUnidadesDisponibles = 20;
	
	private Queue<Integer> inventario = new LinkedList<Integer>();
	private Semaphore espacios = new Semaphore(20, true);
	private Semaphore recursos = new Semaphore(0, true);
	
	
	public Semaphore getEspacios() {
		return espacios;
	}
	
	public Semaphore getRecursos() {
		return recursos;
	}
	
	public Queue<Integer> getInventario() {
		return inventario;
	}
	
}
