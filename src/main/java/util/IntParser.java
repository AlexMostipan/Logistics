package util;

public class IntParser {
    public static int Parse(String src){
      StringBuilder builder = new StringBuilder();
        for (int i = 0; i <src.length() ; i++) {
            char c = src.charAt(i);
            if(Character.isDigit(c)){
                builder.append(c);
            }
        }
        return Integer.parseInt(builder.toString());
    }
}
