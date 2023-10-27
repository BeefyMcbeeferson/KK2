import app.Converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Converter converter = new Converter();

        System.out.println("Select translation method: ");
        System.out.println("1) Morse to English \n2) English to Morse \n3) Exit");
        System.out.print("Selection: ");

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\n"); //Scanner kollar ny rad som avskiljare

        switch (sc.nextInt()) {
            case 1:
                System.out.println("What do you want translated to english?");
                String morseToEnglish = sc.next();
                System.out.println(converter.morseToEnglish(morseToEnglish));
                break;
            case 2:
                System.out.println("What do you want translated to morse?");
                String englishToMorse = sc.next();
                System.out.println(converter.englishToMorse(englishToMorse));
                break;
            case 3:
                System.out.println("Done for the day");

        }
    }
}