package app.koala.com.taobao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import app.koala.com.taobao.R;

/**
 * Created by Chaos on 3/25/2015.
 */
public class Adapter_List_tao extends BaseAdapter {
    private Context context;

    private int[] picId={R.drawable.tao_3,R.drawable.detail_show_1,R.drawable.detail_show_2,R.drawable.detail_show_3,R.drawable.detail_show_4,R.drawable.detail_show_5,R.drawable.detail_show_6};

    public Adapter_List_tao(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return picId.length;
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
        HolderView holderView = null;
        if(convertView == null){
            holderView = new HolderView();
            convertView= LayoutInflater.from(context).inflate(R.layout.adapter_listview_tao,null);
            holderView.iv_pic = (ImageView)convertView.findViewById(R.id.iv_adapter_list_pic);

            convertView.setTag(holderView);
        }else {
            holderView = (HolderView)convertView.getTag();
        }

        holderView.iv_pic.setImageResource(picId[position]);
        return convertView;
    }

    public class HolderView {
        private ImageView iv_pic;
    }
}
