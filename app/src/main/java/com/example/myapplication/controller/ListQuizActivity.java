package com.example.myapplication.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Question;
import com.example.myapplication.repository.QuestionRepository;
import com.example.myapplication.repository.RepositoryInterface;

import java.util.List;

public class ListQuizActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RepositoryInterface mRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository = QuestionRepository.getInstance();
        setContentView(R.layout.question_list);
        mRecyclerView = findViewById(R.id.recycler_view_questions);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initUI();
    }

    private void initUI() {
        List<Question> questions = mRepository.getQuestions();
        QuestionAdapter adapter = new QuestionAdapter(questions);
        mRecyclerView.setAdapter(adapter);
    }

    //view holder responsibility: hold reference to row views.
    private class QuestionHolder extends RecyclerView.ViewHolder {
        private TextView mQuestion;
        private TextView mColor;
        private CheckBox mAnswer;
        private CheckBox mCheat;

        public QuestionHolder(@NonNull View itemView) {
            super(itemView);

            mQuestion = itemView.findViewById(R.id.question_text);
            mColor = itemView.findViewById(R.id.question_color);
            mAnswer = itemView.findViewById(R.id.answer_checkbox);
            mCheat = itemView.findViewById(R.id.cheat_Checkbox);
        }

        public void bindQuestion(Question question) {
            mQuestion.setText(question.getQuestionText());
            mColor.setText(question.getColor());
            mAnswer.setChecked(question.isAnswerTrue());
            mCheat.setChecked(question.isCheat());
        }
    }

    /*adapter responsibilities:
      1. getItemCounts
      2. create view holder
      3. bind view holder
   */
    private class QuestionAdapter extends RecyclerView.Adapter<QuestionHolder> {
        private List<Question> mQuestions;

        public List<Question> getQuestions() {
            return mQuestions;
        }

        public void setQuestions(List<Question> questions) {
            mQuestions = questions;
        }

        public QuestionAdapter(List<Question> questions) {
            mQuestions = questions;
        }

        @Override
        public int getItemCount() {
            return mQuestions.size();
        }


        @NonNull
        @Override
        public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(ListQuizActivity.this);
            View view = inflater.inflate(R.layout.list_row_question, parent, false);
            QuestionHolder questionHolder = new QuestionHolder(view);
            return questionHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {
            Question question = mQuestions.get(position);
            holder.bindQuestion(question);
        }
    }
}
