package org.example;

import java.util.HashMap;
import java.util.function.BinaryOperator;
import java.util.Map;

public class Calculator
{
	//	Write a map based calculator application, where you will have an operator as a key, and a functional interface as a
//	value, where you will pass the corresponding arithmetic operation. Take the Calculator from the lesson 8 as a basis.
//
	static Map<String,BinaryOperator<Integer>> mapOperations;
	static {
		BinaryOperator<Integer> multiply = (x, y) -> x*y;
		BinaryOperator<Integer> plus = Integer::sum;
		BinaryOperator<Integer> divide = (x, y) -> x/y;
		BinaryOperator<Integer> minus = (x, y) -> x-y;


		mapOperations=new HashMap<>();
		mapOperations.put("+", plus);
		mapOperations.put("*", multiply);
		mapOperations.put("-", minus);
		mapOperations.put("/", divide);
	}

	public static Integer computeExpression(String string)
	{
		if(!isArithmeticExpression(string))
			return null;

		string = string.trim();

		String[] operands = getOperands(string);
		String[] operators = getOperators(string);
		Integer res = Integer.parseInt(operands[0]);
		for(int i=1; i<operands.length; i++)
		{
			res = computeOne(res, operands[i], operators[i]);
		}
		return res;
	}
	private static Integer computeOne(Integer res, String operand, String operator)
	{
		Integer number = Integer.parseInt(operand);

		res = mapOperations.get(operator).apply(res, number);

		return res;

	}
	private  static boolean isArithmeticExpression(String string)
	{
		return string.matches("\\s*\\d+(\\s*[*+/-]\\s*\\d+)*\\s*");
	}



	private static String[] getOperators(String string)//"1+1+1"
	{
		return string.split("[\\s\\d]+");
	}

	private static String[] getOperands(String string)
	{
		return string.split("\\D+");
	}

}
