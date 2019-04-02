# Ui
![](https://github.com/Bearrrrrr/Ui/blob/master/img/5.png)

  public class Main extends AppCompatActivity {

    private Button button, button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button  = findViewById(R.id.simple);
        button1  = findViewById(R.id.Dialog);
        button2 = findViewById(R.id.XML);
        button3=findViewById(R.id.actionmode);


        myListener listener = new myListener();
        button.setTag(1);         //给button设置标记
        button.setOnClickListener(listener);
        button1.setTag(2);
        button1.setOnClickListener(listener);
        button2.setTag(3);
        button2.setOnClickListener(listener);
        button3.setTag(4);
        button3.setOnClickListener(listener);



    }


    public class myListener implements View.OnClickListener{

        @Override
        public void onClick(View v){
            int tag = (Integer)v.getTag(); //找到每个button的标记
            Intent intent = new Intent();
            switch(tag){
                case 1:
                    intent.setClass(Main.this, SimpleAdapterDemo.class);
                    break;
                case 2:
                    intent.setClass(Main.this,DialogDemo.class);
                    break;
                case 3:
                    intent.setClass(Main.this, MenuXML.class);
                    break;
                case 4:
                    intent.setClass(Main.this, ActionMode.class);
                    break;

            }
            Main.this.startActivity(intent);
        }
    }
}

![](https://github.com/Bearrrrrr/Ui/blob/master/img/1.png)
  
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


![](https://github.com/Bearrrrrr/Ui/blob/master/img/2.png)
 
    
public class DialogDemo extends AppCompatActivity {

    private Button button, button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo);
        //动态加载布局生成View对象
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View longinDialogView = layoutInflater.inflate(R.layout.activity_dialog_demo, null);

        //获取布局中的控件
        EditText mUserName = (EditText) longinDialogView.findViewById(R.id.edit_username);
        EditText mPassword = (EditText) longinDialogView.findViewById(R.id.edit_password);
        //创建一个AlertDialog对话框
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.drawable.header)
                .setView(longinDialogView)                //加载自定义的对话框式样
                .setPositiveButton("Sign in", null)
                .setNeutralButton("Cancle", null)
                .create();
        dialog.show();
    }
}
    
    activity_dialog_demo.xml
    <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".DialogDemo">
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:src="@drawable/header"
        android:scaleType="centerCrop"
        />

    <EditText
        android:id="@+id/edit_username"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"
        android:gravity="left"
        android:hint="Username"
        android:inputType="none"
        android:digits="abcdefghigklmnopqrstuvwxyz1234567890_"    >

    </EditText>



    <EditText
        android:id="@+id/edit_password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"
        android:gravity="left"
        android:hint="Password"
        android:inputType="textPassword"
        android:digits="1234567890"    >

    </EditText>

</LinearLayout>

![](https://github.com/Bearrrrrr/Ui/blob/master/img/31.png)

![](https://github.com/Bearrrrrr/Ui/blob/master/img/32.png)


public class MenuXML extends AppCompatActivity{
      private TextView textView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        textView = (TextView) findViewById(R.id.txt);

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        //装填R.Menu.my_menu菜单，并添加到menu中
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.plain_item:
                Toast.makeText(this, "你单击了普通菜单", Toast.LENGTH_LONG).show();
                return true;

            case R.id.font_10:
                textView.setTextSize(10*2);
                return true;

            case R.id.font_16:
                textView.setTextSize(16*2);
                return true;

            case R.id.font_20:
                textView.setTextSize(20*2);
                return true;

            case R.id.red_font:
                textView.setTextColor(Color.RED);
                return true;

            case R.id.green_font:
                textView.setTextColor(Color.GREEN);
                return true;

            case R.id.blue_font:
                textView.setTextColor(Color.BLUE);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}


![](https://github.com/Bearrrrrr/Ui/blob/master/img/4.png)

public class ActionMode extends AppCompatActivity {
    private ListView list;
    
    private String[] names = new String[]
            { "One", "Two", "Three", "Four","Five"};
    
    private int[] imageIds = new int[]
            { R.drawable.ic_launcher , R.drawable.ic_launcher
                    , R.drawable.ic_launcher ,R.drawable.ic_launcher, R.drawable.ic_launcher};

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

                mode.finish(); 
                return false;
            }
        });
    }
}
