/**
 * 
 * Descripción: 
 * Fecha: 
 * Autor: Jose Solano Montoya
 * Fecha de modificación: 
 * Modificado por: Jose Solano Montoya
 */

package Logic;

import Business.Persona.Persona;
import java.io.*;

public class test {
    public static GestorLogin gl = new  GestorLogin();
    public static void main (String[] args) throws IOException
    {
        
        Persona p = gl.getCurrentUser();
    }

}
