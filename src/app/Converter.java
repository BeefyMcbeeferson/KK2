package app;

import java.util.HashMap;
import java.util.Map;

public class Converter extends Alphabet {
    StringBuilder sb = new StringBuilder();

    public String morseToEnglish(String morseCodeInput) {
        Map<String, Character> alphabet;
        alphabet = mappedMorse(morse, lettAndNum);

        System.out.print("Morse code " + morseCodeInput
                + " to English --> ");

        String[] whiteSpace = morseCodeInput.split(" ");
        for (int i = 0; i < whiteSpace.length; i++) {
            if (whiteSpace[i].equals(";")) {
                sb.append(" ");
            } else {
                if (whiteSpace[i].contains(";")) {
                    System.out.println("Remember to put whitespace before and after ; please try again");
                    break;
                }
                sb.append(alphabet.get(whiteSpace[i]));
            }
        }
        String conversionResult = sb.toString();
        return conversionResult;
    }

    public String englishToMorse(String englishLang) {
        Map<String, Character> alphabet;
        alphabet = mappedMorse(morse, lettAndNum);

        System.out.print("English " + englishLang
                + " to morse code --> ");
        String lowerCaseSaftey = englishLang.toLowerCase();

        for (int i = 0; i < lowerCaseSaftey.length(); i++) {
            if (lowerCaseSaftey.contains("å") || lowerCaseSaftey.contains("ä") || lowerCaseSaftey.contains("ö")) {
                System.out.println("åäö not valid, please stick to english");
                break;
            }
            Character temp = lowerCaseSaftey.charAt(i);
            if (temp.isWhitespace(temp)) {
                sb.append(" ; ");
            }
            for (Map.Entry<String, Character> entry : alphabet.entrySet()) { //Loopar igenom hashmap och tar ut key value pair
                if (entry.getValue().equals(temp)) {
                    sb.append(entry.getKey() + " ");
                }
            }
        }
        String conversionResult = sb.toString();
        return conversionResult;
    }

    private static Map mappedMorse(String[] key, char[] value) {
        Map<String, Character> mappedMorseAndEnglish = new HashMap<>();
        for (int i = 0; i < 39; i++) {
            mappedMorseAndEnglish.put(key[i], value[i]);
        }
        return mappedMorseAndEnglish; //Denna metoden för att undvika upprepning så skapar den en hashmap åt mig och fyller den med alfabetet
    }
}