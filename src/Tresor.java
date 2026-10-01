
public class Tresor {
	// Atributos: 

	private  String nom;
	private int valor; 
	private double pes;
	// Constructores 
	public Tresor(String nom, int valor, double pes) {
		this.nom = nom;
		this.valor = valor;
		this.pes = pes;
	}
	
	// getter: 
	public int getValor() {
		return valor;
	}
	// Mostrar en la consola
	@Override
	public String toString() {
		return "nom: " + nom + ", valor=" + valor + " monedes d'or" ;
	}

}
