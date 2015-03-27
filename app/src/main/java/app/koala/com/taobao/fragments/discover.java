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
import android.widget.Toast;

import app.koala.com.common.zxing.activity.CaptureActivity;
import app.koala.com.taobao.R;
import app.koala.com.taobao.activity.wareActivity;
import app.koala.com.taobao.adapter.Adapter_GridView;

/**
 * Created by v-rosong on 3/25/2015.
 */
public class discover extends Fragment {

    private GridView my_gridView_life;
    private GridView my_gridView_app;

    private Adapter_GridView adapter_gridView_life;
    private Adapter_GridView adapter_gridView_app;

    //资源文件
    private int[] pic_path_life={R.drawable.find_g_1,R.drawable.find_g_2,R.drawable.find_g_3,R.drawable.find_g_4};
    private int[] pic_path_app={R.drawable.find_g_5,R.drawable.find_g_6,R.drawable.find_g_7,R.drawable.find_g_8};

    private LinearLayout ll_ShaoYiShao;
    private LinearLayout ll_game;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.discover,null);
        this.initView(view);
        return view;
    }

    private void initView(View view){
        this.ll_ShaoYiShao = (LinearLayout)view.findViewById(R.id.ll_dicover_shao);
        this.ll_ShaoYiShao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivity(intent);
            }
        });

        this.ll_game = (LinearLayout)view.findViewById(R.id.ll_dicover_game);
        this.ll_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"此功能暂未开放",Toast.LENGTH_SHORT).show();
            }
        });

        this.adapter_gridView_life = new Adapter_GridView(getActivity(),this.pic_path_life);
        this.my_gridView_life = (GridView)view.findViewById(R.id.gridView_find_life);
        this.my_gridView_life.setSelector(new ColorDrawable(Color.TRANSPARENT));
        this.my_gridView_life.setAdapter(this.adapter_gridView_life);
        this.my_gridView_life.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(getActivity(),wareActivity.class);
                startActivity(intent);
            }
        });

        this.adapter_gridView_app = new Adapter_GridView(getActivity(),this.pic_path_app);
        this.my_gridView_app = (GridView)view.findViewById(R.id.gridView_find_app);
        this.my_gridView_app.setSelector(new ColorDrawable(Color.TRANSPARENT));
        this.my_gridView_app.setAdapter(this.adapter_gridView_app);
        this.my_gridView_app.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),wareActivity.class);
                startActivity(intent);
            }
        });
    }
}


















