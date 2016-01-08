public class LetterReplacer {

    public String letterReplace(String inputString) {
        String outputString = inputString.replaceAll("(?i)[aeiou]", "-");
        return outputString;
    }

}
