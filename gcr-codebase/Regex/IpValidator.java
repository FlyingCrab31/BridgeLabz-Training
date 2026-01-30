
public class IpValidator {

    private static final String IP_REGEX
            = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"
            + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

    public static boolean isValidIp(String ip) {
        return ip != null && ip.matches(IP_REGEX);
    }

    public static void main(String[] args) {
        String[] tests = {
            "192.168.0.1",
            "255.255.255.255",
            "0.0.0.0",
            "256.1.1.1",
            "01.2.3.4",
            "192.168.1"
        };

        for (String ip : tests) {
            System.out.println(ip + " -> " + isValidIp(ip));
        }
    }
}
