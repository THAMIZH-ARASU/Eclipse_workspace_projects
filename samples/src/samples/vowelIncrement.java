package samples;


/*A group of people is playing a game based on vowels. 
 * If a person among them says a word or sentence others should tell the word immediately. 
 * Where while telling the word they just want to replace each vowel with the next immediate vowel lexicographical order 
 * i.e. a’ will be replaced by ‘e’, ‘e’ will be replaced by ‘i’, ‘i’ will be replaced by ‘o’, ‘o’ will be replaced by ‘u’, ‘u’ will be replaced by ‘a’. 
 * The person who says the word first with the mentioned changes is the winner of the game. 
 * Sonu is failing all the time. He is good in English but he couldn't do it properly for a lengthy sentence. 
 * Help him to win the game by writing a C++ program implementing the same.
*/

import java.util.Scanner;

public class vowelIncrement {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        
        String input_str;
        StringBuilder output_str;
        
        char vowels[] = {'a', 'e', 'i', 'o', 'u'};
        char vowels2[] = {'A', 'E', 'I', 'O', 'U'};
        int vowelLength = vowels.length;
        
        while (true) {
            System.out.println("Enter a string (type 'exit' to quit):");
            input_str = s.nextLine();
            
            // Exit condition
            if (input_str.equals("exit")) {
                break;
            }
            
            output_str = new StringBuilder();
            int input_str_length = input_str.length();
            
            for (int i = 0; i < input_str_length; i++) {
                char currentChar = input_str.charAt(i);
                boolean isVowel = false;
                
                for (int j = 0; j < vowelLength; j++) {
                    if (currentChar == vowels[j]) {
                        output_str.append(vowels[(j + 1) % vowelLength]);
                        isVowel = true;
                        break;
                    }else if(currentChar == vowels2[j]) {
                    	output_str.append(vowels2[(j + 1) % vowelLength]);
                    	isVowel = true;
                    	break;
                    }
                }
              
                if (!isVowel) {
                    output_str.append(currentChar);
                }
            }
            
            System.out.println("Output: " + output_str);
        }
        
        s.close();
    }
}
