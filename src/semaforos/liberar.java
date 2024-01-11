package semaforos;

import java.util.Random;

public class liberar extends Thread {
	
	public unidadesDisponibles unidadesDisponibles;
	
	public liberar(unidadesDisponibles unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
		start();
	}
	
	public int liberar() {
		Random rdm = new Random();
	
		int idRecurso = rdm.nextInt(1000 -1) +1;
		int timeProduction = rdm.nextInt(300 - 60) + 60;
		
		try {
			sleep(timeProduction);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return idRecurso;
		
		
	}
	
	public void run () {
		
		while(true) {
			int idRecurso = liberar();
			
			if(unidadesDisponibles.getInventario().size() == unidadesDisponibles.sizeUnidadesDisponibles)
				
			
			try {
				unidadesDisponibles.getEspacios().acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			unidadesDisponibles.getInventario().add(idRecurso);
			
			System.out.println("Libero de golpe " + idRecurso + " unidades del recurso que previamente se me había concedido.");
			
			unidadesDisponibles.getRecursos().release();
		}
	}
}
