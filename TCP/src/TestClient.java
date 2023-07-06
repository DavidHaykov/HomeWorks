import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.net.TcpClientJava;

class TestClient extends TcpClientJava
{

	public TestClient() throws Exception
	{
		super("localhost", 2000);
	}

	@Test
	void testLength() throws IOException
	{
		String str = "12345";
		int length = sendRequest("length", str);
		assertEquals(5, length);
		String res = sendRequest("reverse", str);
		assertEquals("54321", res);
		close();
	}
}
