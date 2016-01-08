public class LetterReplacer {

    public String letterReplace(String inputString) {
        String vowelsReplaced = inputString.replaceAll("(?i)[aeiou]", "-").trim();
        return vowelsReplaced;
    }

}
