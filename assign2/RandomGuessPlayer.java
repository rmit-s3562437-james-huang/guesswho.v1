import java.io.*;
import java.util.*;

/**
 * Random guessing player.
 * This player is for task B.
 *
 * You may implement/extend other interfaces or classes, but ensure ultimately
 * that this class implements the Player interface (directly or indirectly).
 */
public class RandomGuessPlayer implements Player
{
    /**
     * Loads the game configuration from gameFilename, and also store the chosen
     * person.
     *
     * @param gameFilename Filename of game configuration.
     * @param chosenName Name of the chosen person for this player.
     * @throws IOException If there are IO issues with loading of gameFilename.
     *    Note you can handle IOException within the constructor and remove
     *    the "throws IOException" method specification, but make sure your
     *    implementation exits gracefully if an IOException is thrown.
     */
    public RandomGuessPlayer(String gameFilename, String chosenName)
        throws IOException
    {
        // reads game file
        Scanner gameFileScan = new Scanner(new File(gameFilename));
        Map<String, List<String>> attributes = readAttributes(gameFileScan);

        List<PlayerFromFile> players = new ArrayList<PlayerFromFile>();

        while (gameFileScan.hasNextLine()){
            PlayerFromFile player = readPlayerFromFile(gameFileScan);
            players.add(player);
        }

        List<String> hairLengths = attributes.get("hairLength");
        for (String hair : hairLengths){
            System.out.println(hair);
        }




    } // end of RandomGuessPlayer()

    private Map<String, List<String>> readAttributes(Scanner gameFileScan){
        Map<String, List<String>> attributes = new HashMap<String, List<String>>();

        while (gameFileScan.hasNextLine()){
            String line = gameFileScan.nextLine();

            //check newline
            if (line.equals("")){
                break;
            }

            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(" ");

            //get the first item of the line
            String key = lineScan.next();
            List<String> values = new ArrayList<String>();

            //then put the rest in the arraylist as the values
            while (lineScan.hasNext()){
                String value = lineScan.next();
                values.add(value);
            }
            attributes.put(key, values);
        }
        return attributes;
    }

    private PlayerFromFile readPlayerFromFile(Scanner gameFileScan){
        String name = "";
        Map<String, String> attributes = new HashMap<String, String>();

        while (gameFileScan.hasNextLine()){
            String line = gameFileScan.nextLine();
            if (line.equals("")){
                break;
            }

            String[] keyValue = line.split(" ");
            if (keyValue.length > 1){
                attributes.put(keyValue[0], keyValue[1]);
            }else {
                name = line;
            }
        }
        return new PlayerFromFile(name, attributes);
    }


    public Guess guess() {

        // placeholder, replace
        return new Guess(Guess.GuessType.Person, "", "Placeholder");
    } // end of guess()


    public boolean answer(Guess currGuess) {

        // placeholder, replace
        return false;
    } // end of answer()


	public boolean receiveAnswer(Guess currGuess, boolean answer) {

        // placeholder, replace
        return true;
    } // end of receiveAnswer()

} // end of class RandomGuessPlayer

class PlayerFromFile{
    private String name;
    private Map<String, String> attributes;

    PlayerFromFile(String name, Map<String, String> attributes){
        this.name = name;
        this.attributes = attributes;
    }
}