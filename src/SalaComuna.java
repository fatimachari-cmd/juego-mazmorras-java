
public class SalaComuna extends Sala {

	
	public SalaComuna(Tresor tresor, Monstre monstre, boolean explorada) {
		super(tresor, monstre, explorada);
	}

	@Override
	public boolean intentarSortir(Personatge p) {
		
		return true ;
	}

}
