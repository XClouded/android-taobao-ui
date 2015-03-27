package app.koala.com.taobao.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.koala.com.common.view.abSlidingPlayView.AbOnItemClickListener;
import app.koala.com.common.view.abSlidingPlayView.AbSlidingPlayView;
import app.koala.com.common.zxing.activity.CaptureActivity;
import app.koala.com.taobao.R;
import app.koala.com.taobao.activity.badyActivity;
import app.koala.com.taobao.activity.wareActivity;
import app.koala.com.taobao.adapter.Adapter_GridView;
import app.koala.com.taobao.adapter.Adapter_GridView_hot;

/**
 * Created by v-rosong on 3/25/2015.
 */
public class home extends Fragment {

    private TextView tv_top_title;

    private GridView gridView_classify;

    private GridView my_gridView_hot;

    private Adapter_GridView adapter_GridView_classify;
    private Adapter_GridView_hot adapter_gridView_hot;

    private AbSlidingPlayView viewPager;

    private ImageView iv_sao;

    // 分类九宫格的资源文件
    private int[] pic_path_classify = { R.drawable.menu_guide_1, R.drawable.menu_guide_2, R.drawable.menu_guide_3, R.drawable.menu_guide_4, R.drawable.menu_guide_5, R.drawable.menu_guide_6, R.drawable.menu_guide_7, R.drawable.menu_guide_8 };
    // 热门市场的资源文件
    private int[] pic_path_hot = { R.drawable.menu_1, R.drawable.menu_2, R.drawable.menu_3, R.drawable.menu_4, R.drawable.menu_5, R.drawable.menu_6 };
    /**首页轮播的界面的资源*/
    private int[] resId = { R.drawable.show_m1, R.drawable.menu_viewpager_1, R.drawable.menu_viewpager_2, R.drawable.menu_viewpager_3, R.drawable.menu_viewpager_4, R.drawable.menu_viewpager_5 };

    private ArrayList<View> allListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = LayoutInflater.from(getActivity()).inflate(R.layout.home,null);
       this.initView(view);
       return view;
    }

    private void initView(View view){
        this.iv_sao = (ImageView)view.findViewById(R.id.iv_sao);
        this.iv_sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivity(intent);
            }
        });

        this.tv_top_title = (TextView)view.findViewById(R.id.tv_top_title);
        this.tv_top_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),wareActivity.class);
                startActivity(intent);
            }
        });

        this.gridView_classify = (GridView)view.findViewById(R.id.my_gridview);
        this.gridView_classify.setSelector(new ColorDrawable(Color.TRANSPARENT));
        this.gridView_classify.setAdapter(this.adapter_GridView_classify);
        this.gridView_classify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),wareActivity.class);
                startActivity(intent);
            }
        });

        this.my_gridView_hot = (GridView)view.findViewById(R.id.my_gridview_hot);
        this.my_gridView_hot.setSelector(new ColorDrawable(Color.TRANSPARENT));
        this.my_gridView_hot.setAdapter(this.adapter_gridView_hot);
        this.my_gridView_hot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),badyActivity.class);
                startActivity(intent);
            }
        });

        this.viewPager = (AbSlidingPlayView)view.findViewById(R.id.viewPager_menu);
        this.viewPager.setPlayType(1);
        this.viewPager.setSleepTime(3000);

        this.initSlidingView();
    }

    private void initSlidingView(){
        if(this.allListView == null){
            this.allListView = new ArrayList<View>();
        }

        this.allListView.clear();

        for(int i = 0; i < this.resId.length; i++){
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.pic_item,null);
            ImageView imgView = (ImageView)view.findViewById(R.id.pic_item);
            imgView.setImageResource(this.resId[i]);
            this.allListView.add(view);
        }

        this.viewPager.addViews(this.allListView);
        this.viewPager.startPlay();
        this.viewPager.setOnItemClickListener(new AbOnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(),badyActivity.class);
                startActivity(intent);
            }
        });
    }
}















