package BOJ;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class N1181 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int size = input.nextInt();
            input.nextLine();
    
            int i;
            ArrayList<String> word = new ArrayList<>();
            for(i = 0; i < size; i++) {
                String letter = input.nextLine();
                if(!word.contains(letter)) {
                    word.add(letter);
                }
            }
    
            word.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    } else {
                        return Integer.compare(o1.length(), o2.length());
                    }
                }
            });
    
            for(i = 0; i < word.size(); i++) {
                System.out.println(word.get(i));
            }
        } finally {
            input.close();
        }
    }
}