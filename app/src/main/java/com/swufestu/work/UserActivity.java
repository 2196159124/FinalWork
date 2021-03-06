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
        String[] strs={"????????????","????????????","????????????","????????????","??????"};
        List<Map<String,Object>> itemDatas=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            Map<String,Object> item=new HashMap<>();
            item.put("str",strs[i]);
            itemDatas.add(item);
        }

/*
        //??????RecyclerView??????
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //????????????GridLayout?????????,?????????4???
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        //??????GridView?????????:????????????
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //?????????RecyclerView????????????
        recyclerView.setLayoutManager(layoutManager);

        //?????????????????????????????????
        recyclerView.setHasFixedSize(true);
        //?????????????????????
        GridAdapter adapter = new GridAdapter(this);
        //???????????????????????????????????????
        recyclerView.setAdapter(adapter);
        //??????Item????????????
        adapter.setOnItemClickListener(new GridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(MainActivity.this, "????????????" + position + "??????", Toast.LENGTH_SHORT).show();
            }
        });*/

        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(this,itemDatas);
        RecyclerView recyclerView=(RecyclerView)this.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);



        //view???????????????????????????????????????id????????????????????????????????????????????????Button??????id????????????
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
        Toast.makeText(getApplicationContext(), "??????????????????", Toast.LENGTH_SHORT).show();
    }
}
