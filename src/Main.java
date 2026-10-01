
public class Main {

	public static void main(String[] args) {
		//  Crear el personatge (nombre, fila inicial, columna inicial)
		Personatge jugador = new Personatge("Heroi", 3, 2);

		//  Inicializar la masmorra (5 filas, 5 columnas)
		Masmorra ma = new Masmorra(5,5, jugador);

		// Llenar las salas
		Masmorra.inicialitzarSales();

		//  Bucle del juego

		while (!Masmorra.jocFinalitzat()) {
			Masmorra.imprimirMasmorra();
			Masmorra.mostrarOpcions();
		}

		// Mostrar resultados
		Masmorra.mostrarResultats();
	}


}
