package factory;

public class DriverManagerFactory {

    private DriverManagerFactory() {
    }

    public static DriverManager getManager(DriverType driverType) {
        DriverManager driverManager;
        if (driverType == DriverType.CHROME) {
            driverManager = new ChromeDriverManager();
        } else {
            driverManager = new FirefoxDriverManager();
        }
        return driverManager;
    }
}