package com.example.mvprecycle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvprecycle.R;
import com.example.mvprecycle.bean.ReaBean;

import java.util.List;

/**
 * data;2018/7/12
 * author:任志军
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<ReaBean.DataBean> list;
    Context context;

    public MyAdapter(List<ReaBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate( context, R.layout.item, null );
        ViewHolder viewHolder = new ViewHolder( inflate );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
holder.title1.setText( list.get( position ).getText());
        holder.title2.setText( list.get( position ).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder{

       private final TextView title1;
       private final TextView title2;

       public ViewHolder(View itemView) {
           super( itemView );
           title1 = itemView.findViewById( R.id.tv1 );
           title2 = itemView.findViewById( R.id.tv2 );

       }
   }
}
