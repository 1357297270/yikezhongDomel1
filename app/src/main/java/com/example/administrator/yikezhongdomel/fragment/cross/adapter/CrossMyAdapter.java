package com.example.administrator.yikezhongdomel.fragment.cross.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.yikezhongdomel.R;
import com.example.administrator.yikezhongdomel.fragment.cross.model.CrossBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * data;2018/7/9
 * author:任志军
 */

public class CrossMyAdapter extends RecyclerView.Adapter<CrossMyAdapter.ViewHolder> {
    List<CrossBean.DataBean> list;
    Context context;

    public CrossMyAdapter(List<CrossBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate( context, R.layout.crossitem, null );
        ViewHolder viewHolder = new ViewHolder( inflate );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.createTime.setText( list.get( position ).getCreateTime() );
       holder.title1.setText( list.get( position ).getContent() );
        holder.title2.setText( list.get( position ).getUser().getNickname() );
        Glide
                .with(context)
                .load(list.get(position).getUser().getIcon())
                .into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder{

       private final TextView createTime;
       private final SimpleDraweeView icon;
       private final TextView title1;
       private final TextView title2;

       public ViewHolder(View itemView) {
           super( itemView );
           createTime = itemView.findViewById( R.id.tv1 );
           title1 = itemView.findViewById( R.id.tv2 );
           title2 = itemView.findViewById( R.id.tv3 );
           icon = itemView.findViewById( R.id.my_image_view );
       }
   }
}
