package Logic;

import Business.Caso.Caso;
import Business.Caso.DetalleHistorial;
import Business.Caso.Estado;
import Business.Persona.Juez;
import Business.Persona.Querellante;
import Services.CasosService;
import Services.JuezServices;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

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

    public ArrayList<String[]> getCasosByJuez(int id) throws IOException, SQLException {

        ArrayList<Caso> listQuere = casosService.getCasosPorJuez(id);
        ArrayList<String[]> casesResult = new ArrayList<>();
        String[] casosInfo;
        for (Caso quere : listQuere) {
            casosInfo = new String[5];
            casosInfo[0] = quere.getNumeroCaso() + "";
            casosInfo[1] = quere.getDescripcion() + "";
            casosInfo[2] = quere.getFechaCfeacion().toString();
            casosInfo[3] = quere.getDenunciante().getNombre() + " " + quere.getDenunciante().getApellido();
            casosInfo[4] = quere.getEstadoCaso().getNombre();
            casesResult.add(casosInfo);
        }
        return casesResult;
    }

    public  List getCheckBox(String CurrentStatus, String casoId)
    {
         List result = new ArrayList<String>();
        switch(CurrentStatus)
        {
            case "Recibido":
                result.add("Recibido");               
                result.add("Aceptado");
                result.add("Rechazado");
            break;
            case "Consulta":
                result.add("Aceptado");
                result.add("Consulta");
                result.add("Rechazado");
            break;
            case "Aceptado":
                result.add("Aceptado");
                result.add("Redactado");
            break;
            case "Redactado":
                result.add("Redactado");
                result.add("Revisión");
                result.add("Resuelto");
            break;
            case "Revisión":
                result.add("Redactado");
                result.add("Revisión");
            break;
            default:
                result.add(CurrentStatus);
            break;
        }
        return result;
    }

    public void updateEstadoCaso(String idCaso, String estado) throws SQLException, IOException
    {
        int nuevoEstdo = 1;

        switch(estado)
        {
            case "Recibido":
                nuevoEstdo = 1;
            break;
            case "Consulta":
                nuevoEstdo = 2;
            break;
            case "Aceptado":
                nuevoEstdo = 3;
            break;
            case "Redactado":
                nuevoEstdo = 4;
            break;
            case "Revisión":
                nuevoEstdo = 5;
            break;
            case "Resuelto":
                nuevoEstdo = 6;
            break;
            case "Rechazado":
                nuevoEstdo = 7;
            break;
        }
        casosService.actualizarEstado(Integer.parseInt(idCaso), nuevoEstdo);
        casosService.createHistorial(nuevoEstdo, Integer.parseInt(idCaso));
    }
     public String[] getCaso(int id) throws IOException, SQLException {
         Caso quere = casosService.getCasos(id);
        String[] casosInfo;
       
            casosInfo = new String[5];
            casosInfo[0] = quere.getNumeroCaso() + "";
            casosInfo[1] = quere.getDescripcion() + "";
            casosInfo[2] = quere.getFechaCfeacion().toString();
            casosInfo[3] = quere.getDenunciante().getNombre() + " " + quere.getDenunciante().getApellido();
            casosInfo[4] = quere.getEstadoCaso().getNombre();
       
        return casosInfo;
    }
     
     public ArrayList<String[]> getHistorialCaso(int id) throws IOException, SQLException 
     {
        ArrayList<DetalleHistorial> listQuere = casosService.getCasoId(id);
        ArrayList<String[]> casesResult = new ArrayList<>();
        String[] casosInfo;
        for (DetalleHistorial detalle : listQuere) {
            casosInfo = new String[2];
            casosInfo[0] = detalle.getFechaActualizacion() + "";
            casosInfo[1] = detalle.getEstadoHistorial().getNombre();
            casesResult.add(casosInfo);
        }
        return casesResult;
    }
     public void agregarSolucion(String idCaso, String text) throws IOException, SQLException
     {
         casosService.insertarResolucionCasoEstado(Integer.parseInt(idCaso), text);
     }
}
