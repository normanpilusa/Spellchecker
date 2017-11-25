
import java.util.*;
import java.io.*;

public class Probabilities {

    static String next = "";
    static ArrayList<TriFreq> arrNext;
    static TriNext tn;

    static boolean upperCase(String s) {

        for (char c : s.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }

        return true;
    }

    public HashMap<String, TriNext> getProbMap() {
        HashMap<String, TriNext> mapTri = new HashMap<String, TriNext>(); //hashmap to store TriNext object;
        try {
            InputStream probs = Isizulu_Spellchecker.class.getResourceAsStream("text/probabilities.txt");
            BufferedReader probsReader = new BufferedReader(new InputStreamReader(probs));
            //Load the wordlist
            String line = probsReader.readLine();
            HashMap<String, Integer> map;  //hashmap to get frequency of a trigram
            ArrayList<String> triArr;
            while (line != null) {
                //Initialise arrays
                triArr = new ArrayList<String>();
                map = new HashMap<String, Integer>();
                Scanner scTri = new Scanner(line);
                String tri;
                tri = scTri.next();
                while (scTri.hasNext()) {
                    String tNext = scTri.next().trim();
                    int freq = scTri.nextInt();
                    triArr.add(tNext);
                    map.put(tNext, freq);
                }
                scTri.close();
                line = probsReader.readLine();
            }
            probs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapTri;
    }
}
