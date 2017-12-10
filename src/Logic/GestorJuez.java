/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Business.Corte.Sala;
import Business.Persona.Juez;
import Business.Persona.Usuario;
import Services.JuezServices;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

/**
 *
 * @author mean
 */
public class GestorJuez {
    
    JuezServices juezService = new JuezServices();
   
    /**
     *
     * @return Retorna un array de strings con los jueces 
     * @throws IOException
     * @throws SQLException
     */
    public ArrayList<String[]> getJueces() throws IOException, SQLException {
        ArrayList<Juez> listSecre = juezService.getJueces();
        ArrayList<String[]> strlistSecre = new ArrayList<>();
        String[] strSecretario;
        for (Juez jue : listSecre) {
            strSecretario = new String[7];
            strSecretario[0] = jue.getIdPersona() + "";
            strSecretario[1] = jue.getCedula() + "";
            strSecretario[2] = jue.getNombre();
            strSecretario[3] = jue.getNumeroJuez()+"";
            strSecretario[4] = jue.getSalaJustica().getNombreSala()+ "";
            strSecretario[5] = jue.getLoginUsuario().getNombreUsuario();
            strSecretario[6] = jue.getLoginUsuario().getIdUsuario() + "";
            strlistSecre.add(strSecretario);
        }

        return strlistSecre;
    }
     
    /**
     *
     * @param id
     * @return Retorna un array con la info del un juez 
     * @throws SQLException
     * @throws IOException
     */
    public String[] getJuez(int id) throws SQLException, IOException{
     Juez jue = juezService.get(id);
     String[] judge = new String[9];
     judge[0] = jue.getIdPersona()+"";
     judge[1] = jue.getNombre();
     judge[2] = jue.getCedula()+"";
     judge[3] = jue.getApellido();
     judge[4] = jue.getTelefono()+"";
     judge[5] = jue.getDireccion();
     judge[6] = jue.getLoginUsuario().getNombreUsuario();
     judge[7] = jue.getSalaJustica().getNombreSala();
     judge[8] = jue.getNumeroJuez()+"";
     
     
     return judge;
     
     }
     
    /**
     * Crea un objecto juez para actualizarlo en la base de datos
     * @param juez
     * @throws SQLException
     * @throws IOException
     */
    public void update(String[] juez) throws SQLException, IOException{
         Juez ju = new Juez();
         Usuario usu = new Usuario();
         Sala sal  = new Sala();
         ju.setIdPersona(Integer.parseInt(juez[0]));
         ju.setNombre(juez[1]);
         ju.setApellido(juez[2]);
         ju.setTelefono(Integer.parseInt(juez[3]));
         ju.setCedula(Integer.parseInt(juez[4]));
         ju.setDireccion(juez[5]);
         ju.setNumeroJuez(Integer.parseInt(juez[8]));
         usu.setNombreUsuario(juez[6]);
         sal.setNombreSala(juez[7]);
         
         ju.setLoginUsuario(usu);
         ju.setSalaJustica(sal);
         
         juezService.update(ju);
         
     }

    /**
     * Crea un objecto juez nuevo para ingresarlo en la base de datos
     * @param juez
     * @throws SQLException
     * @throws IOException
     */
    public void create(String[] juez)throws SQLException, IOException{
         Juez ju = new Juez();
         Usuario usu = new Usuario();
         Sala sal  = new Sala();
       
         ju.setNombre(juez[0]);
         ju.setApellido(juez[1]);
         ju.setTelefono(Integer.parseInt(juez[2]));
         ju.setCedula(Integer.parseInt(juez[3]));
         ju.setDireccion(juez[4]);
         ju.setNumeroJuez(Integer.parseInt(juez[7]));
         usu.setNombreUsuario(juez[5]);
         usu.setPassword(juez[8]);
         sal.setNombreSala(juez[6]);
         
         ju.setLoginUsuario(usu);
         ju.setSalaJustica(sal);
         
         
         juezService.create(ju);
         
     }
     
    /**
     * Envia el id de un juez para eliminarlo
     * @param idPersona
     * @throws SQLException
     * @throws IOException
     */
    public void delete(int idPersona) throws SQLException, IOException {
       
            juezService.delete(idPersona);
     
     }
    
}
