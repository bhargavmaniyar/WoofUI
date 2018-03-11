package com.example.a.woofui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.api.ApiVolley;
import com.example.a.model.WalkInfo;
import com.example.a.model.WalkReq;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by apple on 2018/3/4.
 */

public class RequestedWalk extends Fragment {

    RequestedRecyclerAdapter adapter;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycle_view_list,container,false);
        recyclerView = view.findViewById(R.id.recyclerview);
        ApiVolley api=new ApiVolley(getContext());
        api.getRequestedWalkList(this,2);
        return view;
    }
    public  void populateData(List<WalkReq> list)
    {
        adapter=new RequestedRecyclerAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }



}
class RequestedRecyclerAdapter extends RecyclerView.Adapter<com.example.a.woofui.RequestedRecyclerAdapter.ViewHolder> implements View.OnClickListener{
    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.cancel:
                Toast.makeText(view.getContext(),"cancel"+view.getTag(),Toast.LENGTH_SHORT).show();
                break;

        }


    }



    List<WalkReq> data;
    int layout;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,date,time;
        Button cancel;
        CircleImageView profileImg;
        public ViewHolder(View view) {
            super(view);
            profileImg=(CircleImageView)view.findViewById(R.id.profile_image);
            name=(TextView)view.findViewById(R.id.name);
            date=(TextView)view.findViewById(R.id.date);
            time=(TextView)view.findViewById(R.id.time);
            cancel=(Button)view.findViewById(R.id.cancel);
            //this.textView=(Viw)textView;

        }
    }
    public RequestedRecyclerAdapter(List<WalkReq> dataSet) {

        this.data=dataSet;

    }


    @Override
    public void onBindViewHolder(com.example.a.woofui.RequestedRecyclerAdapter.ViewHolder holder, int position) {

        //  holder.textView.setText(dataSet[position]);
        //holder.profileImg.setImageURI();
        holder.name.setText(data.get(position).getReqId().getDogId().getName());
        holder.date.setText(data.get(position).getWalkReqDate().toString());
        holder.time.setText(data.get(position).getWalkReqDate().toString());
        holder.cancel.setOnClickListener(this);
        holder.cancel.setTag(data.get(position).getWalkReqId());


    }


    @Override
    public com.example.a.woofui.RequestedRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_requested,parent,false);
        com.example.a.woofui.RequestedRecyclerAdapter.ViewHolder viewHolder=new com.example.a.woofui.RequestedRecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}


