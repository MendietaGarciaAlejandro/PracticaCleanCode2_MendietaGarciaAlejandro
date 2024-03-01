public class Persona {

    // Constantes públicas y privadas
    public static final String ESPECIE = "Homo sapiens";
    private static final int EDAD_MINIMA = 0;

    // Atributos de clase públicos (raramente y poco recomendable)
    public String nombre;

    // Atributos privadas (mejor)
    private String apellido;
    private int edad;

    // Métodos públicos (Atributos privados + métodos públicos = interfaz)
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void setEdad(int edad) throws EdadInvalidaException {
        if (edad < EDAD_MINIMA) {
            throw new EdadInvalidaException("La edad no puede ser negativa, espabila");
        }
        this.edad = edad;
    }

    // Clase anidada para el manejo de la excepción (me tengo que mirar la UT08 de programacion)
    class EdadInvalidaException extends Exception {
        public EdadInvalidaException(String message) {
            super(message);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreCompleto() {
        return getNombre() + getApellido(); // El requete getter xD
    }

    public void setNombre(String string) {
        this.nombre = string;
    }

    public void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0) {
            throw new EdadInvalidaException("La edad no puede ser negativa");
        }
        this.edad = edad;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        result = prime * result + edad;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (apellido == null) {
            if (other.apellido != null)
                return false;
        } else if (!apellido.equals(other.apellido))
            return false;
        if (edad != other.edad)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
    }    
}
