package com.cs.android190712material;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ViewPager pager = findViewById(R.id.pager);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
    }

    class MyPagerAdapter extends FragmentPagerAdapter{
        // Fragment 들을 저장할 List
        ArrayList<Fragment> fragments;

        // 생성자에서 Data 생성
        public MyPagerAdapter(FragmentManager manager){
            super(manager);
            fragments = new ArrayList<>();
            fragments.add(new OneFragment());
            fragments.add(new ThreeFragment());
        }

        // 화면 개수를 설정하는 Method
        @Override
        public int getCount(){
            return fragments.size();
        }

        // 실제 Fragment를 설정하는 Method
        @Override
        public Fragment getItem(int position){
            return fragments.get(position);
        }
    }
}
