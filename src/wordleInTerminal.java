import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class wordleInTerminal {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static String userGuess = "";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";





    public static void main(String[] args) throws IOException {


        List<String> wordWordsList =  new ArrayList<String>();


        // Thank you to @techtribeyt on gitHub for this file.

        BufferedReader bf = new BufferedReader(new FileReader("src/wordmaster_guesses.txt"));

        String line = bf.readLine();

        while (line != null){
            wordWordsList.add(line);
            line = bf.readLine();
        }

        bf.close();

        String theWord = wordWordsList.get(new Random().nextInt(11488));

        List<Character> theWordLetters = new ArrayList<>();

        List<Character> userWordLetters = new ArrayList<>();

        for (int i = 0; i < 5; i += 1)
        {

            theWordLetters.add(theWord.charAt(i));

        }

        for (int i = 0; i < 6;) {

            System.out.println(ANSI_BLACK + "\nEnter your guess....." + ANSI_RESET);
            Scanner wordScanner = new Scanner(System.in);
            userGuess = wordScanner.nextLine().toLowerCase(Locale.ROOT);


            if (i != 0)
            {
                for (int s = 0; s < 5; s += 1)
                {

                    theWordLetters.add(theWord.charAt(s));

                }
            }

            if (!wordWordsList.contains(userGuess)) {
                System.out.println(ANSI_BLACK + "Please enter a valid word." + ANSI_RESET );
            }
            else
            {
                for (int z = 0; z < 5; z += 1)
                {

                    userWordLetters.add(userGuess.charAt(z));

                }


                if (userGuess.equals(theWord))
                {
                    System.out.println(ANSI_RED_BACKGROUND + userGuess + ANSI_RESET);
                    System.out.println("Congrats, you got the word!");
                    break;
                }
                else {
                    for (int u = 0; u < 5; u += 1)
                    {
                        if (userWordLetters.get(u) == theWordLetters.get(u))
                        {
                            System.out.print(ANSI_RED_BACKGROUND + Character.toString(userGuess.charAt(u)) + ANSI_RESET + " ");
                            userWordLetters.set(u, null);
                            theWordLetters.set(u, null);


                        }
                        else
                        {
                            if (theWordLetters.contains(userWordLetters.get(u)))
                            {
                                System.out.print(ANSI_GREEN_BACKGROUND + Character.toString(userGuess.charAt(u)) + ANSI_RESET + " ");
                                userWordLetters.set(u, null);
                                theWordLetters.set(u, null);
                            }
                            else
                            {
                                System.out.print(ANSI_BLACK_BACKGROUND + Character.toString(userGuess.charAt(u)) + ANSI_RESET + " ");
                            }
                        }


                    }
                    i += 1;
                    userWordLetters.clear();
                    theWordLetters.clear();
                }





            }
        }

        System.out.println("\nThe word was: " + theWord);






    }
}
