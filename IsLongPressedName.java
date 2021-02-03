public class IsLongPressedName {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));
    }
    public static boolean isLongPressedName(String name, String typed) {
        if(name.charAt(0) != typed.charAt(0)){
            return false;
        }
        int n = 1;
        int t = 1;
        while(n<name.length() && t<typed.length()){
            if(name.charAt(n) != typed.charAt(t)){
                while (t<typed.length() && typed.charAt(t)==name.charAt(n-1)){
                    t++;
                }
                if(t<typed.length() && typed.charAt(t) != name.charAt(n)){
                    return false;
                }
            }
            n++;
            t++;
        }
        if(n==name.length() && t<typed.length()) {
            while (t < typed.length()){
                if(name.charAt(n-1) != typed.charAt(t)){
                    return false;
                }
                t++;
            }
        }
        return n==name.length() && t==typed.length();
    }
}
