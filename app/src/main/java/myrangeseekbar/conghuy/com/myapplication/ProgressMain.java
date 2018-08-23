package myrangeseekbar.conghuy.com.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProgressMain extends AppCompatActivity {
    ProgressIndicator mProgressIndicator1, mProgressIndicator2,
            mProgressIndicator3, mProgressIndicator4, mProgressIndicator5,
            mProgressIndicator6, mProgressIndicator7, mProgressIndicator8,
            mProgressIndicator9;
    Button btnreset;
    float max = 1;
    float update = 0;
    boolean threadRunning = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_main);
        mProgressIndicator1 = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator1);
        mProgressIndicator2 = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator2);
        mProgressIndicator3 = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator3);
        mProgressIndicator4 = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator4);
        mProgressIndicator5 = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator5);
        mProgressIndicator6 = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator6);
        mProgressIndicator7 = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator7);
        mProgressIndicator8 = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator8);
        mProgressIndicator9 = (ProgressIndicator) findViewById(R.id.determinate_progress_indicator9);
        btnreset = (Button) findViewById(R.id.btnreset);

        mProgressIndicator1.setForegroundColor(Color.parseColor("#b0120a"));
        mProgressIndicator1.setBackgroundColor(Color.parseColor("#f69988"));

        mProgressIndicator2.setForegroundColor(Color.parseColor("#880e4f"));
        mProgressIndicator2.setBackgroundColor(Color.parseColor("#f48fb1"));

        mProgressIndicator3.setForegroundColor(Color.parseColor("#4a148c"));
        mProgressIndicator3.setBackgroundColor(Color.parseColor("#ce93d8"));

        mProgressIndicator4.setForegroundColor(Color.parseColor("#2a36b1"));
        mProgressIndicator4.setBackgroundColor(Color.parseColor("#afbfff"));
        mProgressIndicator4.setPieStyle(true);

        mProgressIndicator5.setForegroundColor(Color.parseColor("#004d40"));
        mProgressIndicator5.setBackgroundColor(Color.parseColor("#80cbc4"));
        mProgressIndicator5.setPieStyle(true);

        mProgressIndicator6.setForegroundColor(Color.parseColor("#0d5302"));
        mProgressIndicator6.setBackgroundColor(Color.parseColor("#72d572"));
        mProgressIndicator6.setPieStyle(true);

        mProgressIndicator7.setForegroundColor(Color.parseColor("#f9a825"));
        mProgressIndicator7.setBackgroundColor(Color.parseColor("#fff59d"));

        mProgressIndicator8.setForegroundColor(Color.parseColor("#d84315"));
        mProgressIndicator8.setBackgroundColor(Color.parseColor("#ffab91"));

        mProgressIndicator9.setForegroundColor(Color.parseColor("#4e342e"));
        mProgressIndicator9.setBackgroundColor(Color.parseColor("#bcaaa4"));
        startThread();
        btnreset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (threadRunning)
                    return;
                startThread();
            }
        });
    }
    private void startThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadRunning = true;
                update = 0;
                while (update <= max) {
                    update += 0.005;
                    updateProgressIndicatorValue();
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
                threadRunning = false;
            }
        }).start();
    }

    private void updateProgressIndicatorValue() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgressIndicator1.setValue(update);
                mProgressIndicator2.setValue(update);
                mProgressIndicator3.setValue(update);
                mProgressIndicator4.setValue(update);
                mProgressIndicator5.setValue(update);
                mProgressIndicator6.setValue(update);
                mProgressIndicator7.setValue(update);
                mProgressIndicator8.setValue(update);
                mProgressIndicator9.setValue(update);
            }
        });
    }
}
