package app.koala.com.taobao.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.koala.com.taobao.R;
import app.koala.com.taobao.activity.helloSensor;
import app.koala.com.taobao.adapter.Adapter_GridView;

/**
 * Created by v-rosong on 3/25/2015.
 */
public class user extends Fragment implements View.OnClickListener {
    private GridView my_gridview_user;

    private Adapter_GridView adapter_gridView;

    //资源文件
    private int[] pic_path={R.drawable.user_3,R.drawable.user_4,R.drawable.user_5,R.drawable.user_6, R.drawable.user_7};

    private LinearLayout ll_user_life;
    private LinearLayout ll_user_members;
    private LinearLayout ll_user_store;
    private LinearLayout ll_user_opinion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ////View view = LayoutInflater.from(getActivity()).inflate(R.layout.user,null);
        ////this.initView(view);
        ////return view;
        return null;
    }

    @Override
    public void onClick(View v) {

    }

    private void initView(View view){
        ((TextView)view.findViewById(R.id.tv_top_txtTitle)).setText("我的淘宝");

//        this.ll_user_life = (LinearLayout)view.findViewById(R.id.ll_user_life);
//        this.ll_user_life.setOnClickListener(this);
//
//        this.ll_user_members= (LinearLayout)view.findViewById(R.id.ll_user_members);
//        this.ll_user_members.setOnClickListener(this);
//
//        this.ll_user_store = (LinearLayout)view.findViewById(R.id.ll_user_store);
//        this.ll_user_store.setOnClickListener(this);
//
//        this.ll_user_opinion = (LinearLayout)view.findViewById(R.id.ll_user_opinion);
//        this.ll_user_opinion.setOnClickListener(this);
//
//        this.adapter_gridView =new Adapter_GridView(getActivity(),this.pic_path);
//        this.my_gridview_user = (GridView)view.findViewById(R.id.gridView_user);
//        this.my_gridview_user.setSelector(new ColorDrawable(Color.TRANSPARENT));
//        this.my_gridview_user.setAdapter(this.adapter_gridView);
//        this.my_gridview_user.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(),helloSensor.class);
//                startActivity(intent);
//            }
//        });
    }
}
