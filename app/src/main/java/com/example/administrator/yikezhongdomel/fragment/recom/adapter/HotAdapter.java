package com.example.administrator.yikezhongdomel.fragment.recom.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.yikezhongdomel.R;
import com.example.administrator.yikezhongdomel.fragment.recom.model.HotRecycle;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


/**
 * data;2018/7/8
 * author:任志军
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {
    List<HotRecycle.DataBean> list;
    Context context;

    public HotAdapter(List<HotRecycle.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate( context, R.layout.hotitem, null );
        ViewHolder viewHolder = new ViewHolder( inflate );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
  // holder.content.setText( list.get( position ).getComments().get( position ).getContent());
   holder.createTime.setText( list.get( position ).getCreateTime() );
  holder.playNum.setText( list.get( position ).getComments().get( 1 ).getContent());
       holder.praiseNum.setText( list.get( position ).getComments().get( 2 ).getNickname());
        final String picUrl = list.get(position).getUser().getIcon();
        final Uri uri = Uri.parse(picUrl);
        holder.cover.setImageURI(uri);
    holder.videoUrl.setUp( list.get( position ).getVideoUrl(),list.get( position ).getCreateTime() );


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

  class ViewHolder extends RecyclerView.ViewHolder{

      private final SimpleDraweeView cover;
      private final TextView content;
      private final TextView playNum;
      private final TextView createTime;
      private final TextView praiseNum;
      private final JCVideoPlayer videoUrl;

      public ViewHolder(View itemView) {
          super( itemView );
          cover = itemView.findViewById( R.id.my_image_view );
          content = itemView.findViewById( R.id.title1 );
          createTime = itemView.findViewById( R.id.title2 );
          playNum = itemView.findViewById( R.id.title3);
          praiseNum = itemView.findViewById( R.id.title4 );
          videoUrl = itemView.findViewById( R.id.videocontroller1 );

      }
  }
}
