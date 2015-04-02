package app.koala.com.taobao.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import app.koala.com.taobao.Data.Data;
import app.koala.com.taobao.R;
import app.koala.com.taobao.activity.babyActivity;
import app.koala.com.taobao.adapter.Adapter_ListView_cart;
import app.koala.com.taobao.tools.IBtnCallListener;

/**
 * Created by v-rosong on 2015/3/30.
 */
public class allbaby extends Fragment implements View.OnClickListener, IBtnCallListener, Adapter_ListView_cart.onCheckedChanged {

    IBtnCallListener btnCallListener;
    private TextView tv_goShop, tv_cart_Allprice, tv_cart_buy_Ordel;
    private LinearLayout ll_cart;
    private ListView listView_cart;
    private CheckBox cb_cart_all;
    private Adapter_ListView_cart adapter;
    private String str_del = "结算(0)";
    private boolean[] is_choice;

    public allbaby(String del) {
        this.str_del = del;
    }

    public allbaby() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.cart_all_f, null);
        this.initView(view);
        return view;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onAttach(Activity activity) {
        this.btnCallListener = (IBtnCallListener) activity;
        super.onAttach(activity);
    }

    @Override
    public void transferMsg() {
        System.out.println("由Activity中传送来的消息");
    }

    @Override
    public void getChoiceData(int position, boolean isChoice) {
        if (isChoice) {
            if (Data.arrayList_cart.size() != 0) {
                Data.Allprice_cart += Float.valueOf(Data.arrayList_cart.get(position).get("num").toString()) * 49;
            }
        } else {
            if (Data.arrayList_cart.size() != 0) {
                Data.Allprice_cart -= Float.valueOf(Data.arrayList_cart.get(position).get("num").toString()) * 49;
            }
        }

        int num_choice = 0;
        for (int i = 0; i < Data.arrayList_cart.size(); i++) {
            if (null != this.listView_cart.getChildAt(i) && ((CheckBox) (this.listView_cart.getChildAt(i)).findViewById(R.id.cb_choice)).isChecked()) {
                num_choice += 1;
                this.is_choice[i] = true;
            }
        }

        if (num_choice == Data.arrayList_cart.size()) {
            this.cb_cart_all.setChecked(true);
        } else {
            this.cb_cart_all.setChecked(false);
        }

        this.tv_cart_Allprice.setText("合计：￥" + Data.Allprice_cart + "");
        System.out.println("选择的位置--->" + position);
    }

    private void initView(View view) {
        this.tv_goShop = (TextView) view.findViewById(R.id.tv_goShop);
        this.tv_cart_Allprice = (TextView) view.findViewById(R.id.tv_cart_Allprice);

        this.tv_cart_buy_Ordel = (TextView) view.findViewById(R.id.tv_cart_buy_or_del);
        this.tv_cart_buy_Ordel.setText(this.str_del);

        this.cb_cart_all = (CheckBox) view.findViewById(R.id.cb_cart_all);
        this.cb_cart_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int isChoice_all = 0;
                if (isChecked) {
                    for (int i = 0; i < Data.arrayList_cart.size(); i++) {
                        ((CheckBox) (listView_cart.getChildAt(i)).findViewById(R.id.cb_choice)).setChecked(true);
                    }
                } else {
                    for (int i = 0; i < Data.arrayList_cart.size(); i++) {
                        if (((CheckBox) (listView_cart.getChildAt(i)).findViewById(R.id.cb_choice)).isChecked()) {
                            isChoice_all += 1;
                        }
                    }

                    if (isChoice_all == Data.arrayList_cart.size()) {
                        for (int i = 0; i < Data.arrayList_cart.size(); i++) {
                            ((CheckBox) (listView_cart.getChildAt(i)).findViewById(R.id.cb_choice)).setChecked(false);
                        }
                    }
                }
            }
        });

        this.ll_cart = (LinearLayout) view.findViewById(R.id.ll_cart);
        this.listView_cart = (ListView) view.findViewById(R.id.listView_cart);

        if (Data.arrayList_cart != null && Data.arrayList_cart.size() != 0) {
            this.adapter = new Adapter_ListView_cart(getActivity(), Data.arrayList_cart);
            this.adapter.setOnCheckedChanged(this);
            this.listView_cart.setAdapter(this.adapter);
            this.ll_cart.setVisibility(View.GONE);
        } else {
            this.ll_cart.setVisibility(View.VISIBLE);
        }

        this.listView_cart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), babyActivity.class);
                startActivity(intent);
            }
        });

        this.tv_cart_buy_Ordel.setOnClickListener(this);
        this.tv_goShop.setOnClickListener(this);
    }

    public static boolean[] deleteByIndex(boolean[] array, int index) {
        boolean[] newArray = new boolean[array.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else {
                newArray[i] = array[i + 1];
            }
        }
        return newArray;
    }
}





















