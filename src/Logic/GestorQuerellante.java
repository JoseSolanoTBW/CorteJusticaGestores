/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Business.Persona.Querellante;
import data.QuerellanteServices;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mean
 */
public class GestorQuerellante {
    QuerellanteServices qService = new QuerellanteServices();
    
    
     public ArrayList<String[]> getQuerellantes() throws IOException, SQLException {
        ArrayList<Querellante> listQuere = qService.getQuerrellantes();
        ArrayList<String[]> strListQuere = new ArrayList<>();
        String[] strQuerellante;
        for (Querellante quere : listQuere) {
            strQuerellante = new String[6];
            strQuerellante[0] = quere.getIdPersona() + "";
            strQuerellante[1] = quere.getCedula() + "";
            strQuerellante[2] = quere.getNombre();
            strQuerellante[3] = quere.getApellido();
            strQuerellante[4] = quere.getTelefono() + "";
            strQuerellante[5] = quere.getDireccion();
           
            strListQuere.add(strQuerellante);
        }

        return strListQuere;
    }

    public String[] getQuerellante(int id) throws IOException, SQLException {
        Querellante secre = qService.get(id);
        String[] strSecre = new String[6];
        strSecre[0] = secre.getIdPersona() + "";
        strSecre[1] = secre.getCedula() + "";
        strSecre[2] = secre.getNombre();
        strSecre[3] = secre.getApellido();
        strSecre[4] = secre.getTelefono() + "";
        strSecre[5] = secre.getDireccion();

        
        return strSecre;
    }
    
    public void update(String[]infoQuere) throws SQLException, IOException{
        Querellante upQuere = new Querellante();
       
        
        upQuere.setIdPersona(Integer.parseInt(infoQuere[0]));
        upQuere.setNombre(infoQuere[1]);
        upQuere.setApellido(infoQuere[2]);
        upQuere.setTelefono(Integer.parseInt(infoQuere[3]));
        upQuere.setCedula(Integer.parseInt(infoQuere[4]));
        upQuere.setDireccion(infoQuere[5]);
        
        
        qService.update(upQuere); 
        
    }
    
    public void delete(int id) throws SQLException, IOException{
        qService.delete(id);
    }
    
    public void create(String[] infoSecre) throws IOException, SQLException{
    Querellante upQuere = new Querellante();
       
       
        
        upQuere.setNombre(infoSecre[0]);
        upQuere.setApellido(infoSecre[1]);
        upQuere.setTelefono(Integer.parseInt(infoSecre[2]));
        upQuere.setCedula(Integer.parseInt(infoSecre[3]));
        upQuere.setDireccion(infoSecre[4]);
       
        qService.create(upQuere);
    
    }
}
