package charlie.a07073.com.ultimatetrickster.activity;

import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import charlie.a07073.com.ultimatetrickster.R;
import charlie.a07073.com.ultimatetrickster.base.BaseActivity;

public class IQTestActivity extends BaseActivity {
    private int num = 1;// 记录当前是第几页
    private TextView questionTv, testTv, numTv, timeTv;
    private RadioButton answer1Rb, answer2Rb, answer3Rb, answer4Rb;
    private RadioGroup radioGroup;
    private TextView nextBtn;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iqtest);

        initView();
        initTimer(5);
        nextBtn.setClickable(false);
    }

    private void initView() {
        questionTv = (TextView) findViewById(R.id.iq_test_question);
        testTv = (TextView) findViewById(R.id.iq_test_1);
        numTv = (TextView) findViewById(R.id.iq_test_num);
        timeTv = (TextView) findViewById(R.id.iq_test_time);

        answer1Rb = (RadioButton) findViewById(R.id.iq_test_answer_1);
        answer2Rb = (RadioButton) findViewById(R.id.iq_test_answer_2);
        answer3Rb = (RadioButton) findViewById(R.id.iq_test_answer_3);
        answer4Rb = (RadioButton) findViewById(R.id.iq_test_answer_4);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        nextBtn = (TextView) findViewById(R.id.next_btn);
        imageView = (ImageView) findViewById(R.id.iq_test_iv);
    }

    public void nextClick(View view) {// 下一步点击事件
        if (!answer1Rb.isChecked() && !answer2Rb.isChecked() && !answer3Rb.isChecked() && !answer4Rb.isChecked()) {
            Snackbar.make(questionTv, "Please select at least one option", Snackbar.LENGTH_SHORT).show();
        } else {
            radioGroup.clearCheck();
            nextBtn.setClickable(false);

            num++;
            if (num == 2) {
                questionTv.setText(getResources().getString(R.string.q2));
                testTv.setText(getResources().getString(R.string.q2_));
                answer1Rb.setText(getResources().getString(R.string.q2_a1));
                answer2Rb.setText(getResources().getString(R.string.q2_a2));
                answer3Rb.setText(getResources().getString(R.string.q2_a3));
                answer4Rb.setText(getResources().getString(R.string.q2_a4));
                initTimer(5);
            } else if (num == 3) {
                questionTv.setText(getResources().getString(R.string.q3));
                testTv.setText(getResources().getString(R.string.q3_));
                answer1Rb.setText(getResources().getString(R.string.q3_a1));
                answer2Rb.setText(getResources().getString(R.string.q3_a2));
                answer3Rb.setText(getResources().getString(R.string.q3_a3));
                answer4Rb.setText(getResources().getString(R.string.q3_a4));
                initTimer(10);
            } else if (num == 4) {
                questionTv.setText(getResources().getString(R.string.q4));
                testTv.setText(getResources().getString(R.string.q4_));
                answer1Rb.setText(getResources().getString(R.string.q4_a1));
                answer2Rb.setText(getResources().getString(R.string.q4_a2));
                answer3Rb.setText(getResources().getString(R.string.q4_a3));
                answer4Rb.setText(getResources().getString(R.string.q4_a4));
                initTimer(10);
            } else if (num == 5) {
                initTimer(10);
                questionTv.setText(getResources().getString(R.string.q5));
                testTv.setText(getResources().getString(R.string.q5_));
                answer1Rb.setText(getResources().getString(R.string.q5_a1));
                answer2Rb.setText(getResources().getString(R.string.q5_a2));
                answer3Rb.setText(getResources().getString(R.string.q5_a3));
                answer4Rb.setText(getResources().getString(R.string.q5_a4));
            } else {
                Snackbar.make(questionTv, "end..", Snackbar.LENGTH_SHORT).show();
                num = 5;
                return;
            }

        }


        numTv.setText(num + "/5");

    }

    public void initTimer(int i) {
        CountDownTimer countDownTimer = new CountDownTimer(i * 1000, 1000) {
            @Override
            public void onTick(long l) {
                timeTv.setText(String.valueOf(l / 1000));

                if(num == 3 && l/1000 == 5){// 显示图片
                    imageView.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFinish() {
                if(num == 3 ){// 图片消失
                    imageView.setVisibility(View.GONE);
                }
                timeTv.setText("0");
                nextBtn.setClickable(true);
            }
        };
        countDownTimer.start();
    }
}
