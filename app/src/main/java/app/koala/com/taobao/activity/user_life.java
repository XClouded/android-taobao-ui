package app.koala.com.taobao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.util.Random;

import app.koala.com.taobao.R;
import app.koala.com.taobao.views.ScratchTextView;

/**
 * Created by v-rosong on 2015/3/30.
 */
public class user_life extends Activity {
    private ScratchTextView tv_Scratch;

    private String[] str_reward = {"谢谢惠顾","恭喜！奖励5毛","鼓励奖，加油"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user_life);

        this.tv_Scratch = (ScratchTextView)findViewById(R.id.tv_Scratch);
        this.tv_Scratch.initScratchCard(0xFFCECED1,3,1f);
        this.tv_Scratch.setText(this.str_reward[this.getRandom()]);
    }

    private int getRandom(){
        Random random = new Random();
        int number = random.nextInt(10);

        return number;
    }
}
