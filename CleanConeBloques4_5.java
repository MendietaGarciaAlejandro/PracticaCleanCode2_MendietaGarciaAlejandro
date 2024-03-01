import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CleanConeBloques4_5 {

    public static void main(String[] args) {
        // Desarrollo de los puntos principales de la practica
        // Bloque IV: Objetos y estructuras de datos

        // Diferencias entre objetos y estructuras de datos

        // Objeto: Persona (por ejemplo)
        Persona persona1 = new Persona("Cristo", 33);
        persona1.setNombre("Salvador"); 
        String nombreCompleto = persona1.getNombreCompleto();
        System.out.println("Nombre completo: " + nombreCompleto);

        // Estructura de datos: Lista de personas (haria un array, pero tengo que practicar las cdistintas colecciones y mapas de la UT09 de programacion)
        List<Persona> personas = new ArrayList<>();
        personas.add(persona1);
        personas.add(new Persona("Eulalia", 90));
        personas.forEach(System.out::println); 

        // La Ley de Demeter

        // Correcto: No conoce las tripas de Persona
        Cliente cliente1 = new Cliente(persona1);
        System.out.println("Saludo: " + cliente1.getSaludo());

        // Incorrecto: Conoce las tripas de Persona
        Cliente cliente2 = new Cliente(persona1);
        System.out.println("Apellido: " + cliente2.getApellidoPersona());

        // Bloque V: Manejo de errores

        // Usa excepciones en lugar de código de retorno
        class EdadInvalidaException extends Exception {
            public EdadInvalidaException(String message) {
                super(message);
            }
        }

        try {
            int edad = persona1.getEdad();
            if (edad < 0) {
                throw new EdadInvalidaException("La edad evidentemente no puede ser negativa");
            }
            System.out.println("Edad: " + edad);
        } 
        catch (EdadInvalidaException edInvEx) {
            System.out.println("Error: " + edInvEx.getMessage());
        }

        // Escribe primero el try-catch-finally
        try (Scanner entrada = new Scanner(new File("cositas.txt"))) {
            while (entrada.hasNextLine()) {
                System.out.println(entrada.nextLine());
            }
        } 
        catch (FileNotFoundException fiNoFuEx) {
            System.out.println("Error al abrir el archivo: " + fiNoFuEx.getMessage());
        } 
        finally {
            System.out.println("Documento leído");
        }

        // Usa excepciones unchecked
        try {
            persona1.validarEdad(-1);
        } 
        catch (Persona.EdadInvalidaException edInEx) {
            edInEx.printStackTrace();
        }

        // No devuelvas Null
        Persona personaEncontrada = buscarPersonaPorNombre("Ana");
        if (personaEncontrada == null) {
            System.out.println("Persona no encontrada");
        } else {
            System.out.println("Persona encontrada: " + personaEncontrada);
        }
    }

    private static List<Persona> personas = new ArrayList<>();

    private static Persona buscarPersonaPorNombre(String nombre) {
        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombre)) {
                return persona;
            }
        }
        return null;
    }
}
