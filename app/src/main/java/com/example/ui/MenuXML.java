package com.example.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;



public class MenuXML extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        textView = (TextView) findViewById(R.id.txt);
        // 为文本框注册上下文菜单
//        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        //装填R.Menu.my_menu菜单，并添加到menu中
        inflater.inflate(R.menu.menu_main,menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }
    //创建上下文菜单时触发该方法
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        MenuInflater inflater = new MenuInflater(this);
//        //装填R.Menu.menu菜单，并添加到menu中
//        inflater.inflate(R.menu.context,menu);
////        getMenuInflater().inflate(R.menu.context, menu);
////        super.onCreateContextMenu(menu, v, menuInfo);
//        menu.setHeaderIcon(R.drawable.ic_launcher_foreground);
//        menu.setHeaderTitle("请选择背景色");
//    }
    //上下文菜单中菜单项被单击时，触发该方法

//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        //勾选菜单项
//        item.setChecked(true);
//        switch (item.getItemId()){
//            case R.id.red:
//                item.setChecked(true);
//                textView.setBackgroundColor(Color.RED);
//                break;
//            case R.id.green:
//                item.setChecked(true);
//                textView.setBackgroundColor(Color.GREEN);
//                break;
//            case R.id.blue:
//                item.setChecked(true);
//                textView.setBackgroundColor(Color.BLUE);
//                break;
//        }
//        return true;
//    }
    //菜单项被单击后的回调方法

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.isCheckable()){
//            //勾选菜单项
//            item.setCheckable(true);
//        }//?
        //switch 判断单击哪个菜单项，并有针对性的做出响应
        switch (item.getItemId()){
            case R.id.plain_item:
                Toast.makeText(this, "你单击了普通菜单", Toast.LENGTH_LONG).show();
                return true;
             //   break;

            case R.id.font_10:
                textView.setTextSize(10*2);
                return true;
             //   break;

            case R.id.font_16:
                textView.setTextSize(16*2);
                return true;
//                break;
            case R.id.font_20:
                textView.setTextSize(20*2);
                return true;
//                break;
            case R.id.red_font:
                textView.setTextColor(Color.RED);
                return true;
//                break;
            case R.id.green_font:
                textView.setTextColor(Color.GREEN);
                return true;
//                break;
            case R.id.blue_font:
                textView.setTextColor(Color.BLUE);
                return true;
//                break;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
