public class RomanNumeralConverter {

    public static String ALLOWED_NUMERALS = "MDCLXVI";
    public static int INVALID_GIVEN_STRING_VALUE = -1;
    private static String INVALID_STRING = "invalid";
    private static int M = 1000;
    private static int D = 500;
    private static int C = 100;
    private static int L = 50;
    private static int X = 10;
    private static int V = 5;
    private static int I = 1;

    /**
     *  Takes a string of roman numerals and converts it to the integer equivalent,
     *   if the string is invalid this method will return the INVALID_GIVEN_STRING_VALUE constant
     */
    public static Integer numeralsToInt(String numerals) {
        //first clean and validate the given string
        String cleanedNumerals = cleanUserInput(numerals);
        if (cleanedNumerals.equals("invalid")) {
            return INVALID_GIVEN_STRING_VALUE;
        }

        //calculate and return the value
        Integer total = 0;
        char[] numeralArray = cleanedNumerals.toCharArray();
        for (int i = 0; i < numeralArray.length; i++) {
            Character currentNumeral = numeralArray[i];
            int currentValue = 0;

            if (currentNumeral.equals('M')) {
                currentValue = M;
            }
            else if (currentNumeral.equals('D')) {
                currentValue = D;
            }
            else if (currentNumeral.equals('C')) {
                currentValue = C;
            }
            else if (currentNumeral.equals('L')) {
                currentValue = L;
            }
            else if (currentNumeral.equals('X')) {
                currentValue = X;
            }
            else if (currentNumeral.equals('V')) {
                currentValue = V;
            }
            else if (currentNumeral.equals('I')) {
                currentValue = I;
            }

            if (i+1 != numeralArray.length) {
                //this is not the last char, we can check the next char to see if it's subtracting
                Character nextNumeral = numeralArray[i+1];
                int nextValue = 0;

                if (nextNumeral.equals('M')) {
                    nextValue = M;
                }
                else if (nextNumeral.equals('D')) {
                    nextValue = D;
                }
                else if (nextNumeral.equals('C')) {
                    nextValue = C;
                }
                else if (nextNumeral.equals('L')) {
                    nextValue = L;
                }
                else if (nextNumeral.equals('X')) {
                    nextValue = X;
                }
                else if (nextNumeral.equals('V')) {
                    nextValue = V;
                }
                else if (nextNumeral.equals('I')) {
                    nextValue = I;
                }

                //if the next value is larger than the current symbol, we subtract the current value from the next value
                if (nextValue > currentValue) {
                    int numToAdd = nextValue - currentValue;
                    i++; //need to increment our loop so we don't add the next value twice
                    total += numToAdd;
                }
                else {
                    //there is no subtraction to be done, just add the value
                    total += currentValue;
                }
            }
            else {
                //this is the last value in the list, there is no checking needed, just add the value
                total += currentValue;
            }
        }

        return total;
    }

    /**
     *  Takes an integer value and returns a string of the roman numeral equivalent
     */
    public static String intToNumerals(int value) {
        StringBuilder numeralString = new StringBuilder();
        Integer valueLeftToConvert = value;
        //take the value and see how many of each Symbol are needed, starting with the highest
        int numOfSymbolNeeded = 0;
        numOfSymbolNeeded = valueLeftToConvert / M;
        for (int i = 0; i < numOfSymbolNeeded; i++) {
            valueLeftToConvert = valueLeftToConvert - M;
            numeralString.append("M");
        }
        numOfSymbolNeeded = valueLeftToConvert / D;
        for (int i = 0; i < numOfSymbolNeeded; i++) {
            valueLeftToConvert = valueLeftToConvert - D;
            numeralString.append("D");
        }
        numOfSymbolNeeded = valueLeftToConvert / C;
        for (int i = 0; i < numOfSymbolNeeded; i++) {
            valueLeftToConvert = valueLeftToConvert - C;
            numeralString.append("C");
        }
        numOfSymbolNeeded = valueLeftToConvert / L;
        for (int i = 0; i < numOfSymbolNeeded; i++) {
            valueLeftToConvert = valueLeftToConvert - L;
            numeralString.append("L");
        }
        numOfSymbolNeeded = valueLeftToConvert / X;
        for (int i = 0; i < numOfSymbolNeeded; i++) {
            valueLeftToConvert = valueLeftToConvert - X;
            numeralString.append("X");
        }
        numOfSymbolNeeded = valueLeftToConvert / V;
        for (int i = 0; i < numOfSymbolNeeded; i++) {
            valueLeftToConvert = valueLeftToConvert - V;
            numeralString.append("V");
        }
        numOfSymbolNeeded = valueLeftToConvert / I;
        if (numOfSymbolNeeded == 4) {
            numeralString.append("IV");
            valueLeftToConvert = valueLeftToConvert - 4;
        }
        else {
            for (int i = 0; i < numOfSymbolNeeded; i++) {
                valueLeftToConvert = valueLeftToConvert - I;
                numeralString.append("I");
            }
        }
        return numeralString.toString();
    }

    /**
     *  Removes whitespace from the given string and validates that only Roman Numerals were used,
     *  returns INVALID_STRING constant if the input is not valid
     */
    private static String cleanUserInput(String userInput) {
        //first remove all whitespace
        String cleanedString = userInput.replaceAll("\\s","");

        //make sure there are no invalid chars
        for (int i = 0; i < cleanedString.length(); i++) {
            char cleanedChar = cleanedString.charAt(i);
            Boolean currentCharValid = false;
            for (int j = 0; j < ALLOWED_NUMERALS.length(); j++) {
                if (ALLOWED_NUMERALS.charAt(j) == cleanedChar) {
                    currentCharValid = true;
                }
            }
            if (!currentCharValid) {
                //the char in the cleaned string is not a roman numeral, return "invalid"
                return INVALID_STRING;
            }
        }

        return cleanedString;
    }

}
