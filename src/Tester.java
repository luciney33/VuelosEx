import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el tamaño del array de vuelos: ");
        int tamaño = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        GestionVuelos gestion = new GestionVuelos(tamaño);
        gestion.incializarVuelo(); // Inicializa nulls en primera/última posición

        int opcion;
        do {
            System.out.println("\n=== MENÚ GESTIÓN DE VUELOS ===");
            System.out.println("1. Mostrar todos los vuelos");
            System.out.println("2. Dar de baja un vuelo por ID");
            System.out.println("3. Dar de alta un vuelo");
            System.out.println("4. Buscar vuelos por filtros");
            System.out.println("5. Modificar precio base");
            System.out.println("6. Eliminar vuelos por origen/destino");
            System.out.println("7. Ordenar vuelos por precio");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1: // Mostrar vuelos
                    System.out.println("\n--- LISTADO COMPLETO ---");
                    gestion.mostrarVuelos();
                    break;

                case 2: // Eliminar por ID
                    System.out.print("\nIntroduce el ID del vuelo a eliminar: ");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    gestion.darBajaVuelo(idEliminar); // Ya muestra mensajes internos
                    break;

                case 3: // Alta de vuelo
                    System.out.println("\n--- ALTA DE VUELO ---");
                    gestion.darAltaVuelo(); // Método con Scanner interno
                    break;

                case 4: // Buscar por filtros
                    System.out.print("\nOrigen (dejar vacío para ignorar): ");
                    String origen = sc.nextLine();
                    System.out.print("Destino (dejar vacío para ignorar): ");
                    String destino = sc.nextLine();
                    System.out.print("Precio exacto (0 para ignorar): ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    gestion.listadoVuelos(origen, destino, precio);
                    break;

                case 5: // Modificar precio
                    System.out.println("\n--- MODIFICAR PRECIO ---");
                    gestion.modPrecio(); // Método con Scanner interno
                    break;

                case 6: // Eliminar por origen/destino
                    System.out.print("\nOrigen: ");
                    String origenEliminar = sc.nextLine();
                    System.out.print("Destino: ");
                    String destinoEliminar = sc.nextLine();

                    gestion.eliminarVuelo(origenEliminar, destinoEliminar);
                    break;

                case 7: // Ordenar por precio
                    gestion.ordernarPrecVuelo();
                    System.out.println("\n✅ Vuelos ordenados por precio.");
                    break;

                case 0:
                    System.out.println("\n👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("\n❌ Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}