
public class VueloNacional extends Vuelo { // ✔️ Renombrar por convención
    public VueloNacional(int idVuelo, String nombre, String origen, String destino, Fecha fecha, int numpasajeros, double precio) {
        super(idVuelo, nombre, origen, destino, fecha, numpasajeros, precio);
    }

    public VueloNacional() {

    }

    @Override
    public double incrementoPrecio() {
        double precioFinal = getPrecio(); // Precio base sin modificar
        int mes = getFecha().getMes();
        if (mes == 7) precioFinal *= 1.20;
        else if (mes == 8) precioFinal *= 1.30;
        return precioFinal; // ✔️ Retorna el cálculo sin modificar atributos
    }
}