import org.junit.jupiter.api.Test;
import telran.net.TcpClientJava;

import static org.junit.jupiter.api.Assertions.*;

class TestServerApplTest extends TcpClientJava {
    public TestServerApplTest(String hostName, int port) throws Exception {
        super("Local host", 2000);
    }

    @Test
    void testLength(){
        String str = "12345";
        int length = sendRequest("length", str);
        assertEquals(5, length);
    }


}