package practiceProblems;

import java.security.KeyStore.Entry;
import java.util.HashMap;

public class RepeatingCharacters {
    public static void main(String[] args) {
        String sentence = "This is a big world";
        HashMap<Character, Integer> countByCharacter = new HashMap<>();
        for (char Individualchar : sentence.replace(" ", "").toLowerCase().toCharArray()) {
            countByCharacter.put(Individualchar,
                    (countByCharacter.get(Individualchar) != null ? countByCharacter.get(Individualchar) : 0) + 1);
            /*
             * if (countByCharacter.get(Individualchar) == null) {
             * countByCharacter.put(Individualchar, 1);
             * } else {
             * countByCharacter.put(Individualchar, countByCharacter.get(Individualchar) +
             * 1);
             * }
             */
        }
        for (HashMap.Entry<Character, Integer> string : countByCharacter.entrySet()) {
            System.out.println(string.getKey());
        }
        System.out.println(countByCharacter);
    }
}
