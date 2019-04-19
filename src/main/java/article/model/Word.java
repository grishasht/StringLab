package article.model;

import java.util.Objects;

public class Word {
    /*Word model class*/
    private String lexem;
    private int vowelNumber;
    private int totalLength;
    private Float sybolEquality;

    private Word() {
    }

    public static Builder newBuilder() {
        return new Word().new Builder();
    }

    public class Builder{
        /*Builder pattern*/

        public Builder() {
            //this.word = new Word();
        }

        public Builder setVowelNumber(Integer vowelNumber) {
            Word.this.vowelNumber = vowelNumber;
            return this;
        }

        public Builder setTotalLength(Integer totalLength) {
            Word.this.totalLength = totalLength;
            return this;
        }

        public Builder setWord(String lexem){
            Word.this.lexem = lexem;
            return this;
        }

        public Builder getSymbolsEquality() {
            Word.this.sybolEquality = (float) Word.this.vowelNumber/
                    (float) Word.this.totalLength;
            return this;
        }

        public Word build(){
            return Word.this;
        }
    }

    public Integer getVowelNumber() {
        return vowelNumber;
    }

    public Integer getTotalLength() {
        return totalLength;
    }

    public Float getSybolEquality() {
        return sybolEquality;
    }

    public String getWord() {
        return lexem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return vowelNumber == word.vowelNumber &&
                totalLength == word.totalLength &&
                Objects.equals(lexem, word.lexem) &&
                Objects.equals(sybolEquality, word.sybolEquality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lexem, vowelNumber, totalLength, sybolEquality);
    }

    @Override
    public String toString() {
        return "Word {" +
                "lexem = '" + lexem + '\'' +
                ", vowelNumber = " + vowelNumber +
                ", totalLength = " + totalLength +
                ", sybolEquality = " + sybolEquality +
                '}';
    }
}
