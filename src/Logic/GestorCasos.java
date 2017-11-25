package Logic;

import Business.Caso.Caso;
import data.CasosService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorCasos {

    CasosService casosService = new CasosService();
    public ArrayList<String[]> getQuerellantes(int id) throws IOException, SQLException {
       
        ArrayList<Caso> listQuere = casosService.getCasosPorQuerellante(id);
        ArrayList<String[]> casesResult = new ArrayList<>();
        String[] casosInfo;
            for (Caso quere : listQuere) {
                casosInfo = new String[4];
                casosInfo[0] = quere.getNumeroCaso() + "";
                casosInfo[1] = quere.getDescripcion() + "";
                casosInfo[2] = quere.getFechaCfeacion().toString();
                casosInfo[3] = quere.getEstadoCaso().getNombre();
                casesResult.add(casosInfo);
            }
        return casesResult;
    }

}
