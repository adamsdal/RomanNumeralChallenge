import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class RomanNumeralsMain {

    static RomanNumeralConverter converter = new RomanNumeralConverter();

    public static void main(String[] args) {

        Boolean usingConverter = true;
        while (usingConverter) {
            String conversionChosen = null;
            //see if the user would like to convert numerals to a number or a numer to numerals
            Boolean choosingConversion = true;
            while (choosingConversion) {
                System.out.println("Choose which option you would like to do:  (please enter \"1\" or \"2\" or \"q\" to quit)\n" +
                        "1. Enter Roman Numerals to be converted to a number\n" +
                        "2. Enter a number to return the Roman Numeral equivalent");

                // Get the users input
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String userProgramChoice = null;
                try {
                    userProgramChoice = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error reading input");
                    return; //don't continue with the rest of the program if we don't have data
                }

                if (userProgramChoice.equals("1") || userProgramChoice.equals("2") || userProgramChoice.equals("q")) {
                    choosingConversion = false;
                    conversionChosen = userProgramChoice;
                }
                else {
                    System.out.println("Invalid entry, please try again\n");
                }
            }


            if (conversionChosen.equals("1")) {
                //convert roman numerals to an integer

                //ask the user to input the roman numerals to be converted
                System.out.println("Please enter the Roman Numerals you would like to translate, then press Enter.\n" +
                        "You can also enter \"q\" to quit");

                // Get the users input roman numerals
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String userInputNumerals = null;
                try {
                    userInputNumerals = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error reading input");
                    return; //don't continue with the rest of the program if we don't have data
                }

                if (userInputNumerals.equals("q")) {
                    usingConverter = false;
                    System.out.println("Goodbye");
                    break;
                }

                //give the user input to the converter to validate and convert the string
                Integer valueOfNumerals = converter.numeralsToInt(userInputNumerals);
                if (valueOfNumerals == converter.INVALID_GIVEN_STRING_VALUE) {
                    //the user input was invalid
                    System.out.println("The given input was not valid, please only use " + converter.ALLOWED_NUMERALS + " for your numerals");
                    choosingConversion = true;
                    continue;
                } else {
                    //the given input was valid, display the translated value
                    System.out.println("These roman numerals are equivalent to " + valueOfNumerals.toString());
                    choosingConversion = true;
                    continue;
                }

            }
            else if(conversionChosen.equals("2")) {
                //convert an integer to roman numerals

                //ask the user to input the roman numerals to be converted
                System.out.println("Please enter the number you would like to translate, then press Enter.\n" +
                        "You can also enter \"q\" to quit");

                // Get the users input number
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String userInput = null;
                try {
                    userInput = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error reading input");
                    return; //don't continue with the rest of the program if we don't have data
                }

                if (userInput.equals("q")) {
                    usingConverter = false;
                    System.out.println("Goodbye");
                    break;
                }

                //validate the input is only numbers
                if (!userInput.matches("[0-9]+")) {
                    //invalid input given (doesn't only contain numbers)
                    System.out.println("Invalid number given, please enter a number containing only characters 0-9\n");
                }

                //give the user input to the converter to convert it to numerals
                String numeralsOfInt = converter.intToNumerals(Integer.valueOf(userInput));
                System.out.println("The given number is equal to: " + numeralsOfInt + "\n");
            }
            else {
                //the user chose to quit the program
                System.out.println("Goodbye!");
                usingConverter = false;
                break;
            }

        }
    }




}
