/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Business.Corte.Sala;
import data.SalaService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mean
 */
public class GestorSala {
    
    SalaService salService = new SalaService();
    public ArrayList<String[]> getSalas() throws IOException, SQLException{
    ArrayList<Sala> lisSala = salService.getSalas();
    ArrayList<String[]>strList = new ArrayList<>();
        for (Sala sala : lisSala) {
            String[] strsala = new String[2];
            strsala[0] = sala.getNumeroSala()+"";
            strsala[1] = sala.getNombreSala();
            strList.add(strsala);
            
        }
    return strList;
    }
}
