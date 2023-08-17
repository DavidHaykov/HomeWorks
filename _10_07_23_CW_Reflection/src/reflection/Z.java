package reflection;

import reflection.X;

public class Z implements X {
    String str;

    public Z() {
    }

    public Z(String str) {
        this.str = str;
    }

    @Override
    public void action() {
        System.out.println("action from reflection.Z" + str);
    }
}
