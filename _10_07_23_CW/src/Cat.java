public class Cat implements Runnable{

    String name;
    char gender;
    int nMyau;

    public Cat(String name, char gender, int nMyau) {
        this.name = name;
        this.gender = gender;
        this.nMyau = nMyau;
    }

    @Override
    public void run() {
        for(int i = 0; i < nMyau ; i++){
            if(gender == 'm'){
                System.out.println("Cat "+ name + " say myau");
            }else{
                System.out.println("Pussy cat "+ name + " say myau");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
