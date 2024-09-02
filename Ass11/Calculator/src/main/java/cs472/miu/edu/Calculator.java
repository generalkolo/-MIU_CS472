package cs472.miu.edu;

public class Calculator {

    public static String sum(String x, String y) {
        if(x.equals("") || y.equals("")) return "";
        return String.valueOf(Integer.parseInt(x) + Integer.parseInt(y));
    }

    public static String multiply(String x, String y) {
        if(x.equals("") || y.equals("")) return "";
        return String.valueOf(Integer.parseInt(x) * Integer.parseInt(y));
    }

}
