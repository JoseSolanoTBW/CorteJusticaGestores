/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Business.Persona.Juez;
import data.JuezServices;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

/**
 *
 * @author mean
 */
public class GestorJuez {
    
    JuezServices juezService = new JuezServices();
   
    
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
    
}
