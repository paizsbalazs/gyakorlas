package zarovizsga1;

public class Words {

    public boolean hasMoreDigits(String s) {

        int letter = 0;
        int number = 0;

        char[] ch = s.toCharArray();

        for (Character c: ch) {
            if (Character.isDigit(c)) {
                number +=1;
            } else {
                letter +=1;
            }

        }

        return letter<number;
    }
}
