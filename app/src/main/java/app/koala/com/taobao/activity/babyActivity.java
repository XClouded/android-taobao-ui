package app.koala.com.taobao.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import app.koala.com.common.view.lesogo.cu.custom.ScaleView.HackyViewPager;
import app.koala.com.taobao.R;
import app.koala.com.taobao.adapter.Adapter_ListView_detail;
import app.koala.com.taobao.views.BabyPopWindow;

/**
 * Created by Chaos on 4/2/2015.
 */
public class babyActivity extends FragmentActivity implements BabyPopWindow.OnItemClickListener,View.OnClickListener{

    NfcAdapter nfcAdapter;

    private HackyViewPager viewPager;
    private ArrayList<View> allListView;
    private int[] resId = { R.drawable.detail_show_1, R.drawable.detail_show_2, R.drawable.detail_show_3, R.drawable.detail_show_4, R.drawable.detail_show_5, R.drawable.detail_show_6 };
    private ListView listView;
    private ImageView iv_baby_collection;

    private BabyPopWindow popWindow;

    private LinearLayout all_choice_layout = null;

    boolean isClickBuy = false;

    private static boolean isCollection = false;

    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.baby);

        this.getSaveCollection();

        this.initView();

        this.popWindow =new BabyPopWindow(this);
        this.popWindow.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onClickOKPop() {

    }

    private void initView(){
        this.nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(this.nfcAdapter == null){
            Toast.makeText(this,"This device does not support NFC",Toast.LENGTH_SHORT).show();
        }

        ((ImageView)findViewById(R.id.iv_back)).setOnClickListener(this);
        ((ImageView)findViewById(R.id.put_in)).setOnClickListener(this);
        ((ImageView)findViewById(R.id.buy_now)).setOnClickListener(this);

        this.iv_baby_collection = (ImageView)findViewById(R.id.iv_baby_collection);
        this.iv_baby_collection.setOnClickListener(this);

        this.all_choice_layout = (LinearLayout)findViewById((R.id.all_choice_layout));

        this.listView = (ListView)findViewById(R.id.listView_Detail);
        this.listView.setFocusable(false);
        this.listView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        this.listView.setAdapter(new Adapter_ListView_detail(this));
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri uri = Uri.parse("");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        this.initViewPager();

        if(isCollection){
            this.iv_baby_collection.setImageResource(R.drawable.second_2_collection);
        }
    }

    private void initViewPager(){
        if(this.allListView != null){
            this.allListView.clear();
            this.allListView = null;
        }
        this.allListView= new ArrayList<View>();
        for(int i = 0;i<this.resId.length;i++){
            View view = LayoutInflater.from(this).inflate(R.layout.pic_item,null);
            ImageView imageView = (ImageView)view.findViewById(R.id.pic_item);
            imageView.setImageResource(resId[i]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(babyActivity.this,showBigPicture.class);
                    intent.putExtra("position",position);
                }
            });

            this.allListView.add(view);
        }

        this.viewPager = (HackyViewPager)findViewById(R.id.iv_baby);
        this.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int index) {
                position = index;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        this.viewPager.setAdapter(new ViewPagerAdapter());
    }

    private void setSaveCollection(){}

    private void getSaveCollection(){}

    private class ViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return allListView.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == (View)object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = allListView.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
