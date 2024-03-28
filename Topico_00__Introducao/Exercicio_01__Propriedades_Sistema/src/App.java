public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nHi!");
        String[] systemProperties = {
            "Java Version", "Java Class Path", "Java Home", "Java Vendor", "Java Vendor URL",
            "File Separator", "Line Separator", "Path Separator",
            "OS Arch", "OS Name", "OS Version",
            "User Dir", "User Home", "User Name"
        };
        for (String property : systemProperties) {
            String systemProperty = property.toLowerCase().replace(" ", ".");
            String output = System.getProperty(systemProperty);
            System.out.printf("%s: %s\n", property, output);
        }
    }
}
