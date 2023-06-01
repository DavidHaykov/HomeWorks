import java.io.*;

public class DataStreamAppl {
    static final String FILE_NAME = "invoice.data";
    static final String[] GOODS = {"meat", "milk", "choko", "bread", "juice"};
    static final int[] COUNTS = {12,8,13,1,3};
    static final double[] PRICES = {69.9, 12.3, 22.5, 16, 5.9};


    public static void main(String[] args) throws FileNotFoundException {
        try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME)))){
            for(int i = 0; i < PRICES.length; i++){
                out.writeUTF(GOODS[i]);
                out.writeInt(COUNTS[i]);
                out.writeDouble(PRICES[i]);

            }

        }
        catch (Exception e){

        }
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)));
        String good;
        int count;
        double price;
        double totalCost = 0;
        try {
            while(true){
                good = in.readUTF();
                count = in.readInt();
                price = in.readDouble();
                System.out.printf("You ordered %d units of %s at %.2f\n", count, good, price);
                totalCost += count * price;
            }
        } catch (IOException e){

        }
        System.out.println("Total sum is $" + totalCost);
    }
}
