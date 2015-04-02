package app.koala.com.taobao.activity;

import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import app.koala.com.common.view.lesogo.cu.custom.ScaleView.HackyViewPager;
import app.koala.com.taobao.R;
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

    }

    private void initViewPager(){}

    private void setSaveCollection(){}

    private void getSaveCollection(){}
}
