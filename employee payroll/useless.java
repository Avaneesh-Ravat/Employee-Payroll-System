public class useless {
    public static String shortestBeautifulSubstring(String s, int k) {
        String s1 = "";
        boolean f = false;

        for (int i = 0; i < s.length(); i++) {
            int j, c = 0;
            for (j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    c++;
                    if (c == k) {
                        f = true;
                        String s2 = s.substring(i, j + 1);
                        if (s1.isEmpty() || s2.compareTo(s1) > 0) {
                            s1 = s2;
                        }
                        break;
                    }
                }
            }
        }

        if (f) {
            return s1;
        } else {
            return "";
        }
    }
    public static void main(String[] args){

        System.out.println(shortestBeautifulSubstring("11000111", 1));
    }
    
}
