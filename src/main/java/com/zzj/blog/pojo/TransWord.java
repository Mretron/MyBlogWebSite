package com.zzj.blog.pojo;

public class TransWord {

    private String word;

    private String result;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public TransWord() {
    }

    public TransWord(String word, String result) {
        this.word = word;
        this.result = result;
    }

    @Override
    public String toString() {
        return "TransWord{" +
                "word='" + word + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
