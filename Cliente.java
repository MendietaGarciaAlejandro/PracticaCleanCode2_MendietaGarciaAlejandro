public class Cliente extends Persona{

    // Atributos debidamente encapsulados
    private Persona persona1;
    private String saludo;
    private String nombreCompleto;
    private String edad;

    // Faltan constructores completo y vacío

    public Cliente(Persona persona1) {
        super(persona1.getNombreCompleto(), persona1.getEdad());
        this.persona1 = persona1;
    }

    public String getSaludo() {
        String saludo = "Hola, mi nombre es " + getNombreCompleto() + " y tengo " + getEdad() + " años.";
        return saludo;
    }

    //Getters y Setters
    public int getEdad() {
        return persona1.getEdad();
    }

    public String getNombreCompleto() {
        return this.nombreCompleto = persona1.getNombre() + " " + persona1.getApellido();
        
    }

    public String getApellidoPersona() {
        return persona1.getApellido();
    }   
    
    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    // El buen Alt + Insert de NetBeans
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((persona1 == null) ? 0 : persona1.hashCode());
        result = prime * result + ((saludo == null) ? 0 : saludo.hashCode());
        result = prime * result + ((nombreCompleto == null) ? 0 : nombreCompleto.hashCode());
        result = prime * result + ((edad == null) ? 0 : edad.hashCode());
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
        Cliente other = (Cliente) obj;
        if (persona1 == null) {
            if (other.persona1 != null)
                return false;
        } else if (!persona1.equals(other.persona1))
            return false;
        if (saludo == null) {
            if (other.saludo != null)
                return false;
        } else if (!saludo.equals(other.saludo))
            return false;
        if (nombreCompleto == null) {
            if (other.nombreCompleto != null)
                return false;
        } else if (!nombreCompleto.equals(other.nombreCompleto))
            return false;
        if (edad == null) {
            if (other.edad != null)
                return false;
        } else if (!edad.equals(other.edad))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [persona1=" + persona1 + ", saludo=" + saludo + ", nombreCompleto=" + nombreCompleto + ", edad=" + edad + "]";
    } 
}
