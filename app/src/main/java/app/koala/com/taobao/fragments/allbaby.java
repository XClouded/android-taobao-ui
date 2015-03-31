package app.koala.com.taobao.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.koala.com.taobao.R;

/**
 * Created by v-rosong on 2015/3/30.
 */
public class allbaby extends Fragment implements View.OnClickListener {

    private String str_del = "";

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

    private void initView(View view){

    }
}
