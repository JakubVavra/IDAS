package utils;

/**
 *
 * @author jakubvavra
 */
public class UserType {
    public static String userTypeToString(String e) {
        switch (e) {
            case "admin":
                return "Administrátor";
            case "user":
                return "Zaměstnanec";
            default:
                return "Nepřihlášený uživatel";
        }
    }
}
