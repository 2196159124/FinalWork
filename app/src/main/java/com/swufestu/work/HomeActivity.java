package com.swufestu.work;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HomeActivity extends AppCompatActivity {
    public int n=0,flag=0,check=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle data = getIntent().getExtras();
        String username = data.getString("username");
        Toast.makeText(getApplicationContext(), "欢迎，"+username, Toast.LENGTH_SHORT).show();



        Map<String, String> map = new HashMap<String,String>();
        Map<Integer,String> key = new HashMap<Integer,String>();
        Map<Integer,String> value = new HashMap<Integer,String>();
        map.put("abolish","[vt.] 废除，取消");map.put("complication","[n.] 复杂，混乱；并发症");
        map.put("eject","[vt.] 逐出，排斥；喷射");map.put("feminine","[adj.] 女性的；女子气的");
        map.put("knight","[n.] 骑士，武士；爵士");map.put("persist","[vi.] 持续，存留");
        map.put("rectify","[vt.] 纠正；矫正；调整");map.put("numerous","[adj.] 许多的；众多的");
        map.put("tackle","[vt.] 解决，应对");map.put("warfare","[n.] 战争，战争状态");

        Set<String> keySet = map.keySet();
        int i = map.size()-1;
        for(java.util.Map.Entry<String, String> entry : map.entrySet()) {
            //将原来MAP的VALUE放入新的MAP的VALUE里面
            key.put(i, entry.getValue());
            //将原来MAP的KEY放入新的MAP的VALUE 里面
            value.put(i, entry.getKey());
            i--;
        }

        TextView word=(TextView)findViewById(R.id.word);
        TextView tips=(TextView)findViewById(R.id.tips);

        n = data.getInt("word_now_n");//初始化
        word.setText(value.get(n));
        tips.setText("点击屏幕显示释义");

        word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==0){
                    tips.setText(key.get(n));
                    flag=1;
                }
                else{
                    word.setText(value.get(n+1));
                    tips.setText("点击屏幕显示释义");
                    flag=0;
                }
                n++;
                if(n==map.size()-1){
                    n=0;
                }
            }
        });





        BottomNavigationView bottomnavigationview = findViewById(R.id.bottom_navigation);

        bottomnavigationview.setSelectedItemId(R.id.home);

        bottomnavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch(menuitem.getItemId())
                {
                    case R.id.home:
                        return true;

                    case R.id.search:
                        data.putInt("word_now_n", n);
                        data.putString("word_now", word.getText().toString());

                        Intent intent_ =new Intent(getApplicationContext(),SearchActivity.class);
                        intent_.putExtras(data);
                        startActivity(intent_);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.user:
                        data.putInt("word_now_n", n);
                        data.putString("word_now", word.getText().toString());

                        Intent intent =new Intent(getApplicationContext(),UserActivity.class);
                        intent.putExtras(data);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}