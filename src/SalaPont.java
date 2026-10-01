
public class SalaPont extends Sala{

	public SalaPont(Tresor tresor, Monstre monstre, boolean explorada) {
		super(tresor, monstre, explorada);
	}

	@Override
	public boolean intentarSortir(Personatge p) {
		int tirada = (int)(Math.random() * 12 ) + 1;
		if (tirada <= p.getAgilitat()) {
			return true;
		}else {
			// Si falla, recibe 1 punt de daño y le resta de vida i retorna false 
			p.rebreDany(1);
			return false;
		}
	}
}

