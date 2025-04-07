
public abstract class Vuelo {
    private int idVuelo;
    private String nombre;
    private String origen;
    private String destino;
    private Fecha fecha;
    private int numpasajeros;
    private double precio;
    public Vuelo[] vuelos = new Vuelo[10];

    public Vuelo() {}
    public Vuelo(int idVuelo,String nombre, String origen, String destino, Fecha fecha, int numpasajeros, double precio) {
        this.idVuelo = idVuelo;
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.numpasajeros = numpasajeros;
        this.precio = precio;
    }
    public Vuelo(Fecha fecha, double precio){
        this.fecha = fecha;
        this.precio = precio;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public int getNumpasajeros() {
        return numpasajeros;
    }

    public void setNumpasajeros(int numpasajeros) {
        this.numpasajeros = numpasajeros;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public abstract double incrementoPrecio();
    @Override
    public String toString() {
        return "Vuelo{" +
                "idVuelo=" + idVuelo +
                ", nombre='" + nombre + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", fecha=" + fecha +
                ", numpasajeros=" + numpasajeros +
                ", precio=" + precio +
                '}';
    }
}