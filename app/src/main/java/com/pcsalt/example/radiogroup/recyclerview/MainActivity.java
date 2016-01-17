package com.pcsalt.example.radiogroup.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pcsalt.example.radiogroup.recyclerview.adapter.QuestionAdapter;
import com.pcsalt.example.radiogroup.recyclerview.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewQuestions;
    private List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewQuestions = (RecyclerView) findViewById(R.id.recycler_view_questions);
        prepareQuestions();
        initQuestionsAdapter();
    }

    private void prepareQuestions() {
        for (int i = 0; i < 30; i++) {
            Question question = new Question();

            question.id = i;
            question.question = "Question #" + (i+1);
            question.option1 = "Option 1";
            question.option2 = "Option 2";
            question.option3 = "Option 3";
            question.option4 = "Option 4";
            question.correctOption = new Random().nextInt(3);
            question.answer = "Answer is: " + question.correctOption;

            questions.add(question);
        }
    }

    private void initQuestionsAdapter() {
        recyclerViewQuestions.setLayoutManager(new LinearLayoutManager(this));
        QuestionAdapter questionAdapter = new QuestionAdapter(this, questions);
        recyclerViewQuestions.setAdapter(questionAdapter);
    }

}
