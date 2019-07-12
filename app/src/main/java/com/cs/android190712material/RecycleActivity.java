package com.cs.android190712material;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {

    // 항목 View를 만들어주는 Class
    class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public MyViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(android.R.id.text1);
        }
    }

    // RecyclerView 출력을 위한 Adapter Class
    class  MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        // 출력하기 위한 Data 목록
        List<String> list;

        public MyAdapter(List<String> list){
            this.list = list;
        }

        // 화면에 출력될 View Holder를 설정하는 Method
        public MyViewHolder onCreateViewHolder(ViewGroup group, int i){
            // Text 하나를 출력하는 항목 View를 가져오기
            View view = LayoutInflater.from(group.getContext())
                    .inflate(android.R.layout.simple_list_item_1, group, false);
            return new MyViewHolder(view);
        }

        // 항목의 개수를 설정하는 Method
        @Override
        public int getItemCount(){
            return list.size();
        }

        // View Holder와 Index를 Mapping 시켜주는 Method
        @Override
        public void onBindViewHolder(MyViewHolder myViewHolder, int i){
            String text = list.get(i);
            myViewHolder.title.setText(text);
        }
    }

    // RecyclerView가 화면에 출력되기 전이나 출력된 후에 호출되는 Class
    // 이 Class는 그림을 그리기 위해 사용 됩니다.
    class MyItemDecoration extends RecyclerView.ItemDecoration{
        // 항목 간의 거리를 만드는 Method
        @Override
        public void getItemOffsets(Rect outRect,
                                   View view,
                                   RecyclerView parent,
                                   RecyclerView.State state){

            int index = parent.getChildAdapterPosition(view) + 1;
            if(index % 3 == 0){
                // 3번 마다 1번은 아랫쪽 여백을 늘리기
                outRect.set(20, 20, 20, 60);
            }else {
                outRect.set(20, 20, 20, 20);
            }
            view.setBackgroundColor(0xFFE9E9E9);
            ViewCompat.setElevation(view, 20.0f);
        }

        // 항목을 전부 표시하고 호출되는 Method
        @Override
        public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state){
            super.onDraw(canvas, parent, state);

            // 전체 크기
            int width = parent.getWidth();
            int height = parent.getHeight();

            // Image 가져오기
            Drawable dr = ResourcesCompat.getDrawable(
                    getResources(), R.drawable.android, null);

            // Iamge 크기 가져오기
            int drWidth = dr.getIntrinsicWidth();
            int drHeight = dr.getIntrinsicHeight();

            int left = width/2 - drWidth/2;
            int top = height/2 - drHeight/2;

            // Image 그리기
            canvas.drawBitmap(
                    BitmapFactory.decodeResource(
                            getResources(), R.drawable.android), left, top, null);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        // 출력할 View 찾아오기
        RecyclerView recyclerView = findViewById(R.id.recycle);

        // Data 생성
        List<String> list = new ArrayList<>();
        for(int i=1 ; i<=20 ; i=i+1){
            list.add("항목 : " + i);
        }

        // 출력 방식 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));

        // Adapter 설정
        recyclerView.setAdapter(new MyAdapter(list));

        // Decoration 설정
        recyclerView.addItemDecoration(new MyItemDecoration());
    }
}
