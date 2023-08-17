package reflection;

import reflection.X;

public class Y implements X {
    String str;

    public Y() {
    }

    public Y(String str) {
        this.str = str;
    }

    @Override
    public void action() {
        System.out.println("action from reflection.Y" + str);
    }
}
