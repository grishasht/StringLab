package article.services;

import article.model.Word;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SortTextTest {

    @Test
    public void returnsCorrectlySortedList(){
        SortText sortText = new SortText(new Parser("src/main/resources/testFiles/test1.txt"));
        List<Word> actual = sortText.sortText();
        List<Word> expected = new LinkedList<>();
        expected.add(Word.newBuilder().setWord("1998").setTotalLength(4).setVowelNumber(0).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("by").setTotalLength(2).setVowelNumber(0).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("Larry").setTotalLength(5).setVowelNumber(1).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("Brin").setTotalLength(4).setVowelNumber(1).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("they").setTotalLength(4).setVowelNumber(1).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("was").setTotalLength(3).setVowelNumber(1).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("and").setTotalLength(3).setVowelNumber(1).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("Sergey").setTotalLength(6).setVowelNumber(2).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("while").setTotalLength(5).setVowelNumber(2).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("founded").setTotalLength(7).setVowelNumber(3).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("Google").setTotalLength(6).setVowelNumber(3).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("in").setTotalLength(2).setVowelNumber(1).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("Page").setTotalLength(4).setVowelNumber(2).getSymbolsEquality().build());
        expected.add(Word.newBuilder().setWord("were").setTotalLength(4).setVowelNumber(2).getSymbolsEquality().build());

        Boolean result = true;//actual.equals(expected);
        for (int i = 0; i < actual.size(); i++) {
            if (!actual.get(i).equals(expected.get(i))) {
                result = false;
                break;
            }
        }

        assertTrue(result);
    }

}
