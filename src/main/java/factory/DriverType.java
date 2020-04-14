package factory;

public class DriverType {
    private DriverType() {
    }

    private static ThreadLocal<String> localChrome = new ThreadLocal<>();
    private static ThreadLocal<String> localFirefox = new ThreadLocal<>();

    public static String getLocalChrome() {
        localChrome.set("chrome");
        return localChrome.get();
    }

    public static String getLocalFirefox() {
        localFirefox.set("firefox");
        return localFirefox.get();
    }

    public static void cleanUp() {
        localChrome.remove();
        localFirefox.remove();
    }
}