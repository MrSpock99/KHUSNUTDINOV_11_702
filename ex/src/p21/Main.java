package p21;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("aaaa");
        strings.add("dbca");
        strings.add("zabcdz");
        strings.add("abababab");

        strings.sort((o1, o2) -> {
            ArrayList<Integer> ascendingSeq1 = new ArrayList<>();
            ArrayList<Integer> ascendingSeq2 = new ArrayList<>();

            int count = 0;
            for (int i = 0; i < o1.length() - 1; i++){
                if (o1.charAt(i) < o1.charAt(i+1)){
                    count++;
                }else {
                    ascendingSeq1.add(count);
                    count = 0;
                }

            }
            ascendingSeq1.add(count);

            count = 0;
            for (int i = 0; i < o2.length() - 1; i++){
                if (o2.charAt(i) < o2.charAt(i+1)){
                    count++;
                }else {
                    ascendingSeq2.add(count);
                    count = 0;
                }
            }
            ascendingSeq2.add(count);


            int maxAscendigSeq1 = Collections.max(ascendingSeq1);
            int maxAscendigSeq2 = Collections.max(ascendingSeq2);

            if (maxAscendigSeq2 > maxAscendigSeq1){
                return 1;
            }else if (maxAscendigSeq2 < maxAscendigSeq1){
                return -1;
            }else return 0;
        });

        strings.forEach(System.out::println);
    }
}
