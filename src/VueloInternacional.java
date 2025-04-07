public class VueloInternacional extends Vuelo { // ✔️ Renombrar
    private boolean haceEscala;
    private String[] paisesEscala; // ✔️ Países como String[]

    public VueloInternacional(int idVuelo, String nombre, String origen, String destino, Fecha fecha, int numPasajeros, double precioBase, boolean haceEscala, String[] paisesEscala) {
        super(idVuelo, nombre, origen, destino, fecha, numPasajeros, precioBase);
        this.haceEscala = haceEscala;
        this.paisesEscala = paisesEscala; // ✔️ Países recibidos desde el tester
    }

    public VueloInternacional() {

    }

    @Override
    public double incrementoPrecio() {
        double precioFinal = getPrecio(); // Precio base sin modificar
        int mes = getFecha().getMes();
        if (mes == 7 || mes == 8) {
            precioFinal *= 1.25; // Incremento julio/agosto
        }
        if (haceEscala) {
            precioFinal *= Math.pow(0.80, paisesEscala.length); // 20% por cada escala
        }
        return precioFinal; // ✔️ Solo cálculo, sin modificar atributos
    }
}