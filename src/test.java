import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test {


    public static void main(String[] args) throws IOException {

        BufferedReader brUser = new BufferedReader(new InputStreamReader(System.in));
        String str = brUser.readLine().toLowerCase();
        if (!str.equals(str + ".txt")) {
            str = str + ".txt";
        }
        File file = new File(str);
        System.out.println(file.getPath());
        BufferedReader br = new BufferedReader(new FileReader("src/" + str));

            int wordsCount = 0;
            int maxCount = 0;
            String maxWord = "";

            while (br.ready()) {
                String string = br.readLine().toLowerCase();
                ArrayList<String> words = new ArrayList<>(Arrays.asList(string.split("[,\\.\\ \\\"\\)\\(\\/]")));
                Collections.sort(words);
                String[] word1 = words.toArray(new String[0]);
                int count = 1;
                for (int i = 1; i < word1.length; i++)
                    if (!word1[i].equals("") && !word1[i].equals("a")) {
                        if (word1[i - 1].equals(word1[i])) {
                            count += 1;
                            if (count > maxCount) {
                                maxCount = count;
                                maxWord = word1[i];
                            }
                        } else {
                            System.out.println(word1[i - 1] + " - " + count);
                            count = 1;
                        }
                        wordsCount++;
                    }
            }
            System.out.println("Общее количество слов в файле :" + wordsCount);
            System.out.println("Самое часто встречающееся слово " + maxWord + " , встречается " + maxCount + "  раз");
            br.close();
        }
    }





