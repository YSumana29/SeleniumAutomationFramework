package practiceProblems;

public class StringReverse {

    public static void main(String[] args) {

        String input = "The world is a weird place";
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);
        String[] splitString = input.split(" ");
        for (String str : splitString) {
            StringBuilder sb1 = new StringBuilder();
            sb.append(sb1.append(str + " ").reverse());
        }
        System.out.println(sb.toString().trim());

    }
}
