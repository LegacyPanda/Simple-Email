package legecy.panda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Simple Email Client
 */
class AppTest 
{
    @Test
    @DisplayName("Basic sanity test")
    void testApp() 
    {
        assertTrue(true, "This should always pass");
    }
    
    @Test
    @DisplayName("Verify Main class exists")
    void testMainClassExists() 
    {
        assertDoesNotThrow(() -> 
        {
            Class.forName("legecy.panda.Main");
        }, "Main class should exist");
    }
    
    @Test
    @DisplayName("Verify Display class exists")
    void testDisplayClassExists() 
    {
        assertDoesNotThrow(() -> 
        {
            Class.forName("legecy.panda.Email.Display");
        }, "Display class should exist");
    }
    
    @Test
    @DisplayName("Verify SMTP class exists")
    void testSMTPClassExists() 
    {
        assertDoesNotThrow(() -> 
        {
            Class.forName("legecy.panda.Email.SMTP");
        }, "SMTP class should exist");
    }
}