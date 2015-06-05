package p20150605;

import java.io.File;
/**
 * 
 * @author Marta
 * @version 1.0.1
 * 
 * AudioSpot es una clase que sirve de base para gestionar cuñas de anuncios 
 * publicitarios en radio. Cada objeto se referirá a una cuña diferente. 
 * Es capaz de almacenar metadatos sobre el anuncio y una referencia al archivo 
 * de audio que lo contiene. También permite acciones tales como programar la 
 * cuña dentro de una secuencia de audio clips y exportar la cuña completa 
 * (audio+metadatos) a un formato propio (.daf, acrónimo de Daw Audio Format).
 */

/**
 * Constructor personalizado
 */
public class AudioSpot
{

    private File archivo;       // manejador para el archivo que contiene el audio (.mp3)
    private int duracion;       // duración del audio, en segundos
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    public String lasterrormsg;
    /**
     * Este es el constructor por defecto
     */
    public AudioSpot ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    /**
     * 
     * @param producto : es el producto del anuncio
     * @param anunciante : persona o compañia que anuncia dicho producto
     * 
     * Este metodo establece el producto y el anunciante
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
    /**
     * 
     * @param duracion : Se encarga de la duracion del anuncio y de establecer un maximo.
     * @throws IllegalArgumentException 
     */
    public void setDuracion(int duracion) throws IllegalArgumentException
    {
        if (duracion<0)
            duracion=0;
        else if (duracion>120)
            throw new IllegalArgumentException ("Duración demasiado larga");
        this.duracion = duracion;
    }
    /**
     * 
     * @param nombre_archivo : Indica si el archivo existe
     * @return Nos devuelve el archivo si este existe
     */
    public Boolean setArchivo(String nombre_archivo)
    {
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
    public int ProgramaEnCola(Object cola_reproduccion)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        
        // si todo va bien, programamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }     
        }
        else
            return resultado;
    }
    /**
     * Igual que el anterior comprueba que todo se ha establecido correctamente atraves del codigo de error.
     * @param objeto_daw : es el anuncio
     * @return : devuelve un codigo de error (-1,-5) o 0 si todo ha funcionado correctamente
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        
        // si todo va bien, exportamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        }
        else
            return resultado;
    }
    
}
