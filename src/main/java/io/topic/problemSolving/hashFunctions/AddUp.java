public class AddUp {
    public static void main(String[] args) {
        char[] keys = new char[] { 'A', 's', 'd' };

        for (int index = 0; index < keys.length; index++) {
            keys[index] = Character.toUpperCase(keys[index]); // inplace UpperCase
        }
        System.out.println(addUp(keys));

    }

    public static int addUp(char[] letters) {
        int index = 0;
        for (char input : letters) {
            for (int i = input - 'A' + 1; i < 100; i += 26) {
                index += i;
            }
        }
        return getUnderNine(index);
    }

    public static int getUnderNine(int number) {
        if (number > 9) { // Limiting Cell to 9
            int new_number = 0;
            while (number > 0) {
                new_number += number % 10;
                number = number / 10;
            }
            number = new_number;
            return getUnderNine(number);
        } else
            return number;
    }
}
