
public class Monstre implements Combatent {
	
	// Atributos; 
	private String nom; 
	private int vida ; 
	private int penalitzacio ;
	private int valorExperiencia;
	
	//Constructores 
	
	public Monstre(String nom, int vida, int penalitzacio) {

		this.nom = nom;
		this.vida = vida;
		 
		if (penalitzacio >= 0 && penalitzacio <=  3) {
			this.penalitzacio = penalitzacio;
		}else {
			this.penalitzacio = 0;
		}
		this.valorExperiencia = vida * 2;
	}
	
	//getters: 
	public int getPenalitzacio () {
		return penalitzacio;
	}
	
	public int getValorExperiencia() {
	    return valorExperiencia;
	}
	
	 public int getVida() {
	        return vida;
	    }

	    public String getNom() {
	        return nom;
	    }
	    // Métodos de la interfaz: 

		@Override
		public int calcularAtac() {
			return (int)(Math.random()* vida) + 1;
		}
		@Override
		public void rebreDany(int quantitat) {
			vida -= quantitat;

		}
		@Override
		public boolean estaViu() {
			return vida > 0; 
		}
		
		// Mostrar por  consola : 
		
		@Override
		public String toString () {
			return "Nom : " + nom + ", Vida : " + vida; 
		}
		
	}


