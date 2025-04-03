import java.util.Scanner;

public class GestionVuelos {
    private Vuelo[] vuelos;

    public GestionVuelos(int tamayo) {
        vuelos = new Vuelo[tamayo];
    }

    public void incializarVuelo() {
        vuelos[0] = null;
        vuelos[vuelos.length -1] = null;
        for (int i = 1; i < vuelos.length - 1; i++) {
            if (vuelos[i] != null && vuelos[i].getIdVuelo() % 2 == 0) {
                vuelos[i] = new Nacionales();
            }else {
                vuelos[i] = new Internacionales();
            }
        }
    }

    public void mostrarVuelos() {
        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i] != null) {
                System.out.println(vuelos[i].toString());
            }
        }
    }

    public void darBajaVuelo(int idVuelo) {
        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i].getIdVuelo() == idVuelo) {
                vuelos[i] = null;
            }else {
                System.out.println("El idVuelo no existe");
            }
        }
    }

    public void hayHueco(){
        boolean encontrado = false;
        for (int i = 0; i < vuelos.length; i++) {
            if(vuelos[i] == null){
                encontrado = true;
            }
        }
        if(encontrado){
            System.out.println("El idVuelo ha sido encontrado");
        }else{
            System.out.println("El idVuelo ha sido no encontrado");
        }
    }

    public Vuelo crearVuelo(boolean esNacional) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Es Nacional (1) o Internacional (2)?");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduce el id del vuelo");
        int idVuelo = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduce el origen del vuelo");
        String origen = sc.nextLine();
        sc.nextLine();

        System.out.println("Introduce el destino del vuelo");
        String destino = sc.nextLine();
        sc.nextLine();

        System.out.println("Introduce el nombre del vuelo");
        String nombre = sc.nextLine();
        sc.nextLine();

        System.out.println("Introduce el numpasajeros");
        int numpasajeros = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduce el precio del vuelo");
        double precio = sc.nextDouble();
        sc.nextLine();

        Vuelo nuevoVuelo;
        if (esNacional) {
            nuevoVuelo = new Nacionales();
        }else{
            nuevoVuelo = new Internacionales();
        }
        nuevoVuelo.setIdVuelo(idVuelo);
        nuevoVuelo.setOrigen(origen);
        nuevoVuelo.setDestino(destino);
        nuevoVuelo.setNombre(nombre);
        nuevoVuelo.setPrecio(precio);
        return nuevoVuelo;

    }

}
