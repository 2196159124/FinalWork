package com.swufestu.work;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ItemViewHolder extends RecyclerView.ViewHolder{

    TextView viewstr;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        viewstr=(TextView)itemView.findViewById(R.id.item);
    }

}
class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class RecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;
    private List<Map<String,Object>> list;
    private int resourseID;
    public RecyclerAdapter(Context context,List<Map<String,Object>> list) {
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        ItemViewHolder viewHolder=new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Map<String,Object> item=list.get(position);
        holder.viewstr.setText((String)item.get("str"));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}




public class UserActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);



        String[] keys={"str"};
        String[] strs={"我的词库","单词录入","扩展功能","更多设置","关于"};
        List<Map<String,Object>> itemDatas=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            Map<String,Object> item=new HashMap<>();
            item.put("str",strs[i]);
            itemDatas.add(item);
        }

/*
        //使用RecyclerView控件
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //创建一个GridLayout管理器,设置为4列
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        //设置GridView方向为:垂直方向
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //添加到RecyclerView容器里面
        recyclerView.setLayoutManager(layoutManager);

        //设置自动适应配置的大小
        recyclerView.setHasFixedSize(true);
        //创建适配器对象
        GridAdapter adapter = new GridAdapter(this);
        //把适配器设置到控件里面展示
        recyclerView.setAdapter(adapter);
        //设置Item点击事件
        adapter.setOnItemClickListener(new GridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(MainActivity.this, "你点击了" + position + "位置", Toast.LENGTH_SHORT).show();
            }
        });*/

        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(this,itemDatas);
        RecyclerView recyclerView=(RecyclerView)this.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);



        //view层的控件和业务层的控件，靠id关联和映射赋值，设置布局文件中的Button按钮id进行关联
        Button exit=(Button)findViewById(R.id.exit);
        TextView show_username=(TextView)findViewById(R.id.show_username);


        Bundle data = getIntent().getExtras();
        String username = data.getString("username");

        show_username.setText(username);




        BottomNavigationView bottomnavigationview = findViewById(R.id.bottom_navigation);
        bottomnavigationview.setSelectedItemId(R.id.user);
        bottomnavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch(menuitem.getItemId())
                {
                    case R.id.home:
                        Intent intent =new Intent(getApplicationContext(),HomeActivity.class);
                        intent.putExtras(data);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.search:
                        Intent intent_ =new Intent(getApplicationContext(),SearchActivity.class);
                        intent_.putExtras(data);
                        startActivity(intent_);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.user:
                        return true;
                }
                return false;
            }
        });
    }

    public void exit(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        overridePendingTransition(0,0);
        Toast.makeText(getApplicationContext(), "已退出登录！", Toast.LENGTH_SHORT).show();
    }
}
