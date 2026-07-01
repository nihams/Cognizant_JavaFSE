public class SingletonTest {

    public static void main(String[] args) {

        System.out.println("Singleton Pattern Test\n");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        logger1.log("Application started.");
        logger2.warn("Low memory warning.");
        logger3.error("Null pointer encountered.");

        System.out.println();

        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("logger2 == logger3 : " + (logger2 == logger3));
        System.out.println("logger1 == logger3 : " + (logger1 == logger3));

        System.out.println();

        System.out.println("HashCode of logger1: " + logger1.hashCode());
        System.out.println("HashCode of logger2: " + logger2.hashCode());
        System.out.println("HashCode of logger3: " + logger3.hashCode());

        System.out.println("\nConclusion: All three variables point to the same Logger instance.");
    }
}
