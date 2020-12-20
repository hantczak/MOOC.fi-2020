package dictionary;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SaveableDictionary {
    private Map<String, String> dictionary;
    private String fileName;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String filename) {
        this.fileName = filename;
        this.dictionary = new HashMap<>();
    }

    public void add(String words, String translation) {
        dictionary.putIfAbsent(words, translation);
    }

    public String translate(String word) {
        if (dictionary.containsKey(word))
            return dictionary.getOrDefault(word, null);

        else {
            for (String translation : dictionary.keySet()) {

                if (dictionary.get(translation).equals(word)) {
                    return translation;
                }
            }
        }
        return null;
    }

    public void delete(String word) {
        dictionary.remove(word);

        for (String translation : dictionary.keySet()) {
            if (dictionary.get(translation).equals(word)) {
                dictionary.remove(translation);
                return;
            }
        }
    }

    public boolean load() {
        List<String> tempList = null;
        try {
            tempList = Files.lines(Paths.get(this.fileName)).collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
        tempList.stream()
                .map(row -> row.split(":"))
                .forEach(row -> dictionary.put(row[0], row[1]));
        return true;
    }

    public boolean save() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(fileName);
        }catch (Exception e){
            System.out.println("Error: " + e);
            return false;
        }

        while(true){
            for(String key:dictionary.keySet()){
                printWriter.println(key + ":" + dictionary.get(key));
            }
            printWriter.close();
            return true;
        }
    }
}
