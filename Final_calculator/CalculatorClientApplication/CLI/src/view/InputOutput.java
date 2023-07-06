package view;

import java.util.List;
import java.util.function.Function;

public interface InputOutput
{
	String inputString(String prompt);
	void output(Object obj);
	
	default void outputLine(Object obj)
	{
		output(obj.toString());
	}
	
	default <R> R inputObject(String prompt, String errorPrompt, 
			Function<String, R> mapper)
	{
		while(true)
		{
			String text = inputString(prompt);
			if(text == null)
				return null;
			
			R res = mapper.apply(text);
			if(res != null)
				return res;
			
			outputLine(errorPrompt);
		}
	}
	
	default Integer inputInteger(String prompt)
	{
		return inputObject(prompt, "It`s not integer number", s ->
		{
			try
			{
				Integer res = Integer.parseInt(s);
				return res;
			} catch (Exception e)
			{
				return null;
			}
		});
	}
	
	default Integer inputInteger(String prompt, Integer min, Integer max)
	{
		return inputObject(prompt, 
		String.format("It`s not integer number in range [%d-%d]", min, max), 
		s ->
		{
			try
			{
				Integer res = Integer.parseInt(s);
				return res >= min && res <= max ? res : null;
			} catch (Exception e)
			{
				return null;
			}
		});
	}
	
	default String inputString(String prompt, List<String> options)
	{
		return inputObject(prompt, "String is not in option", 
				s -> options.contains(s) ? s : null);
	}
	
}
