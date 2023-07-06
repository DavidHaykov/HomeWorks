package telran;


import net.RequestJava;
import net.ResponseJava;
import net.TcpResponseCode;
import net.server.ProtocolJava;

public class ProtocolCalculator implements ProtocolJava {
    @Override
    public ResponseJava getResponse(RequestJava request) {
        String type = request.requestType;
        int[] data = (int[]) request.requestData;
        switch (type){
            case "+":
                return new ResponseJava(TcpResponseCode.OK, data[0]+data[1]);
            case "-":
                return new ResponseJava(TcpResponseCode.OK, data[0]-data[1]);
            case "*":
                return new ResponseJava(TcpResponseCode.OK, data[0]*data[1]);
            case "/":
                if(data[1] == 0){
                    return new ResponseJava(TcpResponseCode.WRONG_REQUEST, null);
                }
                return new ResponseJava(TcpResponseCode.OK, (int)(data[0]/data[1]));
            default: return new ResponseJava(TcpResponseCode.UNKNOWN, null);
        }

    }


}
