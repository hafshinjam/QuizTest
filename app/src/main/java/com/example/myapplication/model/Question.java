package com.example.myapplication.model;

public class Question {
    private String mQuestionText;
    private boolean mAnswerTrue;
    private boolean mCheat;
    private String mColor;

    public boolean isCheat() {
        return mCheat;
    }

    public void setCheat(boolean cheat) {
        mCheat = cheat;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public String getQuestionText() {
        return mQuestionText;
    }

    public void setQuestionText(String questionText) {
        mQuestionText = questionText;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public Question(String questionText, boolean answerTrue,String color,boolean cheat) {
        mQuestionText = questionText;
        mAnswerTrue = answerTrue;
        mColor=color;
        mCheat=cheat;
    }

    @Override
    public String toString() {
        return "Question{" +
                "mQuestionText=" + mQuestionText +
                ", mAnswerTrue=" + mAnswerTrue +
                '}';
    }
}
