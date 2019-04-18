package article.services;

import article.model.Word;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String filePath;
    private String fileBuffer = "";
    private List<Word> wordList = new LinkedList<>();
    private FileReader file = FileReader.getInstance();

    public List<Word> getWordList() {
        return wordList;
    }

    public Parser(String filePath) {
        this.filePath = filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private void getFileBuffer(){
        file.openFile(filePath);
        String line = file.readFromFile();
        while (line != ""){
            fileBuffer += line;
            line = file.readFromFile();
        }
        file.closeFile();
    }

    private String[] splitText(){
        getFileBuffer();
        final String S = "\\W+";
        Pattern pattern = Pattern.compile(S);
        return pattern.split(fileBuffer);
    }

    private Integer countVowels(String word, Pattern pattern){
        Integer count = 0;
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()){
            count++;
        }

        return count;
    }

    public void parseText(){
        String[] parsedText = splitText();
        final String example = "[aoeui]";
        Pattern pattern = Pattern.compile(example);
        for (String word: parsedText){
            if(!word.equals(""))
            wordList.add(Word.newBuilder()
                    .setWord(word)
                    .setVowelNumber(countVowels(word, pattern))
                    .setTotalLength(word.length())
                    .getSymbolsEquality()
                    .build());
        }
    }
}
