package Cinema;

import java.util.List;
import java.util.Scanner;

public class Cine {

	static Scanner input = new Scanner(System.in);

	
	private int numFilas;
    private int numAsientos;
    private GestionButacas gestionButacas;

    public Cine() {
        this.gestionButacas = new GestionButacas();
        pedirDatosIniciales();
    }

    public void pedirDatosIniciales() {
    	
    	numFilas = pedirInt("Cuantas filas tiene la sala de cine?");
    	numAsientos =pedirInt("Cuantos asientos tiene la sala de cine?");
    }
    
    public void iniciar() throws Exception {
        int opcion = menu();
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    mostrarButacas();
                    break;
                case 2:
                    mostrarButacasPersona();
                    break;
                case 3:
                    reservarButaca();
                    break;
                case 4:
                    anularReserva();
                    break;
                case 5:
                    anularReservaPersona();
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
            opcion = menu();
        }
        System.out.println("Saliendo de la aplicación...");
    }

    public int menu() {
      
        System.out.println("1. Mostrar todas las butacas reservadas");
        System.out.println("2. Mostrar butacas reservadas por una persona");
        System.out.println("3. Reservar una butaca");
        System.out.println("4. Anular la reserva de una butaca");
        System.out.println("5. Anular todas las reservas de una persona");
        System.out.println("0. Salir");
        int opcion = pedirInt("Introduce la opción deseada");
        return opcion;
    }

    public void mostrarButacas() {
        System.out.println("Las butacas reservadas son: "+gestionButacas.getButacas());
    }

    public void mostrarButacasPersona() throws ExcepcionNomPersonaIncorrect {
    	String nombre = pedirString("Indica el nombre de la persona");
    	List <Butaca> nomExist = gestionButacas.getButacas().stream().filter(butaca -> butaca.getPersona().equalsIgnoreCase(nombre)).toList();
		if (nomExist.isEmpty())
			System.out.println("No hay ninguna reserva con el nombre: "+nombre);
		else nomExist.forEach(System.out::println);
    	
    	
    }

    public void reservarButaca() throws ExcepcioButacaOcupada {
    	int numFila = pedirInt("Indica el numero de fila");
    	int numAsiento = pedirInt("Indica el numero de asiento");
    	String persona = pedirString("Indica el nombre de la persona");
    	try {
            Butaca butaca = new Butaca(numFila, numAsiento, persona);
            gestionButacas.añadirButaca(butaca);
            System.out.println("Butaca reservada correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void anularReserva() throws ExcepcioButacaLibre {
    	int numFila = pedirInt("Indica el numero de fila");
    	int numAsiento = pedirInt("Indica el numero de asiento");
    	try {
            gestionButacas.eliminarButaca(numFila, numAsiento);
            System.out.println("Butaca anulada correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void anularReservaPersona() throws ExcepcioButacaLibre {
    	String nomPersona = pedirString("Indica el nombre de la persona de la que quieres anular reservas");
		List<Butaca>nomExist = gestionButacas.getButacas().stream().filter(butaca -> butaca.getPersona().equalsIgnoreCase(nomPersona)).toList();
		if (nomExist.isEmpty()) 
			System.out.println("No hay ninguna reserva con el nombre "+nomPersona);
		else 
			for (Butaca butaca2 : nomExist) {
				gestionButacas.eliminarButaca(butaca2.getNumFila(), butaca2.getNumAsiento());
			}
		System.out.println("Las reservas a nombre de  "+nomPersona+" se han anulado correctamente");
    }
    
    static int pedirInt(String texto) {
		System.out.println(texto);
		int n1 = input.nextInt();
		return n1;
	}
	static String pedirString(String texto) {
		System.out.println(texto);
		String nom = input.next();
		return nom;
	}
}
