package app.koala.com.taobao.views;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;

/**
 * Created by Chaos on 4/2/2015.
 */
public class BabyPopWindow implements PopupWindow.OnDismissListener,View.OnClickListener {

    private OnItemClickListener listener;

    public BabyPopWindow(Context contenxt){

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDismiss() {

    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public interface OnItemClickListener{
        public void onClickOKPop();
    }
}
