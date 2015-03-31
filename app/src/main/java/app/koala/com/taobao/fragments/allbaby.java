package app.koala.com.taobao.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import app.koala.com.taobao.R;
import app.koala.com.taobao.adapter.Adapter_ListView_cart;
import app.koala.com.taobao.tools.IBtnCallListener;

/**
 * Created by v-rosong on 2015/3/30.
 */
public class allbaby extends Fragment implements  View.OnClickListener,IBtnCallListener,Adapter_ListView_cart.onCheckedChanged {

    IBtnCallListener btnCallListener;
    private TextView tv_goShop,tv_cart_Allprice,tv_cart_buy_Ordel;
    private LinearLayout ll_cart;
    private ListView listView_cart;
    private CheckBox cb_cart_all;
    private Adapter_ListView_cart adapter;
    private String str_del = "结算(0)";
    private boolean[] is_choice;

    public allbaby(){

    }

    public allbaby(String del){
        this.str_del = del;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.cart_all_f,null);
        this.initView(view);
        return view;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void transferMsg() {

    }

    @Override
    public void getChoiceData(int position, boolean isChoice) {

    }

    private void initView(View view){
        this.tv_goShop = (TextView)view.findViewById(R.id.tv_goShop);
        this.tv_cart_Allprice = (TextView)view.findViewById(R.id.tv_cart_Allprice);

        this.tv_cart_buy_Ordel = (TextView)view.findViewById(R.id.tv_cart_buy_or_del);
        this.tv_cart_buy_Ordel.setText(this.str_del);

        this.cb_cart_all = (CheckBox)view.findViewById(R.id.cb_cart_all);
        this.cb_cart_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int isChoice_all = 0;
                if(isChecked){}
            }
        });
    }
}





















