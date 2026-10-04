public class SubstringGenerator {

    public static void generate(String word) {

        // Base case
        if (word.isEmpty()) {
            System.out.println("\"\"");
            return;
        }

        // Print substrings beginning at index 0
        for (int i = 1; i <= word.length(); i++) {
            System.out.println(
                    word.substring(0, i)
            );
        }

        // Recursive call with first character removed
        generate(word.substring(1));
    }
}