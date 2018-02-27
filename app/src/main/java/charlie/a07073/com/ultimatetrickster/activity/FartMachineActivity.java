package charlie.a07073.com.ultimatetrickster.activity;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import charlie.a07073.com.ultimatetrickster.R;
import charlie.a07073.com.ultimatetrickster.base.BaseActivity;

public class FartMachineActivity extends BaseActivity {
    private TextView secondTv;
    private CountDownTimer timer;

    private MediaPlayer mp;//mediaPlayer对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fart_machine);
        initView();

        mp=MediaPlayer.create(FartMachineActivity.this, R.raw.fart);//创建mediaplayer对象

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer arg0) {
                play();//重新开始播放
            }
        });
    }

    private void initView() {
        secondTv = (TextView) findViewById(R.id.time_second_tv);

        timer = new CountDownTimer(10*1000,1000) {
            @Override
            public void onTick(long l) {
                secondTv.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                secondTv.setText(String.valueOf(0));
                secondTv.setText("Play...");
                play();
            }
        };

        timer.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
    }

    private void play(){
        try{
            mp.reset();
            mp=MediaPlayer.create(this, R.raw.fart);//重新设置要播放的音频
            mp.start();//开始播放
        }catch(Exception e){
            e.printStackTrace();//输出异常信息
        }
    }

    protected void onDestroy() {
        // TODO Auto-generated method stub
        if(mp.isPlaying()){
            mp.stop();
        }
        mp.release();//释放资源
        super.onDestroy();
    }
}
