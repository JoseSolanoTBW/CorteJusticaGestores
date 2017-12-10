/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Logic.GestorQuerellante;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 *
 * @author mean
 */
public class TestQuerellante {
    private GestorQuerellante gq = new GestorQuerellante();
    @Test
    public void testQuerellantes() throws IOException, SQLException{
    String[] testQuere = {"3","158960356","Fernando","Monto","22520236","Heredia"};
    String[] quere = gq.getQuerellantes().get(0);
    assertArrayEquals(testQuere, quere);
       
    
    }
    
    @Test
    public void testQuerellante() throws IOException, SQLException{
    String[] testQuere = {"3","158960356","Fernando","Monto","22520236","Heredia"};
    String[] quere = gq.getQuerellante(3);
    assertArrayEquals(testQuere, quere);
    }
}
