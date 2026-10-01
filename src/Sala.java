

public abstract class Sala  {

	// Atributos: 
	
	private Tresor tresor;
	private Monstre monstre; 
	private boolean explorada;
	
	//Constructores 
	
	public Sala(Tresor tresor, Monstre monstre, boolean explorada) {
		
		this.tresor = tresor; 
		this.monstre = monstre;
		this.explorada = explorada;
	}
	
	// Metodos: 
	
	public abstract boolean intentarSortir(Personatge p);
	
	public boolean isExplorada() {
		return explorada;
	}
	
	public void setExplorada(boolean explorada) {
		this.explorada = explorada;
	}
	
	public Tresor getTresor() {
	    return tresor;
	}
	public Monstre getMonstre() {
	    return monstre;
	}
	
}
