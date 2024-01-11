/************************************************************
* Nombre: Pablo Serna Arrazola
* Asignatura: Programación concurrente y distribuida.
* Actividad Unidad 2: Semáforos + Monitores
************************************************************/
package semaforos;

import java.util.Random;

public class reservar extends Thread {
	
	private unidadesDisponibles unidadesDisponibles;
	
	public reservar(unidadesDisponibles unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
		start();
	}
	
	public int reservar() {
		Random rdm = new Random();
		int timeSleep = rdm.nextInt(240 - 60) + 60;
		
		try {
			sleep(timeSleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return unidadesDisponibles.getInventario().poll();
	}
	
	public void run() {
		while(true) {
			
			if(unidadesDisponibles.getInventario().size() == 0) {
				
			}
			try {
				unidadesDisponibles.getRecursos().acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int idRecurso = reservar();
			
			System.out.println("Necesito se me concedan, de golpe " + idRecurso + " unidades del recurso ");
			unidadesDisponibles.getEspacios().release();
		}
	}

}
