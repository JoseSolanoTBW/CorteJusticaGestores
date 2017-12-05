/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;
import Logic.GestorCasos;
import Services.CasosService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
 import static org.junit.Assert.assertEquals;
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
    
    @Parameters
    public static ArrayList<String[]> jueces(){
    ArrayList<String[]> ju = new ArrayList<>();
    return ju;
    }
    
    
    @Test
    public void testCasosQuere() throws IOException, SQLException{
//        GestorCasos gc = new GestorCasos();
//        assertEquals(jueces(), gc.getQuerellantes(1));
          fail("not");
            
    
    }
    
}
