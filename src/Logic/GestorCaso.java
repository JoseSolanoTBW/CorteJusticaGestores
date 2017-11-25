/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Business.Caso.Caso;
import data.CasoService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mean
 */
public class GestorCaso {
    CasoService cS = new CasoService();
    
    public ArrayList<String[]> getCasosNull() throws IOException, SQLException{
        ArrayList<Caso> listCa = cS.getCasosNull();
        ArrayList<String[]>strlistCa = new ArrayList<>();
        String[] cas;
        for (Caso ca : listCa) {
            cas = new String[5];
            cas[0] = ca.getNumeroCaso()+"";
            cas[1] = ca.getDescripcion();
            cas[2] = ca.getFechaCfeacion().toString();
            cas[3] = ca.getDenunciante().getNombre();
            cas[4] = ca.getEstadoCaso().getNombre();
            strlistCa.add(cas);
        }
        return strlistCa;
                
    }
}
