package article.services;

import article.model.Word;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String filePath;
    /*Identifier which contains all file inside*/
    private String fileBuffer = "";
    /*List with parsed words*/
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
        /*This method gets out all file int identifier fileBuffer*/
        file.openFile(filePath);
        String line = file.readFromFile();
        while (line != ""){
            fileBuffer += line;
            line = file.readFromFile();
        }
        file.closeFile();
    }

    public String[] splitText(){
        /*This method splits the text from file*/
        getFileBuffer();
        final String S = "\\W+";
        Pattern pattern = Pattern.compile(S);
        return pattern.split(fileBuffer);
    }

    public Integer countVowels(String word, Pattern pattern){
        /*This method counts vowel characters in each word*/
        Integer count = 0;
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()){
            count++;
        }
        return count;
    }

    public void parseText(){
        /*This method creates list with word and his information*/
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
