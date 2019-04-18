package article;

import article.model.Word;
import article.services.Parser;
import article.services.SortText;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SortText text = new SortText(new Parser("src/main/resources/article.txt"));
        List<Word> sortedText = text.sortText();
        System.out.println(sortedText.size());
        sortedText.forEach(word -> System.out.println(word));
    }
}
