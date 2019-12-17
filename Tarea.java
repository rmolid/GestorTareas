/**
 * Clase para las Tareas que tienen una descripcion y pueden o no estar 
 * completadas
 */

public class Tarea
{
    //tarea del gestor
    private String tarea;
    // tarea completada
    private boolean completada;
    /**
     * Contructor de la clase Tarea
     */
    public Tarea(String tareaNueva) {
        tarea = tareaNueva;
        completada = false; 

    }

    /**
     * 01. Método get que obtiene el texto de la tarea
     */
    public String getTextoTarea(){ 
        return tarea; 
    }

    /**
     * 02. Método get que indica que la tarea no está completada.
     */
    public boolean getTareaCompletada(){
        return completada;     
    }

    /**
     * 03 Método set que permite cambiar el texto de la tarea
     */
    public void setTextoTarea (String textoTarea) {
        tarea = textoTarea;
    }

    /**
     * 04. Método set que cambia el estado de la tarea a completado
     */
    public void setCompletada() {
        completada = true;  
    }
}

