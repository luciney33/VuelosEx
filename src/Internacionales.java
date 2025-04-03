
import java.util.Random;

public class Internacionales extends Vuelo {
    private boolean hayescala = false;
    private String [] escalas;

    public Internacionales(){}
    public Internacionales(Fecha fecha, double precio, boolean hayescala){
        super(fecha, precio);
        this.hayescala = hayescala;
        if (hayescala){
            Random r = new Random();
            int contesc = r.nextInt(2);
            escalas = new String[contesc];
            for (int i = 0; i < contesc; i++) {
                escalas[i] = Pais.PAISES[r.nextInt(Pais.PAISES.length)];
            }
        }
    }

    public boolean isHayescala() {
        return hayescala;
    }

    public void setHayescala(boolean hayescala) {
        this.hayescala = hayescala;
    }

    public void vueloEscala(){
        double preciodesc = getPrecio();
        int contesc = 0;
        if (hayescala){
            for (int i = 0; i < escalas.length; i++) {
                preciodesc = preciodesc*0.80;
                System.out.println("Hace escala en "+escalas[i]);
                contesc++;
            }
            System.out.println("El descuento del precio final "+preciodesc);
        }else {
            System.out.println("no hay escalas");
        }
        setPrecio(preciodesc);
    }


    @Override
    public void incrementoPrecio() {
        int mes = getFecha().getMes();
        double nuevoprecio = getPrecio();
        if (mes == 7 || mes == 8){
            nuevoprecio = nuevoprecio * 1.25;
        }
        setPrecio(nuevoprecio);
    }
}