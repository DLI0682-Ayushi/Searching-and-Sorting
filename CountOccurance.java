public class CountOccurance {
    public static int countOccurrences(String input, char targetChar) {
        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == targetChar) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String myString = "Hello, world!";
        char targetCharacter = 'o';

        int occurrences = countOccurrences(myString, targetCharacter);

        System.out.println("The character '" + targetCharacter + "' appears " + occurrences + " times in the string.");
    }
}

