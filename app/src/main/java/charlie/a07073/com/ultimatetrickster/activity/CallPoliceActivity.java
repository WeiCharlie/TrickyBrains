package charlie.a07073.com.ultimatetrickster.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import charlie.a07073.com.ultimatetrickster.R;
import charlie.a07073.com.ultimatetrickster.base.BaseActivity;

public class CallPoliceActivity extends BaseActivity implements View.OnClickListener {
    private TextView openTv;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_police);

        openTv = (TextView) findViewById(R.id.text_view_open);
        openTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.text_view_open:
                Snackbar.make(openTv,"You clicked the open button。",Snackbar.LENGTH_SHORT).show();
                break;
        }
    }
}
