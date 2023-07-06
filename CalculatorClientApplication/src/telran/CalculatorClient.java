package telran;


import net.TcpClientJava;
import view.ConsoleInputOutput;
import view.InputOutput;

import java.util.ArrayList;
import java.util.List;

public class CalculatorClient extends TcpClientJava {
    protected InputOutput inOut = new ConsoleInputOutput();
    protected List<String> operators = new ArrayList<>();
    public CalculatorClient(String hostname, int port) throws Exception {
        super(hostname, port);
        operators.add("-");
        operators.add("+");
        operators.add("*");
        operators.add("/");
    }
    public void calculate(){
        try {
            Integer n1 = inOut.inputInteger("Enter the first operand");
            if(n1 == null){
                return;
            }
            Integer n2 = inOut.inputInteger("Enter the second operand");
            if(n2 == null){
                return;
            }
            String operation = inOut.inputString("Enter the operator from" + operators, operators);
            if(operation == null){
                return;
            }
            int[] operands = {n1, n2};
            int res = sendRequest(operation, operands);
            System.out.println(res);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
