package app.koala.com.taobao.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.koala.com.taobao.Data.Data;
import app.koala.com.taobao.R;

/**
 * Created by v-rosong on 3/25/2015.
 */
public class cart extends Fragment implements View.OnClickListener {

    private TextView bt_cart_all,bt_cart_low,bt_cart_stock,bt_cart_edit;

    private View show_cart_all,show_cart_low,show_cart_stock;

    private allbaby allbaby;
    private lowbaby lowbaby;
    private stockbaby stockbaby;
    private boolean isDel =true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.cart,null);
        this.initView(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_top_edit:
                if(this.allbaby != null && this.isDel){
                    this.removeFragment(this.allbaby);
                    this.allbaby = null;
                    this.allbaby = new allbaby("删除");
                    this.addFragment(this.allbaby);
                    this.showFragment(this.allbaby);
                    this.isDel = false;
                    this.bt_cart_edit.setText("完成");

                    Data.Allprice_cart = 0;
                }else if(!this.isDel && this.allbaby != null){
                    this.removeFragment(this.allbaby);
                    this.allbaby = null;
                    this.allbaby = new allbaby();
                    this.addFragment(this.allbaby);
                    this.showFragment(this.allbaby);
                    this.isDel = true;

                    Data.Allprice_cart = 0;
                    this.bt_cart_edit.setText("编辑");
                }
                break;
            case R.id.bt_cart_all:
                break;
            case R.id.bt_cart_low:
                break;
            case R.id.bt_cart_stock:
                break;
            default:
                break;
        }
    }

    private void initView(View view){
        ((TextView)view.findViewById(R.id.tv_top_txtTitle)).setText("我的购物车");

        this.bt_cart_all = (TextView)view.findViewById(R.id.bt_cart_all);
        this.bt_cart_all.setOnClickListener(this);

        this.bt_cart_low = (TextView)view.findViewById(R.id.bt_cart_low);
        this.bt_cart_low.setOnClickListener(this);

        this.bt_cart_stock = (TextView)view.findViewById(R.id.bt_cart_stock);
        this.bt_cart_stock.setOnClickListener(this);

        this.bt_cart_edit = (TextView)view.findViewById(R.id.tv_top_edit);
        this.bt_cart_edit.setOnClickListener(this);

        this.show_cart_all = view.findViewById(R.id.show_cart_all);
        this.show_cart_low = view.findViewById(R.id.show_cart_low);
        this.show_cart_stock = view.findViewById(R.id.show_cart_stock);

        this.allbaby = new allbaby();
        this.addFragment(this.allbaby);
        this.showFragment(this.allbaby);
    }

    private void addFragment(Fragment fragment){
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.add(R.id.show_cart_view,fragment);
        ft.commitAllowingStateLoss();
    }

    private void removeFragment(Fragment fragment){
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commitAllowingStateLoss();
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        if(this.allbaby != null){
            ft.hide(this.allbaby);
        }

        if(this.lowbaby != null){
            ft.hide(this.lowbaby);
        }

        if(this.stockbaby != null){
            ft.hide(this.stockbaby);
        }

        ft.show(fragment);
        ft.commitAllowingStateLoss();
    }
}















