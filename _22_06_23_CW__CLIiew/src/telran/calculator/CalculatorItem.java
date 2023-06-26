package telran.calculator;

import org.junit.jupiter.api.Test;
import telran.view.InputOutput;
import telran.view.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class CalculatorItem implements Item {
    @Override
    public String displayedName() {
        return "Integer numbers calculator";
    }

    @Override
    public void perform() {
        Integer op1 = inOut.inputInteger("Enter first operand");
        if(op1 == null){
            return;
        }
        Integer op2 = inOut.inputInteger("Enter second operand");
        if(op2 == null){
            return;
        }
        String operator = inOut.inputString("Enter operator from " + mapOperations.keySet(), new ArrayList<>(mapOperations.keySet()));
        if(operator == null){
            return;
        }
        inOut.outputLine(mapOperations.get(operator).apply(op1, op2));
    }


    InputOutput inOut;

    public CalculatorItem(InputOutput inOut) {
        this.inOut = inOut;
    }

    static Map<String, BinaryOperator<Integer>> mapOperations;
    static
    {
        mapOperations = new HashMap<>();
        mapOperations.put("+", (o1, o2) -> o1 + o2);
        mapOperations.put("*", (o1, o2) -> o1 * o2);
        mapOperations.put("-", (o1, o2) -> o1 - o2);
        mapOperations.put("/", (o1, o2) -> o2 == 0 ? null : o1 / o2);
    }
}
