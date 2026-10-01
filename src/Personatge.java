
public class Personatge implements Combatent {

	// Atributos: 

	private String nom;
	private int vida ; 
	private int atac; 
	private int experiencia; 
	private int agilitat;
	private int forsa;
	private int fila; 
	private int columna; 
	private Tresor [] equipament;

	// Constructores: 
	public Personatge(String nom, int fila, int columna) {
		this.nom = nom;
		this.vida = (int)(Math.random() * (20 - 5 + 1)) + 5;    
		this.atac = (int)(Math.random() * (4 -  1 + 1)) + 1;     
		this.experiencia = 0;
		this.agilitat = (int)(Math.random() * (11 - 4 + 1)) + 4; 
		this.forsa = (int)(Math.random() * (11 - 4 + 1)) + 4;    
		this.fila = fila;
		this.columna = columna;
		// Array de tamaño igual a forsa
		this.equipament = new Tresor[forsa];           
	}

	//Metodos: 

	// Atacar: 
	public  void  atacar (Monstre m ) {
		int dany = this.calcularAtac(); 
		m.rebreDany(dany);

		// Si el monstre sigue viviendo el personge recibe el daño. 
		// de otra manera el monstre ataca al personatge y el personatge recibe el daño 
		if(m.estaViu()) {
			int danyMonstre = this.calcularAtac();
			rebreDany(danyMonstre);
			// y si en esta atac se mata al monstre, 
			// se le sumara al personge un valpr d'experiencia igual al parametro de valorExperiencia.
		}else {
			experiencia += m.getValorExperiencia();
		}


	}

	//Explorar:

	public void explorar() {
		System.out.println("Explorant la sala en posició [" + fila + ", " + columna + "]");
	}
	//Moure 
	public void  moure (char direccio) {
		if (direccio == 'N') {
			this.fila--;
		}else if (direccio == 'S') {
			this.fila++;
		}else if (direccio == 'E') {
			this.columna++;
		}else if (direccio == 'O') {
			this.columna--;
		}
	}
	//Implementación de la interfaz: 
	@Override
	public int calcularAtac() {
		return (int)(Math.random() * atac ) + 1;
	}
	//Afegir el Tresor: 
	public void afegirTresor(Tresor t ) {
		for (int i = 0; i < equipament.length; i++) {
			if (equipament[i] == null) {
				equipament[i] = t;
				break;
			}
		}
	}
	@Override
	public void rebreDany(int quantitat) {
		vida -= quantitat;
	}

	@Override
	public boolean estaViu() {
		return vida > 0;
	}

	//Getters necessarios:

	public int getForsa() {
		return forsa;
	}
	public int getAgilitat() {
		return agilitat;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}
	public int getExperiencia() {
		return experiencia;
	}

	public int getVida() {
		return vida;
	}
	
	// un metodo  para contar los Tresor ganandos durante el juego 
	
	public int getNombreTresors() {
		int count = 0;
			for(Tresor t: equipament) {
				if(t != null) {
					count++;
				}
			}
			return count;
	}

	// metodo que suma el valor de cada tresor:
	
	public int getTotalMonedes() {
		int total = 0;
		for(Tresor t : equipament) {
			if( t != null) {
				total += t.getValor();
			}
		}
		return total; 
	}
	//toString: 

	@Override 
	public String toString() {
		String tresor = "";
		for (int i = 0 ; i <equipament.length; i++) {
			if(equipament[i] != null ) {
				tresor = tresor + equipament[i].toString() + " ";
			}
		}
		return "Nom : " + nom +  
				", Vida : " + vida +
				", agilitat : " + agilitat + 
				", força : " + forsa + 
				", posicio : [ " + fila + ", " + columna + " ]" +
				", Equipament : [" + tresor + "]";
	}
}

