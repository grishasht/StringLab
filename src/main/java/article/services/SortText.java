package article.services;

import article.model.Word;

import java.util.Comparator;
import java.util.List;

/*Class which realises sorting text by equality of vowel
 * characters and general word length*/
public class SortText {
    private Parser parser;
    public SortText(Parser parser) {
        this.parser = parser;
    }

    /*Sort text method*/
    public List<Word> sortText(){
        parser.parseText();
        List<Word> words = parser.getWordList();
        words.sort(Comparator.comparing(word -> word.getSybolEquality()));
        return words;
    }
}
