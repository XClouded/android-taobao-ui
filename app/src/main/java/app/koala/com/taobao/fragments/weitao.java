package app.koala.com.taobao.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import app.koala.com.taobao.R;
import app.koala.com.taobao.activity.badyActivity;
import app.koala.com.taobao.adapter.Adapter_List_tao;

/**
 * Created by v-rosong on 3/25/2015.
 */
public class weitao extends Fragment {

    private ListView listView_tao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.weitao,null);
        this.initView(view);
        return view;
    }

    private void initView(View view){
        this.listView_tao = (ListView)view.findViewById(R.id.listView_tao);
        this.listView_tao.setAdapter(new Adapter_List_tao(getActivity()));
        this.listView_tao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),badyActivity.class);
                startActivity(intent);
            }
        });
    }
}
