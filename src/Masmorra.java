import java.util.Scanner;

public class Masmorra {
	
	// Aqui usamos el static porque no hace falta crear objetos le llamaran directamente
	
	private static Sala[][] sales;
	private static int filas;
	private static int columnes;
	private static Personatge persona;

	//Constructores

	public Masmorra(int filas, int columnes,Personatge persona ) {
		this.filas = filas;
		this.columnes = columnes;
		this.persona = persona;
		this.sales = new Sala[filas][columnes];
	}

	// Metodos

	public static void inicialitzarSales() {
		for (int i = 0; i < filas ; i++ ) {
			for(int j = 0; j< columnes; j++) {
				double aleatorio = Math.random();
				if(aleatorio < 0.60){
					sales [i][j] = new SalaComuna(null, null,false );
				}else if (aleatorio < 0.80) {
					sales [i][j] = new SalaPont(null, null, false);
				}else {
					sales[i][j] = new SalaTeranyina(null, null,false);
				}
			}
		}

	}

	// Imprimir la masmorra:

	public static void imprimirMasmorra() {
		for(int i = 0; i <filas; i++) {
			for(int j = 0; j < columnes; j++) {
				if (persona.getFila() == i && persona.getColumna() == j) {
					System.out.print("& ");
				}else if(sales[i][j].isExplorada()) {
					System.out.print("* ");
				}else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
	// Mostrar opcions 
	public static void mostrarOpcions() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Elige una opcion:");
		System.out.println("1. Moure");
		System.out.println("2. Explorar sala");
		System.out.println("3. Atacar monstre");

		int opcio = teclado.nextInt();

		if (opcio == 1) {
			System.out.println("Direccio (N/S/E/O): ");
			char dir = teclado.next().charAt(0);
			Sala salaActual = sales[persona.getFila()][persona.getColumna()];

			// penalizacio si hay monstre vivo 
			Monstre m = salaActual.getMonstre();
			if(m != null && m.estaViu()) {
				persona.rebreDany(m.getPenalitzacio());

			}
			// solo se mueve si intentarSortir() devuelve true
			if (salaActual.intentarSortir(persona)) {
				persona.moure(dir);
			}

		} else if (opcio == 2) {
			
			Sala salaActual	= sales[persona.getFila()][persona.getColumna()]; 
			salaActual.setExplorada(true);

			//Coger el tresor de la sala: 

			Tresor tresor = salaActual.getTresor();
			if(tresor != null) {
				persona.afegirTresor(tresor);
			}
			persona.explorar();

		} else if (opcio == 3) {
			Monstre m = sales[persona.getFila()][persona.getColumna()].getMonstre();
			if (m != null && m.estaViu()) {
				persona.atacar(m);
			} else {
				System.out.println("No hi ha monstre!");
			}
		}

	}
	
	//Comprovar Si el joc ha finalitzat 

	public static  boolean jocFinalitzat () {
		if (persona.getFila() < 0 || persona.getFila() >= filas ||
				persona.getColumna() < 0 || persona.getColumna() >= columnes) {
			return true;
		}// vida = 
		return !persona.estaViu();
	}
	// Mostrar resultats finals:

	public  static void mostrarResultats() {
		 // calcular percentatge explorat
	    int explorades = 0;
	    for (int i = 0; i < filas; i++) {
	        for (int j = 0; j < columnes; j++) {
	            if (sales[i][j].isExplorada()) {
	            	explorades++;
	            }
	        }
	    }
	    int percentatge = (explorades * 100) / (filas * columnes);

	    if (!persona.estaViu()) {
	        System.out.println("Has perdut!");
	        System.out.println("Experiència: " + persona.getExperiencia());
	        System.out.println("Percentatge explorat: " + percentatge + "%");
	    } else {
	        System.out.println("Felicitats, has sortit!");
	        System.out.println("Experiència: " + persona.getExperiencia());
	        System.out.println("Tresors: " + persona.getNombreTresors());
	        System.out.println("Monedes d'or: " + persona.getTotalMonedes());
	        System.out.println("Vida restant: " + persona.getVida());
	        System.out.println("Percentatge explorat: " + percentatge + "%");
	    }
	}

}
