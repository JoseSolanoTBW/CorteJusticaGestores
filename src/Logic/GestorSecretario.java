/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Business.Persona.Secretario;
import Business.Persona.Usuario;
import data.SecretarioServices;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mean
 */
public class GestorSecretario {

    SecretarioServices sSecre = new SecretarioServices();

    public ArrayList<String[]> getSecretarios() throws IOException, SQLException {
        ArrayList<Secretario> listSecre = sSecre.getSecretarios();
        ArrayList<String[]> strlistSecre = new ArrayList<>();
        String[] strSecretario;
        for (Secretario secretari : listSecre) {
            strSecretario = new String[8];
            strSecretario[0] = secretari.getIdPersona() + "";
            strSecretario[1] = secretari.getCedula() + "";
            strSecretario[2] = secretari.getNombre();
            strSecretario[3] = secretari.getApellido();
            strSecretario[4] = secretari.getTelefono() + "";
            strSecretario[5] = secretari.getDireccion();
            strSecretario[6] = secretari.getLoginUsuario().getNombreUsuario();
            strSecretario[7] = secretari.getLoginUsuario().getIdUsuario() + "";
            strlistSecre.add(strSecretario);
        }

        return strlistSecre;
    }

    public String[] getSecretario(int id) throws IOException, SQLException {
        Secretario secre = sSecre.get(id);
        String[] strSecre = new String[8];
        strSecre[0] = secre.getIdPersona() + "";
        strSecre[1] = secre.getCedula() + "";
        strSecre[2] = secre.getNombre();
        strSecre[3] = secre.getApellido();
        strSecre[4] = secre.getTelefono() + "";
        strSecre[5] = secre.getDireccion();
        strSecre[6] = secre.getLoginUsuario().getNombreUsuario();
        strSecre[7] = secre.getLoginUsuario().getIdUsuario() + "";
        
        return strSecre;
    }
    
    public void update(String[]infoSecre) throws SQLException, IOException{
        Secretario upSecre = new Secretario();
        Usuario usu = new Usuario();
        usu.setNombreUsuario(infoSecre[6]);
        upSecre.setIdPersona(Integer.parseInt(infoSecre[0]));
        upSecre.setNombre(infoSecre[1]);
        upSecre.setApellido(infoSecre[2]);
        upSecre.setTelefono(Integer.parseInt(infoSecre[3]));
        upSecre.setCedula(Integer.parseInt(infoSecre[4]));
        upSecre.setDireccion(infoSecre[5]);
        upSecre.setLoginUsuario(usu);
        
        sSecre.update(upSecre); 
        
    }
    
    public void delete(int id) throws SQLException, IOException{
        sSecre.delete(id);
    }
    
    public void create(String[] infoSecre){
    Secretario upSecre = new Secretario();
        Usuario usu = new Usuario();
        usu.setNombreUsuario(infoSecre[5]);
        
        upSecre.setNombre(infoSecre[0]);
        upSecre.setApellido(infoSecre[1]);
        upSecre.setTelefono(Integer.parseInt(infoSecre[2]));
        upSecre.setCedula(Integer.parseInt(infoSecre[3]));
        upSecre.setDireccion(infoSecre[4]);
        upSecre.setLoginUsuario(usu);
    
    }
}
