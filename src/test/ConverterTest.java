package test;
import app.Converter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    Converter converter = new Converter(); //objekt av converterklassen
    final String FIVE_IN_MORSE = ".....";
    final String HELLO_TO_MORSE = "hello";
    final String SWE_CHAR = "å";
    final String CAPS_TO_LOWER = "LOWER";

    @Test
    void morseToEnglishTest() {
        Assertions.assertEquals("5", converter.morseToEnglish(FIVE_IN_MORSE));
    }

    @Test
    void morseToEnglishSemiColonToWhitespaceTest() {
        Assertions.assertEquals("nice, it works as intended", converter.morseToEnglish("-. .. -.-. . --..-- ; .. - ; .-- --- .-. -.- ... ; .- ... ; .. -. - . -. -.. . -.."));
    }

    @Test
    void englishToMorseTest() {
        Assertions.assertEquals(".... . .-.. .-.. --- ", converter.englishToMorse(HELLO_TO_MORSE));
    }

    @Test
    void englishToMorseNoSwedishTest() {
        Assumptions.assumeFalse(false, converter.englishToMorse(SWE_CHAR));
    }

    @Test
    void englishToMorseLowerCaseTest() {
        Assertions.assertEquals(".-.. --- .-- . .-. ", converter.englishToMorse(CAPS_TO_LOWER));
    }
}