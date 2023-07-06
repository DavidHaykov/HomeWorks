package view;

import java.io.IOException;

public interface Item
{
	String displayedName();
	void perform() throws IOException;
	default boolean isExit()
	{
		return false;
	}
}
