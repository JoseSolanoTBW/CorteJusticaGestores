package Logic;

import Business.Caso.Caso;
import Business.Caso.Estado;
import Business.Persona.Juez;
import Business.Persona.Querellante;
import data.CasosService;
import data.JuezServices;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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

    public ArrayList<String[]> getCasosNull() throws IOException, SQLException {
        ArrayList<Caso> listCa = casosService.getCasosNull();
        ArrayList<String[]> strlistCa = new ArrayList<>();
        String[] cas;
        for (Caso ca : listCa) {
            cas = new String[5];
            cas[0] = ca.getNumeroCaso() + "";
            cas[1] = ca.getDescripcion();
            cas[2] = ca.getFechaCfeacion().toString();
            cas[3] = ca.getDenunciante().getNombre();
            cas[4] = ca.getEstadoCaso().getNombre();
            strlistCa.add(cas);
        }
        return strlistCa;

    }

    public void createCaso(int id, String desc) throws IOException, SQLException {
        JuezServices js = new JuezServices();
        Juez ju = new  Juez();
        ju.setNumeroJuez(js.getRandomJuez());
        Caso cas = new Caso();
        Querellante qr= new Querellante();
        Estado est = new Estado();
        est.setIdEstado(1);
        
        qr.setIdPersona(id);
        cas.setDenunciante(qr);
        cas.setDescripcion(desc);
        cas.setFechaCfeacion(new Date());
        cas.setEstadoCaso(est);
        cas.setJuezAsignado(ju);
        
        casosService.create(cas);
        
    }

}
