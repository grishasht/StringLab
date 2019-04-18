package article.services;

import article.model.Word;

import java.util.Comparator;
import java.util.List;

public class SortText {
    private Parser parser;
    public SortText(Parser parser) {
        this.parser = parser;
    }

    public List<Word> sortText(){
        parser.parseText();
        List<Word> words = parser.getWordList();
        words.sort(Comparator.comparing(word -> word.getSybolEquality()));
        return words;
    }
}
