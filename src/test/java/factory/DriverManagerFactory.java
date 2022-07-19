package factory;

public class DriverManagerFactory {
    private DriverManagerFactory() {
    }

    public static DriverManager getManager(String driverType) {
        if (driverType.equals(BrowserType.CHROME)) {
            return new ChromeDriverManager();
        } else {
            return new FirefoxDriverManager();
        }
    }
}