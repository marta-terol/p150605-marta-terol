/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20150605;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Marta
 */
public abstract class NewClass {
    protected static final int MaximoAudio = 120;
    protected File archivo; // manejador para el archivo que contiene el audio (.mp3)
    protected int duracion; // duración del audio, en segundos
    public String lasterrormsg;

    public NewClass() {
    }

    /**
     *
     * @param duracion : Se encarga de la duracion del anuncio y de establecer un maximo.
     * @throws IllegalArgumentException
     */
    public void setDuracion(int duracion) throws IllegalArgumentException {
        if (duracion < 0) {
            duracion = 0;
        } else if (duracion > MaximoAudio) {
            throw new IllegalArgumentException("Duración demasiado larga");
        }
        this.duracion = duracion;
    }

    /**
     *
     * @param nombre_archivo : Indica si el archivo existe
     * @return Nos devuelve el archivo si este existe
     */
    public Boolean setArchivo(String nombre_archivo) {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }

    /**
     *
     * @param cola_reproduccion : Establece la cola de reproduccion
     * @return : devuelve un codigo de error (-1,-5) o 0 si todo ha funcionado correctamente
     *
     * Si es -1 no se ha establecido la duracion
     * Si es -2 no se ha indicado el nombre del producto
     * Si es -3 no se ha indicado cual es la empresa anunciante
     * Si es -4 no se ha establecido el archivo de audio
     *
     * Si todo ha sido introducido proseguimos a programar. En este caso si encontrase algun error
     * durante la programacion saltaria el codigo de error -5
     */
    public int ProgramaEnCola(Object cola_reproduccion, Date date) {
        int resultado = Comprobando();
        date = null;
        // si todo va bien, programamos
        if (resultado == 0) {
            try {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            } catch (Exception ex) {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        } else {
            return resultado;
        }
    }

    protected abstract int Comprobando();
    
}
