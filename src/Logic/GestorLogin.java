
package Logic;

import Business.Persona.Persona;
import Business.Persona.Querellante;
import data.QuerellanteService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorLogin {

    /**
     *
     * @param nombreUsuario
     * @param password
     * @return
     */
    private Persona currentUser;
    
    public boolean InicioSesion(String nombreUsuario, String password)
    {
        
        boolean allowAcces = false;

        if(password == null || password.isEmpty())
        {
            try
            {
                currentUser = encotrarQuerellante(Integer.parseInt(nombreUsuario));
            }
            catch(Exception e)
            {
                allowAcces = false;
            }
        }else
        {
            
        }
        
        if(currentUser!= null)
            allowAcces = true;
        
                    
        return allowAcces;
    }
    
    public Querellante encotrarQuerellante(int cedula) throws IOException, SQLException
    {
        QuerellanteService dbQuerellantes = new QuerellanteService();
        
       ArrayList<Querellante> listaQuerellante = dbQuerellantes.getSecretarios();
       
        for (Querellante querellante : listaQuerellante) {
            if(querellante.getCedula() == cedula)
                return querellante;
        }
        
        return null;
    }

    public Persona getCurrentUser() {
        return currentUser;
    }
    


}
