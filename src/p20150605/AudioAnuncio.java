package p20150605;
import java.util.Date;
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
public class AudioAnuncio extends NewClass
{

    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    /**
     * Este es el constructor por defecto
     */
    public AudioAnuncio ()
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

    protected int Comprobando() {
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
        return resultado;
    }
    /**
     * Igual que el anterior comprueba que todo se ha establecido correctamente atraves del codigo de error.
     * @param objeto_daw : es el anuncio
     * @return : devuelve un codigo de error (-1,-5) o 0 si todo ha funcionado correctamente
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        int resultado = Comprobando();
        
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
