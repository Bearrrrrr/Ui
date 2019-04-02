package com.example.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterDemo extends AppCompatActivity {
    private String[] names = new String[]
            { "Lion", "Tiger", "Monkey", "Dog","Cat","Elephant"};
    private int[] imageIds = new int[]
            { R.drawable.lion , R.drawable.tiger
                    , R.drawable.monkey ,R.drawable.dog, R.drawable.cat,R.drawable.elephant};
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 创建一个List集合，List集合的元素是Map<
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("Name", names[i]);
            listItem.put("photo", imageIds[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        android.widget.SimpleAdapter simpleAdapter = new android.widget.SimpleAdapter(this, listItems,
                R.layout.simple_item,
                new String[] { "Name", "photo",},
                new int[] { R.id.name,R.id.header });
        ListView list = (ListView) findViewById(R.id.mylist);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);

        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // 第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                Toast.makeText(getApplicationContext(), names[position],
                    Toast.LENGTH_SHORT).show();

            }
        });
    }
}
