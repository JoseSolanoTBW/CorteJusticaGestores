/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Logic.GestorSecretario;
import java.io.IOException;
import java.sql.SQLException;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 *
 * @author mean
 */
public class TestSecretario {
    private GestorSecretario gs = new GestorSecretario();
    
    @Test
    public void testSecretarios() throws IOException, SQLException{
    String[] testSecretario ={"2","302450025","Adrian","Obando","84793258","Aserri","AdrianLeiton","2"};
    String[] secretario = gs.getSecretarios().get(0);
    assertArrayEquals(testSecretario,secretario);
    }
    @Test
    public void testSecretario() throws IOException, SQLException{
      String[] testSecretario ={"2","302450025","Adrian","Obando","84793258","Aserri","AdrianLeiton","2"};
    String[] secretario = gs.getSecretario(2);
    assertArrayEquals(testSecretario,secretario);
    }
    
}
