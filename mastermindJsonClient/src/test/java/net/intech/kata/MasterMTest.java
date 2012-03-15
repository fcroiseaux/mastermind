package net.intech.kata;

import org.junit.*;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: croiseaux
 * Date: 15/03/12
 * Time: 08:04
 * To change this template use File | Settings | File Templates.
 */
public class MasterMTest {

    @Test
    public void testUrl()
    {
        MasterM m = new MasterM("http://localhost:9000/check");
        String result = m.check(new LinkedList<String>());

        System.out.println(result);
        assertTrue( result.length() > 0);
    }
}
