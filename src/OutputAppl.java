import java.io.*;

public class OutputAppl
{

	public static void main(String[] args) throws IOException
	{
		OutputStream out = new FileOutputStream("hello.txt", true);
		BufferedOutputStream buf = new BufferedOutputStream(out);
		File file = new File("hello1.txt");
		OutputStream out1 = new FileOutputStream(file);
		
		String text = "Hello world";
		byte[] array = text.getBytes();
		out.write(array);
		
		out.close();
		out1.close();
	}

}
