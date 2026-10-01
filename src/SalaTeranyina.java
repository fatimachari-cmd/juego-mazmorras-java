
public class SalaTeranyina extends Sala {

	public SalaTeranyina(Tresor tresor, Monstre monstre, boolean explorada) {
		super(tresor, monstre, explorada);
	}
	
	@Override 
	public boolean intentarSortir(Personatge p ) {
		int tirada = (int)(Math.random() * 12 ) + 1;
		if (tirada <= p.getForsa()) {
			return true;
		}else {
			return false;
		}

	}
}
