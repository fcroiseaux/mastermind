package net.intech.kata;

import org.junit.*;
import java.util.List;

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
    public void testCombi1()
    {
        MasterM m = new MasterM("http://localhost:9000/check");
		List<String> myCode=new LinkedList<String>();
		myCode.add("J");
		myCode.add("R");
		myCode.add("B");
		myCode.add("R");
        MasterM.Result result = m.check(myCode);

        assertTrue( result.noir==2);
        assertTrue( result.blanc==1);
    }

    @Test
    public void testCombi2()
    {
        MasterM m = new MasterM("http://localhost:9000/check");
        List<String> myCode=new LinkedList<String>();
        myCode.add("J");
        myCode.add("M");
        myCode.add("B");
        myCode.add("R");
        MasterM.Result result = m.check(myCode);

        assertTrue( result.noir==1);
        assertTrue( result.blanc==2);
    }

}
