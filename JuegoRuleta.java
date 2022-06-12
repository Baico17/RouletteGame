import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class JuegoRuleta extends Persona{
	int numeroPartidasJugadas;
	int numeroPartidasGanadas;
	int numeroPartidasPerdidas;
	int numeroFull;
	
	float dineroDepositado;
	float dineroApostado;
	float porcentajeVictoriasJugador;
		
	String color;
	String parImpar;
	String colorFull;
	
	public JuegoRuleta() {
		super();
	}
	
	public void setDineroDepositado(float _dineroDepositado) {
		dineroDepositado = _dineroDepositado;
	}
	
	public float getDineroDepositado() {
		return dineroDepositado;
	}
	
	public void setDineroApostado(float _dineroApostado) {
		dineroApostado = _dineroApostado;
	}
	
	public float getDineroApostado() {
		return dineroApostado;
	}
	
	public void setColor(String _color) {
		color = _color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setParImpar(String _parImpar) {
		parImpar = _parImpar;
	}
	
	public String getParImpar() {
		return parImpar;
	}
	
	public void setColorFull(String _colorFull) {
		colorFull = _colorFull;
	}
	
	public String getColorFull() {
		return colorFull;
	}
	
	public void setNumeroFull(int _numeroFull) {
		numeroFull = _numeroFull;
	}
	
	public int getNumeroFull() {
		return numeroFull;
	}
	
	public void setNumeroPartidasJugadas(int _numeroPartidasJugadas) {
		numeroPartidasJugadas = _numeroPartidasJugadas;
	}
	
	public void setNumeroPartidasGanadas(int _numeroPartidasGanadas) {
		numeroPartidasGanadas = _numeroPartidasGanadas;
	}
	
	public void setNumeroPartidasPerdidas(int _numeroPartidasPerdidas) {
		numeroPartidasPerdidas = _numeroPartidasPerdidas;
	}
	
	public int getNumeroPartidasJugadas() {
		return numeroPartidasJugadas;
	}
	
	public int getNumeroPartidasGanadas() {
		return numeroPartidasGanadas;
	}
	
	public int getNumeroPartidasPerdidas() {
		return numeroPartidasPerdidas;
	}
	
	public void setPorcentajeVictoriasJugador(float _porcentajeVictoriasJugador) {
		porcentajeVictoriasJugador = _porcentajeVictoriasJugador;
	}
	
	public float getPorcentajeVictoriasJugador() {
		return porcentajeVictoriasJugador;
	}
	
	public void registrarJugador() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el Nombre");
		String nombreJugador = teclado.next();
		
		System.out.println("Introduzca el Apellido");
		String apellidoJugador = teclado.next();
		
		System.out.println("Introduzca la edad");
		int edadJugador = teclado.nextInt();
		
		setNombre(nombreJugador);
		setApellido(apellidoJugador);
		setEdad(edadJugador);
	}
	
	public void jugarRuleta(int opcion) {
		
		int numeroPartidas = 0;
		setNumeroPartidasJugadas(numeroPartidas);
		
		int numeroPartidasGanadas = 0;
		setNumeroPartidasGanadas(numeroPartidasGanadas);
		
		int numeroPartidasPerdidas = 0;
		setNumeroPartidasPerdidas(numeroPartidasPerdidas);
		
		float porcentajeVictoriasJugador =0.0f;
		setPorcentajeVictoriasJugador(porcentajeVictoriasJugador);
		
		boolean continuar = true;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Deposite la cantidad de dinero que desee para jugar");
		dineroDepositado = teclado.nextFloat();
		setDineroDepositado(dineroDepositado);
		
		System.out.println("Apueste la cantidad de dinero que desee para jugar");
		dineroApostado = teclado.nextFloat();
		setDineroApostado(dineroApostado);
		
		while(continuar) {  // Con false no funciona no se porque
		
	   if(dineroDepositado > 0) {
		switch(opcion) {
		case 1:
			String opcionColor;
			System.out.println("Introduzca el color Negro o Rojo como opcion");
			opcionColor = teclado.next();
			setColor(opcionColor);
			elegirJugarConOpcionColor(getColor());
			mostrarInstruccionJuego();
			opcion = teclado.nextInt();
			break;
			
		case 2:
			System.out.println("Introduzca Par o Impar como opcion");
			String opcionParImpar = teclado.next();
			setParImpar(opcionParImpar);
			elegirJugarConOpcionParImpar(getParImpar());
			mostrarInstruccionJuego();
			opcion = teclado.nextInt();
			break;
			
		case 3:
			System.out.println("Introduzca el numero que va a salir");
			int numeroFull = teclado.nextInt();
			setNumeroFull(numeroFull);
			elegirJugarConOpcionFull(getNumeroFull());
			mostrarInstruccionJuego();
			opcion = teclado.nextInt();
			break;
			
		case 4:
			System.out.println("Usted acaba de salir del juego."); 
			mostrarRegistroJugador();
			guardarDatosJugadorEnFichero();
			continuar = false;
			break;
			
		case 5:
			System.out.println("Ha elegido ingresar dinero");
			anyadirDinero();
			mostrarInstruccionJuego();
			opcion = teclado.nextInt();
			break;
			
		default:
			System.out.println("Opcion no valida pruebe otra vez");
			opcion = teclado.nextInt();
				break;
		            }
		
		}
			else {
				System.out.println("Usted ha perdido  todo el dinero ya no puedo seguir jugando."); 
				continuar = false;
			}
		}
	}
	
	public void elegirJugarConOpcionColor(String color) {
		int numeroColor;
		int numeroColorRandom = ThreadLocalRandom.current().nextInt(0,2);
		int numeroPartidasJugadas = getNumeroPartidasJugadas();
		int numeroPartidasGanadas = getNumeroPartidasGanadas();
		int numeroPartidasPerdidas = getNumeroPartidasPerdidas();
		
		String colorNegro = "negro";
		String colorRojo = "rojo";
		
		if(color.equals(colorNegro)) {
			numeroColor = 1;
			if(numeroColor == numeroColorRandom) {
				dineroDepositado = dineroDepositado + dineroApostado;
				mostrarGanarPartida();
				mostrarDineroActual(dineroDepositado);
				numeroPartidasGanadas++;
				setNumeroPartidasGanadas(numeroPartidasGanadas);
				mostrarNumeroPartidasGanadas();
				
			}
		
		else {
			dineroDepositado = dineroDepositado - dineroApostado;
			mostrarPerderPartida();
			mostrarDineroActual(dineroDepositado);
			numeroPartidasPerdidas++;
			setNumeroPartidasPerdidas(numeroPartidasPerdidas);
			mostrarNumeroPartidasPerdidas();
			
		   }
		}
		
		if(color.equals(colorRojo)) {
			numeroColor = 1;
			if(numeroColor == numeroColorRandom) {
				dineroDepositado = dineroDepositado + dineroApostado;
				mostrarGanarPartida();
				mostrarDineroActual(dineroDepositado);
				numeroPartidasGanadas++;
				setNumeroPartidasGanadas(numeroPartidasGanadas);
				mostrarNumeroPartidasGanadas();
				
			}
		
		else {
			dineroDepositado = dineroDepositado - dineroApostado;
			mostrarPerderPartida();
			mostrarDineroActual(dineroDepositado);
			numeroPartidasPerdidas++;
			setNumeroPartidasPerdidas(numeroPartidasPerdidas);
			mostrarNumeroPartidasPerdidas();
		
		   }
		}
		
		if(color.equals(colorRojo) || color.equals(colorNegro)) {
		numeroPartidasJugadas++;
		setNumeroPartidasJugadas(numeroPartidasJugadas);
		mostrarNumeroPartidasJugadas();
		calcularPorcentajeVictoriasJugador();
		mostrarPorcentajeVictoriasJugador();
		}
		else {
			System.out.println("Opcion no valida");
		}
	}
	
	public void elegirJugarConOpcionParImpar(String parImpar) {
		int numeroPartidasJugadas = getNumeroPartidasJugadas();
		int numeroPartidasGanadas = getNumeroPartidasGanadas();
		int numeroPartidasPerdidas = getNumeroPartidasPerdidas();
		
		String par = "par";
		String impar = "impar";
		
		int numeroRandom = ThreadLocalRandom.current().nextInt(0,36);
		
		if(parImpar.equals(par)) {
		if(numeroRandom % 2 == 0) {
			dineroDepositado = dineroDepositado + dineroApostado;
			mostrarGanarPartida();
			mostrarDineroActual(dineroDepositado);
			numeroPartidasGanadas++;
			setNumeroPartidasGanadas(numeroPartidasGanadas);
			mostrarNumeroPartidasGanadas();
			
		}
		else {
			dineroDepositado = dineroDepositado - dineroApostado;
			mostrarPerderPartida();
			mostrarDineroActual(dineroDepositado);
			numeroPartidasPerdidas++;
			setNumeroPartidasPerdidas(numeroPartidasPerdidas);
			mostrarNumeroPartidasPerdidas();
			
		 }
		}
		
		if(parImpar.equals(impar)) {
			if(numeroRandom % 2 != 0) {
				dineroDepositado = dineroDepositado + dineroApostado;
				mostrarGanarPartida();
				mostrarDineroActual(dineroDepositado);
				numeroPartidasGanadas++;
				setNumeroPartidasGanadas(numeroPartidasGanadas);
				mostrarNumeroPartidasGanadas();
				
			}
			else {
				dineroDepositado = dineroDepositado - dineroApostado;
				mostrarPerderPartida();
				mostrarDineroActual(dineroDepositado);
				numeroPartidasPerdidas++;
				setNumeroPartidasPerdidas(numeroPartidasPerdidas);
				mostrarNumeroPartidasPerdidas();
				
			 }
		}
		
		if(parImpar.equals(impar) || parImpar.equals(par)) {
		numeroPartidasJugadas++;
		setNumeroPartidasJugadas(numeroPartidasJugadas);
		mostrarNumeroPartidasJugadas();
		calcularPorcentajeVictoriasJugador();
		mostrarPorcentajeVictoriasJugador();
		}
		else {
		System.out.println("Opcion no valida");
		}
	}
	
	public void elegirJugarConOpcionFull(int numeroFull) {
		int numeroPartidasJugadas = getNumeroPartidasJugadas();
		int numeroPartidasGanadas = getNumeroPartidasGanadas();
		int numeroPartidasPerdidas = getNumeroPartidasPerdidas();
		int numeroRandomOpcionFull = ThreadLocalRandom.current().nextInt(0,36);
		
		if(numeroFull <= 36 && numeroFull >= 0) {
		
		
		if(numeroFull == numeroRandomOpcionFull) {
			dineroDepositado = dineroDepositado + dineroApostado;
			mostrarGanarPartida();
			mostrarDineroActual(dineroDepositado);
			numeroPartidasGanadas++;
			setNumeroPartidasGanadas(numeroPartidasGanadas);
			mostrarNumeroPartidasGanadas();
			
		}
		else {
			dineroDepositado = dineroDepositado - dineroApostado;
			mostrarPerderPartida();
			mostrarDineroActual(dineroDepositado);
			numeroPartidasPerdidas++;
			setNumeroPartidasPerdidas(numeroPartidasPerdidas);
			mostrarNumeroPartidasPerdidas();
			
			
		}
		
		numeroPartidasJugadas++;
		setNumeroPartidasJugadas(numeroPartidasJugadas);
		mostrarNumeroPartidasJugadas();
		calcularPorcentajeVictoriasJugador();
		mostrarPorcentajeVictoriasJugador();
		}
		
		else {
			System.out.println("Opcion invalida el numero no debe ser inferior a 0 y tampoco superior a 36");
		}
	}
	
	public void anyadirDinero() {
		Scanner teclado = new Scanner(System.in);
		float anyadirDinero;
		
		System.out.println(" Ingresar dinero");
		anyadirDinero = teclado.nextFloat();
		dineroDepositado = dineroDepositado + anyadirDinero;
		setDineroDepositado(dineroDepositado);
		
		System.out.println("Apostar dinero");
		dineroApostado = teclado.nextFloat();
		setDineroApostado(dineroApostado);
	}
	
    public void mostrarNumeroPartidasJugadas() {
		System.out.println("Numero de partidas jugadas -> " + getNumeroPartidasJugadas());
	}

	public void mostrarGanarPartida() {
		System.out.println("Ha ganado la partida");
	}
	
	
	
	public void mostrarNumeroPartidasGanadas() {
		System.out.println("Numero de partidas ganadas ->" + getNumeroPartidasGanadas());
	}
	
	public void mostrarPerderPartida() {
		System.out.println("Ha perdido la partida");
	}
	
	public void mostrarNumeroPartidasPerdidas() {
		System.out.println("Numero de partidas perdidas ->" + getNumeroPartidasPerdidas());
	}
	
	
	public void mostrarDineroActual(float dinero) {
		System.out.println("El dinero actual es->" + dinero);
	}
	
	public void mostrarInstruccionJuego() {
		System.out.println("Pulse 1 para apostar con colores Pulse 2 para apostar con par/impar Pulse 3 para apostar full 4 Salir "
				+ "Pulse 5 para ingresar y apostar una nueva cantidad de dinero");
	}
	
	public void calcularPorcentajeVictoriasJugador() {
		float porcentajeVictoriasJugador;
		porcentajeVictoriasJugador = ((float)numeroPartidasGanadas / (float)numeroPartidasJugadas) * 100 ;
		System.out.println("Estos son el porcentaje de victorias ->" + porcentajeVictoriasJugador + "%");
		setPorcentajeVictoriasJugador(porcentajeVictoriasJugador);
	}
	
	public void mostrarPorcentajeVictoriasJugador() {
		System.out.println("Estos son el porcentaje de victorias ->" + getPorcentajeVictoriasJugador() + "%");
	}
	
	public void mostrarRegistroJugador() {
		
		System.out.println("Estos son los datos del jugador -> Nombre-" + getNombre() + "-Apellido-" + getApellido() + "-Edad-" +getEdad());
		mostrarNumeroPartidasJugadas();
		mostrarNumeroPartidasGanadas();
		mostrarNumeroPartidasPerdidas();
		mostrarPorcentajeVictoriasJugador();
		
	}
	
	public void guardarDatosJugadorEnFichero() {
		
	
		FileWriter archivoParaEscribir = null;
		PrintWriter imprimirEnArchivo = null;
		
		try {
			String rutaDatosJugadorRuleta = "C:\\DatosJugadorRuleta\\datosJugadorRuleta.txt";
			File archivoDatosJugadorTxt = new File(rutaDatosJugadorRuleta);
			
			if(!archivoDatosJugadorTxt.exists()) {
				archivoDatosJugadorTxt.createNewFile();			
				}
			
			//UTILIZAMOS TRUE PARA QUE NO SE SOBREESCRIBA LA INFORMACION OBTENIDA Y ASI PODER PONER NUEVOS JUGADORES
			archivoParaEscribir = new FileWriter(rutaDatosJugadorRuleta,true);
			imprimirEnArchivo = new PrintWriter(archivoParaEscribir);
			imprimirEnArchivo.println("Nombre->" + nombre + "-Apellido->" + apellido + "-Edad->" + edad);
			imprimirEnArchivo.println("Numero de partidas Jugadas->" + numeroPartidasJugadas);
			imprimirEnArchivo.println("Numero de partidas Ganadas->" + numeroPartidasGanadas);
			imprimirEnArchivo.println("Numero de partidas Perdidas->" + numeroPartidasPerdidas);
			imprimirEnArchivo.println("Porcentaje de Victorias->" + porcentajeVictoriasJugador);
		}
		catch(Exception e){
		e.printStackTrace();
	   }
		finally {
			try {
			if(null!=archivoParaEscribir) {
				archivoParaEscribir.close();
			    }
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void mostrarDatosJugadorDeArchivoTxt() {
		
		String rutaDatosJugadorRuleta = "C:\\DatosJugadorRuleta\\datosJugadorRuleta.txt";
		
		File archivo = null;
		FileReader lectorArchivo = null;
		BufferedReader lectorBuffer = null;
		
		try {
			archivo = new File(rutaDatosJugadorRuleta);
			lectorArchivo = new FileReader(archivo);
			lectorBuffer = new BufferedReader(lectorArchivo);
			
			String linea;
			
			while((linea = lectorBuffer.readLine()) != null) {
				System.out.println(linea);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				
				if(null != lectorArchivo) {
					lectorArchivo.close();
				}
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
