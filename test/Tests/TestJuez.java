/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Logic.GestorJuez;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
 import static org.junit.Assert.assertEquals;
/**
 *
 * @author mean
 */
public class TestJuez {
    private GestorJuez gj = new GestorJuez();
    @Test
    public void testJueces() throws IOException, SQLException{
    String[] testJuez = {"1","117040156","Jose Solano","20","Sala Cuarta","JoseSolano","1"};
    String[] juez = gj.getJueces().get(0);
        assertArrayEquals(testJuez,juez);
    }
    
    @Test 
    public void testJuez() throws SQLException, IOException{
     String[] testJuez = {"1","Jose","117040156", "Solano","88659823","Hatillo Centro","JoseSolano","Sala Cuarta","20"};
     String[] juez = gj.getJuez(1);
     assertArrayEquals(testJuez,juez);
 
    }
}
