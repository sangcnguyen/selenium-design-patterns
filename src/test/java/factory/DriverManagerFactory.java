package factory;

public class DriverManagerFactory {
    private DriverManagerFactory() {
    }

    public static DriverManager getManager(String driverType) {
        DriverManager driverManager;
        if (driverType.contains(DriverType.getLocalChrome())) {
            driverManager = new ChromeDriverManager();
        } else {
            driverManager = new FirefoxDriverManager();
        }
        return driverManager;
    }
}