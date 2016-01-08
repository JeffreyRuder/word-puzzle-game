public class LetterReplacer {

    public String letterReplace(String inputString) {
        String outputString = inputString.replaceAll("[aeiou]", "-");
        return outputString;
    }

}
