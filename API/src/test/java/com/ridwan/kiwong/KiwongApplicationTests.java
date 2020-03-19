package com.ridwan.kiwong;


import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class KiwongApplicationTests extends TestCase{
  /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public KiwongApplicationTests( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static junit.framework.Test suite()
    {
        return new TestSuite( KiwongApplicationTests.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

}
