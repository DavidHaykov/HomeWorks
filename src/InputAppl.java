import java.io.*;
import java.util.Arrays;

public class InputAppl
{

	public static void main(String[] args) throws IOException
	{
		InputStream in = new FileInputStream("hello.txt");
//		System.out.println(in.read());
//		int c;
//		while((c = in.read()) > 0)
//		{
//			System.out.printf("%c", c);
//		}
//		System.out.println();
//		System.out.println(in.read());
		
//		byte[] buffer = new byte[in.available()];
//		in.read(buffer);
//		System.out.println(new String(buffer));
		
		byte[] buffer = new byte[10];
		int countBytes = 0;
		String str = "";
		while((countBytes = in.read(buffer)) > 0)
		{
			System.out.println(countBytes);
			str += new String(Arrays.copyOf(buffer, countBytes));
//			str += new String(buffer);
			System.out.println(str);
		}
		in.close();
	}

}
