/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;
import Logic.GestorCasos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
 import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
/**
 *
 * @author mean
 */
public class TestCasos {
    @Parameter(0)
    public int m1;
     private GestorCasos gc = new GestorCasos();
    
    public static boolean checkListBox(List lis){
        for (Object li : lis) {
            if(li != "Recibido" && li != "Aceptado" && li != "Rechazado"){
                return false;
            }
        }
        return true;
    }
    
    
    
    @Test
    public void testCheckbox() throws IOException, SQLException{
       
        List listCheck =gc.getCheckBox("Recibido","10");
        boolean result  = checkListBox(listCheck);
        assertTrue("Resultado",result);
    
    }
    
    @Test
    public void testCasosJuez() throws IOException, SQLException {
      
        String[]testCaso = {"14","Acoso","2017-12-04","Fer Campos", "Recibido"};
        String[] firstCaso = gc.getCasosByJuez(1).get(0);
        assertArrayEquals(testCaso, firstCaso);
        
    }
    @Test
    public void testCasosQuerellante() throws IOException, SQLException{
    String[] testCaso = {"14","Acoso","2017-12-04", "Recibido"};
    String[] firstCaso = gc.getQuerellantes(17).get(0);
    
     assertArrayEquals(testCaso, firstCaso);
    }
    
    @Test 
    public void testCaso() throws IOException, SQLException{
        String[] testCaso = {"11","Acoso","2017-12-04","Gabriel Valerio","Recibido",null};
        String [] caso = gc.getCaso(11);
         assertArrayEquals(testCaso, caso);
        
    
    }
    
    @Test
    public void testHistorialCaso() throws IOException, SQLException{
        String[] testHistorial = {"2017-12-04","Aceptado"};
        String[] historial = gc.getHistorialCaso(10).get(0);
        assertEquals(testHistorial, historial);
    
    }
    
}
