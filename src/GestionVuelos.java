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
                vuelos[i] = new VueloNacional();
            }else {
                vuelos[i] = new VueloInternacional();
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

    public boolean hayHueco() {
        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i] == null) {
                return true;
            }
        }
        return false;
    }

    public Vuelo crearVuelo() {
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
        if (tipo==1) {
            nuevoVuelo = new VueloNacional();
        }else{
            nuevoVuelo = new VueloInternacional();
        }
        nuevoVuelo.setIdVuelo(idVuelo);
        nuevoVuelo.setOrigen(origen);
        nuevoVuelo.setDestino(destino);
        nuevoVuelo.setNombre(nombre);
        nuevoVuelo.setPrecio(precio);
        return nuevoVuelo;
    }

    public void darAltaVuelo(){
        boolean vueloAñad=false;
        if (hayHueco()){
            for (int i = 1; i < vuelos.length-1; i++) {
                if (vuelos[i] == null){
                    Vuelo vuelo = crearVuelo();
                    vuelos[i] = vuelo;
                    System.out.println("Se añadio el vuelo correctamente");
                    vueloAñad = true;
                }else {
                    System.out.println("no se añadió");
                }
            }
        }else {
            System.out.println("No hay hueco");
        }
    }

    public void listadoVuelos(String origen, String destino, double precio){
        boolean encontrado = false;
        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i]==null && vuelos[i].getOrigen().equals(origen)
               && vuelos[i].getDestino().equals(destino) && vuelos[i].getPrecio() == precio){
                System.out.println(vuelos[i]);
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se encontraron con ese rango");
        }
    }

    public void modPrecio(){
        boolean cambio = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el id del vuelo que desee cambiar el precio");
        int idVuelo = sc.nextInt();
        sc.nextLine();
        System.out.println("Ahora introduzca el nuevo precio");
        double nuevoPrecio = sc.nextDouble();
        sc.nextLine();
        for (int i = 1; i < vuelos.length-1; i++) {
            if (vuelos[i] != null && vuelos[i].getIdVuelo() == idVuelo){
                vuelos[i].setPrecio(nuevoPrecio);
                cambio=true;
                System.out.println("El ccambio se hizo");
            }
        }
        if (!cambio){
            System.out.println("No se pudo completar la operacion");
        }
    }

    public void eliminarVuelo(String origen, String destino){
        Scanner sc = new Scanner(System.in);
        boolean encontrados = false;
        for (int i = 1; i < vuelos.length-1; i++) {
            if (vuelos[i] != null && vuelos[i].getOrigen().equals(origen)
                    && vuelos[i].getDestino().equals(destino)){
                encontrados=true;
                System.out.println("Desea de verdad borrar el vuelo?:(1)si ,(2)NO");
                int opc =  sc.nextInt();
                if (opc == 1){
                    vuelos[i]= null;
                    System.out.println("Eliminacion aceptada");
                }else {
                    System.out.println("eliminacion cancelada");
                }
            }
        }
        if (!encontrados){
            System.out.println("No se encontro el vuelo");
        }
    }

    public void ordernarPrecVuelo(){
        for (int i = 1; i < vuelos.length-1; i++) {
            Vuelo aux;
            for (int j = i+1; j < vuelos.length-1 ; j++) {
               if (vuelos[i] != null && vuelos[j] != null && vuelos[i].incrementoPrecio() > vuelos[j].incrementoPrecio()){
                   aux = vuelos[i];
                   vuelos[i] = vuelos[j];
                   vuelos[j] = aux;
               }
            }
        }
    }
}
