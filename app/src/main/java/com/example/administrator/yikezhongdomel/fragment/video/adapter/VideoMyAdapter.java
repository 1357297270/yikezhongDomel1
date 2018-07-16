package com.example.administrator.yikezhongdomel.fragment.video.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.yikezhongdomel.R;
import com.example.administrator.yikezhongdomel.fragment.funny.adapter.FunnyMyAdapter;
import com.example.administrator.yikezhongdomel.fragment.video.model.VideoBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * data;2018/7/10
 * author:任志军
 */

public class VideoMyAdapter extends RecyclerView.Adapter<VideoMyAdapter.ViewHolder>{
    List<VideoBean.DataBean> list;
    Context context;

    public VideoMyAdapter(List<VideoBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate( context, R.layout.videoitem, null );
        ViewHolder viewHolder = new ViewHolder( inflate );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide
                .with(context)
                .load(list.get(position).getCover())
                .into(holder.img);

       // holder.jcVideoPlayer.setUp( list.get( position ).getVideoUrl(),list.get( position ).getCreateTime() );
   holder.img.setOnClickListener( new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           if (mOnItemClick!=null){
               mOnItemClick.onImageClick( v,position);
           }

       }
   } );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder{

       private final ImageView img;

       // private final JCVideoPlayer jcVideoPlayer;
       public ViewHolder(View itemView) {
           super( itemView );
         //  jcVideoPlayer = itemView.findViewById( R.id.videocontroller );
           img = itemView.findViewById( R.id.img );
       }
   }
    public interface OnItemClick{
        void onImageClick(View view,int position);


    }

    private OnItemClick mOnItemClick;

    public void setOnItemClick( OnItemClick onItemClick){
        this.mOnItemClick = onItemClick;
    }
}
