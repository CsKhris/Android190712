package com.cs.android190712material;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class OneFragment extends ListFragment {

    @Override
    public void onResume(){
        super.onResume();

    }

    @Override
    // 화면에 출력될 내용을 만드는 Method
    public void onViewCreated(
            View view, Bundle saveInstanceState){
        super.onViewCreated(view, saveInstanceState);

        ArrayList<String> list = new ArrayList<>();
        list.add("차범근");
        list.add("박지성");
        list.add("손흥민");
        list.add("황의조");
        list.add("이승우");
        list.add("황희찬");
        list.add("조현우");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                list);

        setListAdapter(adapter);
    }

    // 항목을 선택했을 때 호출될 Method
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Toast.makeText(getActivity(),
                (String)l.getAdapter().getItem(position),
                Toast.LENGTH_SHORT).show();
    }
}
