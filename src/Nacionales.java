
public class Nacionales extends Vuelo {
    public Nacionales(){}
    public Nacionales(int idVuelo,String nombre, String origen, String destino, Fecha fecha, int numpasajeros, double precio){
        super(idVuelo,nombre,origen,destino,fecha,numpasajeros,precio);
    }

    @Override
    public void incrementoPrecio() {
        int mes = getFecha().getMes();
        double nuevoprecio = getPrecio();
        if (mes == 7){
            nuevoprecio = nuevoprecio*1.20;
        } else if (mes == 8) {
            nuevoprecio = nuevoprecio*1.30;
        }
        setPrecio(nuevoprecio);
    }
    }