public class LetterReplacer {

    public String letterReplace(String userInputString) {
        return userInputString.replaceAll("(?i)[aeiou]", "-").trim();
    }

}
