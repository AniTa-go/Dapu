package cn.xiaojii.dapu.Fragment.TopBar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.xiaojii.dapu.Activity.ClickButtonActivity;
import cn.xiaojii.dapu.R;

public class FragmentPdfReadList  extends Fragment {
    private ListView listView;
    private String[] FileNameListShow = {"中国高血压防治指南(2010年修订版)", "高血压合理用药指南", "2014 年中国高血压患者教育指南(简明版)", "中国高血压基层管理指南(2014 年修订版)"};
    private String[] FileNameList = {"0.pdf", "1.pdf", "2.pdf", "3.pdf"};

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_bar_pdf_read_list, null);
        listView = view.findViewById(R.id.id_pdf_read_listview);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, FileNameListShow);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(), ClickButtonActivity.class);
                intent.putExtra("pdf_file_name",FileNameList[position]);
                intent.putExtra("code",3);
                getActivity().startActivity(intent);
            }
        });

        return view;
    }
}