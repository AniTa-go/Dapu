package cn.xiaojii.dapu.Fragment.Discover;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.xiaojii.dapu.Bean.TcmJsonBean;
import cn.xiaojii.dapu.Bean.UserInformationBean;
import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;
import cn.xiaojii.dapu.Utils.ParseTcmJsonUtils;

@SuppressLint("ValidFragment")
public class TcmResultFragment extends BaseFragment {



    private List<TcmJsonBean> tcmJsonBeans;
    private int ZhiIndex;

    @SuppressLint("ValidFragment")
    public TcmResultFragment(UserInformationBean userInformationBean,int ZhiIndex) {

        this.userInformationBean = userInformationBean;
        this.ZhiIndex=ZhiIndex;

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tcm_result, null);

        ParseTcmJsonUtils parseTcmJsonUtils = new ParseTcmJsonUtils(getActivity());
        tcmJsonBeans = parseTcmJsonUtils.GetJsonData("PhysiqueChineseMedicineConditioning.json");

        InitView(view);

        return view;
    }

    private void InitView(View view) {

        LeftButton = view.findViewById(R.id.id_top_left);
        CenterTextview = view.findViewById(R.id.id_top_center);

        view.findViewById(R.id.id_top_right).setVisibility(View.GONE);

        LeftButton.setText("<问卷("+userInformationBean.getCurIndex()+"/" + userInformationBean.getSumCount() + ")");

        CenterTextview.setText("问卷结果");

        LeftButton.setVisibility(View.VISIBLE);
        CenterTextview.setVisibility(View.VISIBLE);

        LeftButton.setOnClickListener(this);

        ((TextView) view.findViewById(R.id.id_tcm_result_name)).setText(userInformationBean.getStrName());
        ((TextView) view.findViewById(R.id.id_tcm_result_string)).setText(tcmJsonBeans.get(ZhiIndex).toString());

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.id_top_left:
                getActivity().onBackPressed();
                break;
        }

    }
}