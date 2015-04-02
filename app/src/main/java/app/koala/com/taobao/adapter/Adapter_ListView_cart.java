package app.koala.com.taobao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import app.koala.com.taobao.R;

/**
 * Created by Chaos on 3/31/2015.
 */
public class Adapter_ListView_cart extends BaseAdapter {

    private Context context;
    private ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
    private onCheckedChanged listener;

    public Adapter_ListView_cart(Context context) {
        this.context = context;
    }

    public Adapter_ListView_cart(Context context, ArrayList<HashMap<String, Object>> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return (arrayList != null) ? arrayList.size() : 0;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        HolderView holderView = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_listview_cart, null);

            holderView = new HolderView();
            holderView.tv_num = (TextView) convertView.findViewById(R.id.tb_num);
            holderView.tv_type_color = (TextView) convertView.findViewById(R.id.tv_type_color);
            holderView.cb_choice = (CheckBox) convertView.findViewById(R.id.cb_choice);

            convertView.setTag(holderView);
        } else {
            holderView = (HolderView) convertView.getTag();
        }

        if (this.arrayList.size() != 0) {
            holderView.tv_num.setText("x" + this.arrayList.get(position).get("num"));
            holderView.tv_type_color.setText("类型：" + this.arrayList.get(position).get("type").toString() + "  颜色：" + this.arrayList.get(position).get("color").toString());
            holderView.cb_choice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    listener.getChoiceData(position,isChecked);
                }
            });
        }
        return null;
    }

    public void setOnCheckedChanged(onCheckedChanged listener) {
        this.listener = listener;
    }

    public class HolderView {
        private TextView tv_type_color;
        private TextView tv_num;
        private CheckBox cb_choice;
    }

    public interface onCheckedChanged {
        public void getChoiceData(int position, boolean isChoice);
    }
}
