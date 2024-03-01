// Ejemplo de clase inmutable. No tiene métodos que modifiquen el estado de los objetos.
public class Fecha {

    private final int dia;
    private final int mes;
    private final int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }
}
