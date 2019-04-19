package article.services;

import article.model.Word;

import java.util.Comparator;
import java.util.List;

public class SortText {
    /*Class which realises sorting text by equality of vowel
    * characters and general word length*/
    private Parser parser;
    public SortText(Parser parser) {
        this.parser = parser;
    }

    public List<Word> sortText(){
        /*Sort text method*/
        parser.parseText();
        List<Word> words = parser.getWordList();
        words.sort(Comparator.comparing(word -> word.getSybolEquality()));
        return words;
    }
}
