package com.example.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionMode extends AppCompatActivity {
    private ListView list;
    private String[] names = new String[]
            { "One", "Two", "Three", "Four","Five"};
    private int[] imageIds = new int[]
            { R.drawable.ic_launcher , R.drawable.ic_launcher
                    , R.drawable.ic_launcher ,R.drawable.ic_launcher, R.drawable.ic_launcher};
    //    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
//
//        // Called when the action mode is created; startActionMode() was called
//        @Override
//        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//            // Inflate a menu resource providing context menu items
//            MenuInflater inflater = mode.getMenuInflater();
//            inflater.inflate(R.menu.context, menu);
//            return true;
//        }
//
//        // Called each time the action mode is shown. Always called after onCreateActionMode, but
//        // may be called multiple times if the mode is invalidated.
//        @Override
//        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//            return false; // Return false if nothing is done
//        }
//
//        // Called when the user selects a contextual menu item
//        @Override
//        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.select:
//                    mode.finish(); // Action picked, so close the CAB
//                    return true;
//                default:
//                    return false;
//            }
//        }
//
//        // Called when the user exits the action mode
//        @Override
//        public void onDestroyActionMode(ActionMode mode) {
//            mActionModeCallback = null;//?
//        }
//    };
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        this.setTitle("ActionMode");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action);
        // 创建一个List集合，List集合的元素是Map<
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("photo", imageIds[i]);
            listItem.put("Name", names[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        final android.widget.SimpleAdapter simpleAdapter = new android.widget.SimpleAdapter(this, listItems,
                R.layout.simple_item1,
                new String[] { "photo", "Name",},
                new int[] { R.id.header,R.id.name });
        list = (ListView) findViewById(R.id.mlist);
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

            }
        });
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.context, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(android.view.ActionMode mode) {
            }

            @Override
            public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public void onItemCheckedStateChanged(android.view.ActionMode mode, int position,
                                                  long id, boolean checked) {
                mode.setSubtitle(list.getCheckedItemCount()+"selected");

            }

            @Override
            public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
//                // Respond to clicks on the actions in the CAB
//                switch (item.getItemId()) {
//                    case R.id.select:
                mode.finish(); // Action picked, so close the CAB
//                        return true;
//                    default:
                return false;
//                }
            }
        });
    }
}
