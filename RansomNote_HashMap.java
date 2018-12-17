//hackerrank ransom note question reference: 
//https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> hmMagzine = new HashMap<>();
        for (int i = 0; i < magazine.length; i++){
            if (hmMagzine.containsKey(magazine[i])){
                hmMagzine.put(magazine[i], hmMagzine.get(magazine[i]) + 1);
            }else{
                hmMagzine.put(magazine[i], 1);
            }
        }
        HashMap<String, Integer> hmNote = new HashMap<>();
        for (int i = 0; i < note.length; i++){
            if (hmNote.containsKey(note[i])){
                hmNote.put(note[i], hmNote.get(note[i]) + 1);
            }else{
                hmNote.put(note[i], 1);
            }
        }
        //iterate through hmNote, every key shoud also exist in hmMagzine,
        //and every note value should be less or equal to that in hmMagzine
        for (String key : hmNote.keySet()) {
            // do something
            if(hmMagzine.containsKey(key) == false){
                System.out.printf("No");
                return;
            }
            if (hmNote.get(key).intValue() > hmMagzine.get(key).intValue()){
                System.out.printf("No");
                return;
            }
        }
        System.out.printf("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
