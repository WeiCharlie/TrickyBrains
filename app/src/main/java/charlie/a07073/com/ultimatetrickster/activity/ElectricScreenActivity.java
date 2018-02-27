package charlie.a07073.com.ultimatetrickster.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.WindowManager;

import charlie.a07073.com.ultimatetrickster.R;
import charlie.a07073.com.ultimatetrickster.base.BaseActivity;
import charlie.a07073.com.ultimatetrickster.widget.CustomSurfaceView;

public class ElectricScreenActivity extends BaseActivity {

    // private static final String TAG = "Electric_Screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomSurfaceView view = new CustomSurfaceView(this, null);
        setContentView(R.layout.activity_electric_screen);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showDialog();
        }
        return super.onKeyDown(keyCode, event);
    }
    private void showDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Quit Tricky Brains?")
                .setMessage("No Longer Play For A While？")
                .setNegativeButton("Yes",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                finish();
                            }
                        })
                .setPositiveButton("Wait",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        }).show();
    }
    private void drawUpdateIndicator(int color, boolean drawLeftOrRight) {
        ShapeDrawable smallerCircle = new ShapeDrawable(new OvalShape());
        smallerCircle.setIntrinsicHeight(60);
        smallerCircle.setIntrinsicWidth(60);
        smallerCircle.setBounds(new Rect(0, 0, 60, 60));
        smallerCircle.getPaint().setColor(color);
        smallerCircle.setPadding(50, 50, 50, 100);

        Drawable drawableleft = null;
        Drawable drawableRight = null;
        if (drawLeftOrRight) {
            drawableleft = smallerCircle;
        } else {
            drawableRight = smallerCircle;
        }
        // showAppWallButton.setCompoundDrawables(drawableleft, null,
        // drawableRight, null);
    }
}
