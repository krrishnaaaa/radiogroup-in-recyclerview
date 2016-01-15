package com.pcsalt.example.listviewcheckbox.model;

/**
 * Created by krishna on 9/1/16.
 */
public class Question {
    public long id;
    public String question, answer;
    public String option1, option2, option3, option4;
    public int checkedId = -1;
    public int correctOption;
    public boolean isAnswered;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", checkedId=" + checkedId +
                ", correctOption=" + correctOption +
                '}';
    }
}
