package app.koala.com.taobao;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;

import app.koala.com.taobao.Data.Data;
import app.koala.com.taobao.fragments.cart;
import app.koala.com.taobao.fragments.discover;
import app.koala.com.taobao.fragments.home;
import app.koala.com.taobao.fragments.user;
import app.koala.com.taobao.fragments.weitao;
import app.koala.com.taobao.tools.IBtnCallListener;


public class main extends FragmentActivity implements View.OnClickListener, IBtnCallListener {

    private ImageView[] btn_menu = new ImageView[5];

    private int[] bt_menu_id = {R.id.iv_menu_0,R.id.iv_menu_1,R.id.iv_menu_2,R.id.iv_menu_3,R.id.iv_menu_4};

    // 界面底部的选中菜单按钮资源
    private int[] select_on = { R.drawable.guide_home_on, R.drawable.guide_tfaccount_on, R.drawable.guide_discover_on, R.drawable.guide_cart_on, R.drawable.guide_account_on };
    // 界面底部的未选中菜单按钮资源
    private int[] select_off = { R.drawable.bt_menu_0_select, R.drawable.bt_menu_1_select, R.drawable.bt_menu_2_select, R.drawable.bt_menu_3_select, R.drawable.bt_menu_4_select };

    private home home;
    private weitao weitao;
    private discover discover;
    private cart cart;
    private user user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.getSaveData();
        this.initView();
    }

    @Override
    public void transferMsg() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_menu_0:
                if(this.home == null){
                    this.home = new home();
                    this.addFragment(this.home);
                    this.showFragment(this.home);
                }else{
                    if(this.home.isHidden()){
                        this.showFragment(this.home);
                    }
                }
                break;

            case R.id.iv_menu_1:
                if(this.weitao == null){
                    this.weitao = new weitao();
                    this.addFragment(this.weitao);
                    this.showFragment(this.weitao);
                }else{
                    if(this.weitao.isHidden()){
                        this.showFragment(this.weitao);
                    }
                }
                break;

            case R.id.iv_menu_2:
                if(this.discover == null){
                    this.discover = new discover();
                    this.addFragment(this.discover);
                    this.showFragment(this.discover);
                }else{
                    if(this.discover.isHidden()){
                        this.showFragment(this.discover);
                    }
                }
                break;

            case R.id.iv_menu_3:
                if(this.cart == null){
                    this.cart = new cart();
                    this.addFragment(this.cart);
                    this.showFragment(this.cart);
                }else{
                    if(this.cart.isHidden()){
                        this.showFragment(this.cart);
                    }
                }
                break;

            case R.id.iv_menu_4:
                if(this.user == null){
                    this.user = new user();
                    this.addFragment(this.user);
                    this.showFragment(this.user);
                }else{
                    if(this.user.isHidden()){
                        this.showFragment(this.user);
                    }
                }
                break;
        }

        for(int i = 0 ;i < this.btn_menu.length;i++){
            this.btn_menu[i].setImageResource(this.select_off[i]);
            if(view.getId() == this.bt_menu_id[i]){
                this.btn_menu[i].setImageResource(this.select_on[i]);
            }
        }
    }

    private void getSaveData(){
        HashMap<String,Object> hashMap = new HashMap<String, Object>();

        SharedPreferences sp = getSharedPreferences("SAVE_CART", Context.MODE_PRIVATE);
        int size = sp.getInt("ArrayCart_size",0);
        for(int i = 0 ; i < size; i++){
            hashMap.put("type",sp.getString("ArrayCart_type_" + i, ""));
            hashMap.put("color",sp.getString("ArrayCart_color_" + i, ""));
            hashMap.put("num",sp.getString("ArrayCart_num_" + i, ""));
            Data.arrayList_cart.add(hashMap);
        }
    }

    private void initView(){
        for(int i = 0;i < this.btn_menu.length; i++){
            btn_menu[i] = (ImageView)findViewById(bt_menu_id[i]);
            btn_menu[i].setOnClickListener(this);
        }

        if(this.home == null){
            this.home = new home();
            this.addFragment(this.home);
        }

        this.showFragment(this.home);
        this.btn_menu[0].setImageResource(this.select_on[0]);
    }

    private void addFragment(Fragment fragment){
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.add(R.id.show_layout, fragment);
        ft.commit();
    }

    private void removeFragment(Fragment fragment){
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.cu_push_right_in,R.anim.cu_push_left_out);

        if(this.home != null){
            ft.hide(this.home);
        }

        if(this.weitao != null){
            ft.hide(this.weitao);
        }

        if(this.cart != null){
            ft.hide(this.cart);
        }

        if(this.user != null){
            ft.hide(this.user);
        }

        if(this.discover != null){
            ft.hide(this.discover);
        }

        ft.show(fragment);
        ft.commit();
    }
}


























