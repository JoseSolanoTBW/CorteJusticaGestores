
package Logic;

import Business.Corte.Sala;
import Business.Persona.Juez;
import Business.Persona.Persona;
import Business.Persona.Querellante;
import Business.Persona.Secretario;
import Business.Persona.Usuario;
import Services.JuezServices;
import Services.QuerellanteServices;
import Services.UsuariosService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mean
 */
public class GestorLogin {

    /**
     *
     * @param nombreUsuario
     * @param password
     * @return
     */
    private Persona currentUser;
    private String userType;
    
    /**
     *
     * @param nombreUsuario
     * @param password
     * @return Retorna si el login es valido o no
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException
     * @throws IOException
     */
    public boolean InicioSesion(String nombreUsuario, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException
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
            Usuario user = getUsers(nombreUsuario, password);
            if(user == null)
               return false;
            
           currentUser = getPersona(user);
        }
        
        if(currentUser!= null)
            allowAcces = true;
                            
        return allowAcces;
    }
    
    /**
     *
     * @param cedula
     * @return encuentra un querellante en base a la cedula
     * @throws IOException
     * @throws SQLException
     */
    public Querellante encotrarQuerellante(int cedula) throws IOException, SQLException
    {
        QuerellanteServices dbQuerellantes = new QuerellanteServices();
        
       ArrayList<Querellante> listaQuerellante = dbQuerellantes.getQuerrellantes();
       
        for (Querellante querellante : listaQuerellante) {
            if(querellante.getCedula() == cedula)
                return querellante;
        }
        
        return null;
    }

    /**
     *
     * @return retorna el usuario actualmente logeado
     */
    public Persona getCurrentUser() {
        return currentUser;
    }
    
    private Usuario getUsers(String username, String password) throws SQLException, IOException
    {
        UsuariosService dbUsers = new UsuariosService();
        ArrayList<Usuario> user = dbUsers.getUsuarios();
        
        for (Usuario usuario : user) {
            if(usuario.getNombreUsuario().equals(username) && usuario.getPassword().equals(password))
                return usuario;
        }        
        return null;
    }
    
    private Persona getPersona(Usuario user) throws IOException, SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        UsuariosService dbUs = new UsuariosService();
        Persona per = dbUs.getPersonaById(user.getIdUsuario());
        userType = per.getTipoUsuario();
        Class c = Class.forName("Business.Persona." + userType);
        Object obj = c.newInstance();
        Persona result = (Persona) obj;
        
        switch(userType)
        {
            case "Secretario":
                result = new Secretario(per.getIdPersona(), per.getCedula(), per.getNombre(), per.getApellido(), per.getTelefono(), per.getDireccion(), user.getNombreUsuario(), user.getPassword());
            break;
            case "Juez":
                JuezServices dbjuez = new JuezServices();
                Sala salaJuez = dbjuez.getSalaByUserName(user.getNombreUsuario());
                result = new Juez(per.getIdPersona(), per.getCedula(), per.getNombre(), per.getApellido(), per.getTelefono(), per.getDireccion(), 0, salaJuez, user.getNombreUsuario(), user.getIdUsuario());
            break;
        }
        
        return result;
    }
    
    /**
     *
     * @return Retorna un tipo de usuario
     */
    public String getUserType()
    {
        return userType;
    }
}
