
import java.util.ArrayList;

public class GestorTareas {
    //Array que almacena las tareas del gestor
    private ArrayList <Tarea> tareas;

    /**
     * 01. Constructor de la clase
     */
    public GestorTareas() {
        tareas = new ArrayList<Tarea>();
    }

    /**
     * 09. Metodo que agrega una tarea al final de la lista
     */
    public void agregarTarea(String textoTarea) {
        Tarea nuevaTarea = new Tarea(textoTarea);
        tareas.add(nuevaTarea);
    }

    /**
     * 07. Método que devuelve un String con todas las tareas, una en cada línea. Si
     * no hay tarea, esa línea contiene la cadena vacía.
     */
    public String devolverTareas() {
        String textoADevolver = "";
        int contador = 1;
        // bucle foreach
        for (Tarea tarea : tareas) {
            textoADevolver = textoADevolver + tarea.getTextoTarea() + "\n";
        }
        return textoADevolver;
    }

    /**
     * 08. Método imprimeTareas que imprime por pantalla las tareas pendientes
     * basandonse en el método anterior. No devuelve nada
     */
    public void imprimirTareas() {
        System.out.println(devolverTareas());
    }

    /**
     * 10. Metodo getNumeroTareas que devuelve el numero de tareas pendientes
     * actuales y no requiere parámetros
     */
    public int getNumeroTareas() {
        return tareas.size();
    }

    /**
     * 11. Metodo getNumeroTareas2 que devuelve el numero de tareas pendientes
     * actuales y no requiere parámetros. No se puede usar el metodo size
     */
    public int getNumeroTareas2() {
        int contadorTareas = 0;
        for (Tarea tarea : tareas) {
            contadorTareas = contadorTareas + 1;
        }
        return contadorTareas;
    }

    /**
     * 12. getTareaMasAntigua Devuelve la primera tarea que se agrego al gestor de
     * tareas; si no hay tareas devuelve la cadena vacia;
     */
    public String getTareaMasAntigua() {
        String tareaMasAntigua = "";
        if (!tareas.isEmpty()) {
            tareaMasAntigua = (tareas.get(0).getTextoTarea());
        }
        return tareaMasAntigua;
    }

    /**
     * 13. imprimirTareaMasAntigua Imprime la primera tarea que se agrego al gestor
     * de tareas; si no hay tareas imprime una línea en blanco;
     */
    public void imprimirTareaMasAntigua() {
        System.out.println(getTareaMasAntigua());
    }

    /**
     * 14. getListadoTareas Devuelve un String con todas las tareas pendientes, una
     * en cada línea, precedidas de su posicion (empezando en 1), un punto y un
     * espacio (por ejemplo: "1. Hacer la cama"). Si no hay tareas devuelve la
     * cadena vacía
     */
    public String getListadoTareas() {
        String textoADevolver = "";
        int contador = 1;
        for (Tarea tarea : tareas) {
            textoADevolver = textoADevolver + contador + ". " + tarea.getTextoTarea() + "\n";
            contador = contador + 1;
        }
        return textoADevolver;

    }

    /**
     * 15. imprimirListadoTareas Imprime por pantalla todas las tareas pendientes,
     * una en cada línea, precedidas de su posicion (empezando en 1), un punto y un
     * espacio (por ejemplo: "1. Hacer la cama"). Si no hay tareas imprime una línea
     * en blanco. El método no devuelve nada.
     */
    public void impmirListadoTareas() {
        System.out.println(getListadoTareas());
    }

    /**
     * 16. getTareasEnUnaSolaLinea Devuelve todas las tareas pendientes en una sola
     * linea separadas por comas, y por un espacio y con dos corcehete al inicio y
     * al final del tipo "[tarea1, tarea2, tarea3]". Si no hay tareas devuelve la
     * cadena "[]". Es buena idea echar un vistazo a la API de la clase String si
     * nos atascamos en busca de algún metodo que nos ayude
     */
    public String getTareasEnUnaSolaLinea() {
        String tareasEnUnaLinea = "";
        for (Tarea tarea : tareas) {
            tareasEnUnaLinea = tareasEnUnaLinea + tarea.getTextoTarea() + ", ";
        }
        if (tareas.size() > 0) {
            tareasEnUnaLinea = tareasEnUnaLinea.substring(0, tareasEnUnaLinea.length() - 2);
        }
        tareasEnUnaLinea = "[" + tareasEnUnaLinea + "]";
        return tareasEnUnaLinea;
    }

    /**
     * Solucion alternativa al metodo 16
     */
    public String getTareasEnUnaSolaLinea2() {
        return tareas.toString();
    }

    /**
     * 17. imprimirTareasEnUnaSolaLinea Imrime todas las tareas pendientes en una
     * sola linea separadas por comas, y por un espacio y con dos corcehete al
     * inicio y al final del tipo "[tarea1, tarea2, tarea3]. Si no hay tareas
     * imprime una línea con dos corchetes del tipo "[]".
     */
    public void imprimirTareasEnUnaSolaLinea() {
        System.out.println(getTareasEnUnaSolaLinea());
    }

    /**
     * 18. existeTareaConElTexto Devuelve true si hay al menos una tarea que
     * contenga el texto indicado como parametro, false en caso contrario. Hay que
     * hacerlo con bucle for-each.
     */
    public boolean existeTareaConElTexto(String textoABuscar) {
        boolean contieneTexto = false;
        int contador = 0; 
        while (!contieneTexto && contador < tareas.size()) {
            String tareaActual = tareas.get(contador).getTextoTarea();
            if (tareaActual.contains(textoABuscar)) {
                contieneTexto = true;
            }
            contador += 1; 
        }
        return contieneTexto;
    }

    /**
     * 19. getTareasImportantes Devuelve un String con todas las tareas pendientes,
     * una en cada línea, precedidas de su posicion (empezando en 1), un punto y un
     * espacio (por ejemplo: "1. Hacer la cama (importante)\n3. Estudiar
     * (Importante)\n") siempre que la tarea contenga la palabra "importante" (que
     * puede aparecer en mayúsculas o en minúsculas). Si no hay tareas de ese tipo
     * devuelve la cadena vacía
     */
    public String getTareasImportantes() {
        String textoADevolver = "";
        int contador = 1;
        for (Tarea tarea : tareas) {
            if (tarea.getTextoTarea().toLowerCase().contains("importante")) {
                textoADevolver += contador + ". " + tarea.getTextoTarea() + "\n";
            }
            contador++;

        }
        return textoADevolver;
    }

    /**
     * 20. imprimirTareasImportantes Imprime por pantalla todas las tareas
     * pendientes, una en cada línea, precedidas de su posicion (empezando en 1), un
     * punto y un espacio (por ejemplo: "1. Hacer la cama (importante)\n3. Estudiar
     * (Importante)\n") siempre que la tarea contenga la palabra "importante" (que
     * puede aparecer en mayúsculas o en minúsculas). Si no hay tareas de ese tipo
     * imprime una línea en blanco.
     *
     **/
    public void imprimirTareasImportantes() {
        System.out.println(getTareasImportantes());
    }

    /**
     * 21. getTareasImpares Devuelve un String con todas las tareas pendientes, una
     * en cada línea, precedidas de su posicion (empezando en 1), un punto y un
     * espacio (por ejemplo: "1. Hacer la cama\n3.Estudiar\n") siempre que la tarea
     * ocupe una posición impar. Si no hay tareas de ese tipo devuelve la cadena
     * vacía.
     */
    public String getTareasImpares() {
        String textoADevolver = "";
        int contador = 1;

        for (Tarea tarea : tareas) {
            if (contador % 2 == 1) {
                textoADevolver += contador + ". " + tarea.getTextoTarea() + "\n";
            }
            contador++;
        }
        return textoADevolver;
    }

    /**
     * 22. imprimirTareasImpares Imprime por pantalla todas las tareas pendientes,
     * una en cada línea, precedidas de su posicion (empezando en 1),
     * un punto y un espacio (por ejemplo: "1. Hacer la cama") siempre que la tarea
     * ocupe una posición impar. Si no hay tareas de ese tipo imprime una línea en
     * blanco.
     */
    public void imprimirTareasImpares() {
        System.out.println(getTareasImpares());
    }

    /**
     * 23. eliminarTarea Elimina la tarea cuya numeración obtenida al listar las
     * tareas coincide con el parametro indicado. Devuelve true si la tarea existe y
     * se elimina y false en caso contrario
     */
    public boolean eliminarTarea(int numeroTarea) {
        boolean tareaEliminada = false;
        if (numeroTarea >= 1 && numeroTarea <= tareas.size()) {
            tareas.remove(numeroTarea - 1);
            tareaEliminada = true;
        }
        return tareaEliminada;
    }

    /**
     * 24. getPrimeraTareaConElTexto Devuelve un String conteniendo la primera tarea
     * que contenga el texto indicado como parametro. En caso de que no haya ninguna
     * coincidencia devuelve la cadena vacía. Hay que hacerlo con un bucle for-each.
     * La coincidencia tiene que ser case-sensitive.
     */
    public String getPrimeraTareaConElTexto(String texto) {
        String textoADevolver = "";
        for (Tarea tarea : tareas) {
            if(tarea.getTextoTarea().toLowerCase().contains(texto.toLowerCase()) 
            && textoADevolver.equals("")){
                textoADevolver = tarea.getTextoTarea();
            }
        }
        return textoADevolver;
    }

    /**
     * 25. imprimePrimeraTareaConTexto Imprime por pantalla la primera tarea que
     * contenga el texto indicado como parametro. En caso de que no haya ninguna
     * coincidencia imprime una línea en blanco. La coincidencia tiene que ser
     * case-sensitive.
     */
    public void imprimePrimeraTareaConTexto(String texto) {
        System.out.println(getPrimeraTareaConElTexto(texto));
    }

    /**
     * 26. getListadoTareasWhile Devuelve un String con todas las tareas pendientes,
     * una en cada línea, precedidas de su posicion (empezando en 1), un punto y un
     * espacio (por ejemplo: "1. Hacer la cama"). Si no hay tareas devuelve la
     * cadena vacía. Hay que hacerlo con un bucle while.
     */
    public String getListadoTareasWhile() {
        String listaTareas = "";
        int contador = 0;
        while (contador < tareas.size()) {
            String tareaActual = tareas.get(contador).getTextoTarea();
            listaTareas = listaTareas + (contador + 1) + ". " + tareaActual + "\n";
            contador++;
        }
        return listaTareas;
    }

    /**
     * 27. imprimirListadoTareasWhile Imprime por pantalla todas las tareas
     * pendientes, una en cada línea, precedidas de su posicion (empezando en 1), un
     * punto y un espacio (por ejemplo: "1. Hacer la cama"). Si no hay tareas
     * imprime una línea en blanco. El método no devuelve nada.
     */
    public void imprimirListadoTareasWhile() {
        System.out.println(getListadoTareasWhile());
    }

    /**
     * 28. getPrimeraTareaConElTextoWhile Devuelve un String conteniendo la primera
     * tarea que contenga el texto indicado como parametro. En caso de que no haya
     * ninguna coincidencia devuelve la cadena vacía. Hay que hacerlo con un bucle
     * while. La coincidencia tiene que ser case-sensitive.
     */
    public String getPrimeraTareaConElTextoWhile(String textoABuscar) {
        String aDevolver = "";
        boolean encontradaTarea = false;
        int contador = 0;
        while (contador < tareas.size() && !encontradaTarea) {
            String tareaActual = tareas.get(contador).getTextoTarea();
            if (tareaActual.contains(textoABuscar)) {
                aDevolver = tareaActual;
                encontradaTarea = true;
            }
            contador++;
        }
        return aDevolver;
    }

    /**
     * 29. imprimePrimeraTareaConTextoWhile Imprime por pantalla la primera tarea
     * que contenga el texto indicado como parametro. En caso de que no haya ninguna
     * coincidencia imprime una línea en blanco. La coincidencia tiene que ser
     * case-sensitive.
     */
    public void imprimePrimeraTareaConTextoWhile(String textoABuscar) {
        System.out.println(getPrimeraTareaConElTextoWhile(textoABuscar));
    }

    /**
     * 30. getPrimerasTareas Devuelve un String conteniendo las primeras n tareas
     * (siendo n el parametro del metodo), una en cada linea con su número delante.
     * En caso de que no haya suficientes se devuelven solo las que haya. En caso de
     * no haber tareas se devuelve la cadena vacía.
     */
    public String getPrimerasTareas(int numeroTareas) {
        String textoADevolver = "";
        int contador = 0;
        while (contador < tareas.size() && contador < numeroTareas) {
            String tareaActual = tareas.get(contador).getTextoTarea();
            textoADevolver += (contador + 1) + ". " + tareaActual + "\n";
            contador++;
        }
        return textoADevolver;

    }

    /**
     * 31. imprimePrimerasTareas Imprime por pantalla las primeras n tareas (siendo
     * n el parametro del metodo), una en cada linea con su número delante. En caso
     * de que no haya suficientes se imprimen solo las que haya. En caso de no haber
     * tareas se imprime una linea en blanco. El metodo no devuelve nada y debe usar
     * el método anterior
     */
    public void imprimePrimerasTareas(int numeroTareas) {
        System.out.println(getPrimerasTareas(numeroTareas));
    }

    /**
     * 32. hayTareaConElTextoEficiente Devuelve true si hay al menos una tarea que
     * contenga el texto indicado como parámetro y false en caso contrario. El
     * metodo se debe ejecutar de la forma mas rapida posible
     */

    public boolean hayTareaConElTextoEficiente(String textoABuscar) {
        boolean encontradaTarea = false;
        int contador = 0;
        while (contador < tareas.size() && !encontradaTarea) {
            String tareaActual = tareas.get(contador).getTextoTarea();
            if (tareaActual.contains(textoABuscar)) {
                encontradaTarea = true;
            }
            contador++;
        }
        return encontradaTarea;
    }

    /**
     * 33. getTareasConElTexto Devuelve un String conteniendo todas las tareas que
     * contienen el texto indicado como parametro, una en cada linea (sin número
     * asociado). El String devuelto contiene una ultima linea adicional que indica
     * el numero de tareas encontradas o el texto "No se encontraron coincidencias".
     * La coincidencia tiene que ser case-sensitive.
     */
    public String getTareasConElTexto(String textoABuscar) {
        String listaTareas = "";
        int numTareasEncontradas = 0;
        for (Tarea tareaActual : tareas) {

            if (tareaActual.getTextoTarea().contains(textoABuscar)) {
                listaTareas += tareaActual.getTextoTarea() + "\n";
                numTareasEncontradas++;
            }
        }
        if (numTareasEncontradas == 0) {
            listaTareas = "No se encontraron coincidencias";
        } else {
            listaTareas = listaTareas + numTareasEncontradas;
        }
        return listaTareas;

    }

    /**
     * 34. imprimirTareasConElTexto Muestra por pantalla todas las tareas que
     * contienen el texto indicado como parametro, una en cada linea. Se imprime una
     * ultima linea adicional que indica el numero de tareas encontradas o el texto
     * "No se encontraron coincidencias" si no hay ninguna que contenga el texto. La
     * coincidencia tiene que ser case-sensitive.
     */
    public void imprimirTareasConElTexto(String textoABuscar) {
        System.out.println(getTareasConElTexto(textoABuscar));
    }

    /**
     * 35. eliminaPrimeraTareaConElTexto Elimina la primera tarea que contiene el
     * texto indicado por parámetro. Devuelve true si se eliminó una tarea o false
     * en caso contrario. Hay que hacerlo lo mas eficiente posible
     */
    public boolean eliminaPrimeraTareaConElTexto(String texto) {
        boolean tareaEncontradaYEliminada = false;
        int contador = 0;
        while (contador < tareas.size() && !tareaEncontradaYEliminada) {
            String tareaActual = tareas.get(contador).getTextoTarea();
            if (tareaActual.contains(texto)) {
                tareas.remove(contador);
                tareaEncontradaYEliminada = true;
            }
            contador++;
        }

        return tareaEncontradaYEliminada;
    }

    /**
     * 36. eliminaTodasLasTareasConElTexto Elimina todas las tareas que contienen un
     * texto pasado como parametro. Devuelve el numero de tareas eliminadas. Hay que
     * hacerlo con un bucle while.
     */

    public int eliminaTodasLasTareasConElTexto(String textoABuscar) {
        int tareasBorradas = 0;
        int contador = 0;
        while (contador < tareas.size()) {

            if (tareas.get(contador).getTextoTarea().contains(textoABuscar)) {
                tareas.remove(contador);
                tareasBorradas++;
            } else {
                contador++;
            }
        }
        return tareasBorradas;
    }

    /**
     * 37. editarTarea Modifica el texto de la tarea indicada cuyo numero al
     * listarla coincide con el pasado como primer parametro dejando el texto
     * indicado en el segundo parámetro. Si la operación tiene exito devuelve
     * true; false en caso contrario.
     */
    public boolean editarTarea(int numeroTarea, String textoACambiar){
        boolean tareaModificada = false;
        if (numeroTarea <= tareas.size() && numeroTarea > 0) {
            tareas.get (numeroTarea -1).setTextoTarea(textoACambiar);
            tareaModificada = true;
        }
        return tareaModificada;

    }

    /**
     * 39. getListaTareasCompletadasYNoCompletadas Devuelve un String  con todas las
     * tareas una en cada línea, precedidas de su posicion (empezando en 1), un
     * punto un espacio y, si estan completadas, un corchete, una x y otro corchete,
     * y luego el texto de la tarea. Ejemplo de tarea terminada sería 
     * "1. [x] Hacer la cama". Ejemplo de tarea no terminada sería "1. Hacer la cama". 
     * Si no hay tareas devuelve la cadena vacía. Se asume que las tareas cuando 
     * se insertan en el gestor no están completadas. No se pueden agregar nuevas 
     * clases al proyecto.
     */
    
    public String getListaTareasCompletadasYNoCompletadas() {
        String listaTareasCompletadas = "";
        int contador = 1;
        for (Tarea tarea : tareas){
            listaTareasCompletadas += contador + ". ";
            if (tarea.getTareaCompletada()){
                listaTareasCompletadas += "[x] ";
            }
            listaTareasCompletadas += tarea.getTextoTarea() + "\n";
            contador ++;
        }

        return listaTareasCompletadas;
    }
    

    /**
     * 40. marcarComoCompletada Marca como completada la tarea cuyo numero al
     * listarla coincide con el pasado como parametro y devuelve true si pudo
     * realizar la operacion o false en caso contrario (se entiende que una tarea
     * que ya esta completada no se puede volver a marcar como completada)
     * No se pueden agregar nuevas clases al proyecto. Tampoco se puede cambiar
     * el texto de una tarea (el resto de método anteriores deben seguir
     * funcionando tal y como estan ahora mismo)
     */
    public boolean marcarComoCompletada(int numeroTarea) {
        //boolean completada = false;
        numeroTarea = numeroTarea - 1; 
        if (numeroTarea <= tareas.size() && numeroTarea >= 0) {
            if (tareas.get(numeroTarea).getTareaCompletada() == false) {

                tareas.get(numeroTarea).setCompletada();

                return true;

            }
        }
        return false;

       
    }

}