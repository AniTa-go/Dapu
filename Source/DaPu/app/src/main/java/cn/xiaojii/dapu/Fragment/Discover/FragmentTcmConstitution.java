package cn.xiaojii.dapu.Fragment.Discover;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.List;

import cn.xiaojii.dapu.Adapter.AnswerAdapter;
import cn.xiaojii.dapu.Bean.QuestionBean;
import cn.xiaojii.dapu.Factory.DataFactory.QuestionAnswerFactory;
import cn.xiaojii.dapu.Fragment.BaseFragment;
import cn.xiaojii.dapu.R;


@SuppressLint("ValidFragment")
public class FragmentTcmConstitution extends BaseFragment {


    private Context context;



    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_tcm_constitution, null);
        CurQuestionIndex=1;
        InitView(view);

        return view;
    }

    @SuppressLint("SetTextI18n")
    private void InitView(View view) {

        LeftButton = view.findViewById(R.id.id_top_left);
        CenterTextview = view.findViewById(R.id.id_top_center);
        RightButton = view.findViewById(R.id.id_top_right);


        LeftButton.setText("<中医体质辨识");
        LeftButton.setVisibility(View.VISIBLE);

        RightButton.setText("交卷");
        RightButton.setVisibility(View.VISIBLE);

        CenterTextview.setText("问卷(" + CurQuestionIndex + "/" + QuestionCount + ")");
        CenterTextview.setVisibility(View.VISIBLE);

        LeftButton.setOnClickListener(this);
        RightButton.setOnClickListener(this);

        PreviousButton = view.findViewById(R.id.id_bommom_bar_previous);
        NextButton = view.findViewById(R.id.id_bottom_bar_next);

        PreviousButton.setOnClickListener(this);
        NextButton.setOnClickListener(this);

        QuestionTextView = view.findViewById(R.id.id_tcm_constitution_question);
        QuestionTextView.setText("问题:" + questionBeanList.get(0).getQuestion());

        AnswerListView = view.findViewById(R.id.id_tcm_constitution_answer_listview);

        answerAdapter = new AnswerAdapter(getActivity(), questionBeanList.get(0));
        AnswerListView.setAdapter(answerAdapter);

        AnswerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
              CurQuestionIndex++;
              UpdateView();

            }
        });


    }

    @SuppressLint("ValidFragment")
    public FragmentTcmConstitution(Context context) {
        this.context = context;
        questionBeanList = QuestionAnswerFactory.GetNormalData(context, "PhysicalTest.json");
        QuestionCount = questionBeanList.size() + 1;
        CurQuestionIndex = 1;


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_top_left:
                break;
            case R.id.id_top_right:
                break;
            case R.id.id_bommom_bar_previous:
                break;
            case R.id.id_bottom_bar_next:
                break;


        }
    }


}
