import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		JuegoRuleta juegoRuleta = new JuegoRuleta();
		Scanner teclado = new Scanner(System.in);
		
		juegoRuleta.registrarJugador();
		juegoRuleta.mostrarInstruccionJuego();
		int opcionParaJugarRuleta = teclado.nextInt();
		juegoRuleta.jugarRuleta(opcionParaJugarRuleta);

	}

}
