package pl.bykowski.pdt4th.converter;

public class StringConverter {
    public static String representativeMarkForm(String markToConvert) {
        StringBuilder sb = new StringBuilder();

        boolean isUpper = true;
        for (int i = 0; i < markToConvert.length(); i++) {
            if (isUpper) {
                sb.append(Character.toUpperCase(markToConvert.charAt(i)));
                isUpper = false;
                continue;
            } else if (Character.isSpaceChar(markToConvert.charAt(i))) {
                isUpper = true;
            }

            sb.append(Character.toLowerCase(markToConvert.charAt(i)));
        }

        return sb.toString();
    }
}
