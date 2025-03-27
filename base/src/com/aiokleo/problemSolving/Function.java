public class Function {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(returnsSomeInteger());

    }

    public static Integer returnsSomeInteger() {
        int x = 1000;
        for (int i = 0; i < 10; i++) {
            if (i == 2) {
                continue ;
            }
            System.out.println(i);
        }
        return x;
    }
}
