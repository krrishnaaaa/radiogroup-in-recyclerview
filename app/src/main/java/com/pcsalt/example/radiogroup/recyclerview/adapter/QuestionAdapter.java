package com.pcsalt.example.radiogroup.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.pcsalt.example.radiogroup.recyclerview.R;
import com.pcsalt.example.radiogroup.recyclerview.model.Question;

import java.util.List;

/**
 * Created by krishna on 9/1/16.
 */
public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private static final String TAG = "QuestionAdapter";
    private LayoutInflater inflater;
    private List<Question> questions;

    public QuestionAdapter(Context context, List<Question> questions) {
        this.inflater = LayoutInflater.from(context);
        this.questions = questions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Question current = questions.get(position);
        holder.setQuestion(current.question);
        holder.setAnswer(current.answer);
        holder.setOptions(current, position);
        Log.e(TAG, position + " :onBindViewHolder: " + current.toString());
    }

    @Override
    public int getItemCount() {
        if (questions == null) {
            return 0;
        } else {
            return questions.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayoutContainer;
        private TextView textViewQuestion, textViewAnswer;
        private RadioGroup radioGroupOptions;
        private RadioButton radioButtonOption1, radioButtonOption2;
        private RadioButton radioButtonOption3, radioButtonOption4;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayoutContainer = (LinearLayout) itemView.findViewById(R.id.linear_layout_container);
            textViewQuestion = (TextView) itemView.findViewById(R.id.text_view_question);
            textViewAnswer = (TextView) itemView.findViewById(R.id.text_view_answer);
            radioGroupOptions = (RadioGroup) itemView.findViewById(R.id.radio_group_options);
            radioButtonOption1 = (RadioButton) itemView.findViewById(R.id.radio_button_option_1);
            radioButtonOption2 = (RadioButton) itemView.findViewById(R.id.radio_button_option_2);
            radioButtonOption3 = (RadioButton) itemView.findViewById(R.id.radio_button_option_3);
            radioButtonOption4 = (RadioButton) itemView.findViewById(R.id.radio_button_option_4);
        }

        public void setQuestion(String question) {
            textViewQuestion.setText(question);
        }

        public void setAnswer(String answer) {
            textViewAnswer.setText(answer);
        }

        public void setOptions(Question question, int position) {
            radioGroupOptions.setTag(position);
            radioButtonOption1.setText(question.option1);
            radioButtonOption2.setText(question.option2);
            radioButtonOption3.setText(question.option3);
            radioButtonOption4.setText(question.option4);
            Log.e(TAG, position + " :setOptions: " + question.toString());

            if(question.isAnswered) {
                radioGroupOptions.check(question.checkedId);
            } else {
                radioGroupOptions.check(-1);
            }
            radioGroupOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int pos = (int) group.getTag();
                    Question que = questions.get(pos);
                    que.isAnswered = true;
                    que.checkedId = checkedId;
                    Log.e(TAG, pos + " :onCheckedChanged: " + que.toString());
                }
            });
        }
    }
}
