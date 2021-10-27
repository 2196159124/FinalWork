package com.swufestu.work;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

/*
class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView viewstr;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        viewstr = (TextView) itemView.findViewById(R.id.word1);
    }

}    */
public class MyRecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {
/*
    //图标
    int icons[] = {R.mipmap.g1, R.mipmap.g2, R.mipmap.g3, R.mipmap.g4, R.mipmap.g5, R.mipmap.g6, R.mipmap.g7, R.mipmap.g9,R.mipmap.g10, R.mipmap.g11, R.mipmap.g12, R.mipmap.g13, R.mipmap.g14, R.mipmap.g15, R.mipmap.g16, R.mipmap.g17, R.mipmap.g18, R.mipmap.g19, R.mipmap.g20, R.mipmap.g21, R.mipmap.g22, R.mipmap.g23, R.mipmap.g24, R.mipmap.g25, R.mipmap.g26, R.mipmap.g27, R.mipmap.g28, R.mipmap.g29,};
    //名称
    String names[] = {"浏览器", "输入法", "健康", "效率", "教育", "理财", "阅读", "个性化", "购物", "资讯", "生活", "工具", "出行", "通讯", "拍照", "社交", "影音", "安全", "休闲", "棋牌", "益智", "射击", "体育", "儿童", "网游", "角色", "策略", "经营", "竞速"};

    //上下文
    private Context context;
    private OnItemClickListener onItemClickListener;

    public GridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public GradApterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        return new GradApterViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(GradApterViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    /**
     * 设置数据和复用优化
     */
/*    public class GradApterViewHolder extends RecyclerView.ViewHolder {
        private ImageView pic;
        private TextView name;
        public GradApterViewHolder(View itemView, final GridAdapter.OnItemClickListener listener) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.pic);
            name = (TextView) itemView.findViewById(R.id.name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        //如果用户点击了Item,就获返回当前点击Item的位置
                        listener.onItemClick(v, getPosition());
                    }
                }
            });
        }

        /**
         * 给控件设置数据
         *
         * @param position
         */
/*        public void setData(int position) {
            pic.setImageDrawable(context.getResources().getDrawable(icons[position % icons.length]));
            name.setText(names[position % names.length]);
        }
    }

    //接口回调监听
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    /**
     * 设置条目点击事件方法
     *
     * @param onItemClickListener 回调接口
     */
/*    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }*/



/*
    private ItemData[] listdata;

    public MyRecyclerAdapter(ItemData[] listdata) {
        this.listdata = listdata;
    }

    //ViewHolder类定义
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView2;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.word1);
            this.textView2 = (TextView) itemView.findViewById(R.id.tip1);
            this.relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }

    //当需要创建新的ViewHolder来显示列表项时，Adapter会自动调用onCreateViewHolder方法去创建ViewHolder
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    //此方法完成数据绑定，将数据项和ViewHolder进行关联
    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {
        final ItemData itemData = listdata[position];
        holder.textView2.setText(itemData.getDescription());
        holder.textView.setText(itemData.getDescription());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Click: "+ itemData.getDescription(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    //返回数据个数，对应列表需要显示多少行数据
    @Override
    public int getItemCount() {
        return listdata.length;
    }

*/


        private Context context;
        private List<Map<String, Object>> list;
        private int resourseID;

        public MyRecyclerAdapter(Context context, List<Map<String, Object>> list) {
            this.context = context;
            this.list = list;

        }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            ItemViewHolder viewHolder = new ItemViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            Map<String, Object> item = list.get(position);
            holder.viewstr.setText((String) item.get("str"));

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

}
