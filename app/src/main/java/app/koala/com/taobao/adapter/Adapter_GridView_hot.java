package app.koala.com.taobao.adapter;

//// Created by Chaos on 3/25/2015.

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import app.koala.com.taobao.R;

public class Adapter_GridView_hot extends BaseAdapter {

    private Context context;
    private int[] data;

    public Adapter_GridView_hot(Context context,int[] data){
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return this.data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView=null;
        if (convertView==null) {
            holderView=new HolderView();
            convertView= LayoutInflater.from(context).inflate(R.layout.adapter_grid_hot_home, null);
            holderView.iv_pic=(ImageView) convertView.findViewById(R.id.iv_adapter_grid_pic);
            convertView.setTag(holderView);
        }else {
            holderView=(HolderView) convertView.getTag();
        }


        holderView.iv_pic.setImageResource(data[position]);


        return convertView;
    }

    public class HolderView {
        private ImageView iv_pic;
    }
}
