package oscarhmg.com.tasktimer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by user on 23/05/2017.
 */
public class Advertising extends Activity {
    Button close;
    ImageView purchase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertising);

        close = (Button) findViewById(R.id.close_advertising);
        purchase = (ImageView) findViewById(R.id.purchase);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                TimerTaskUtils.isVisible = false;
                TimerTaskUtils.startTimerDialog(TimerTaskUtils.actividad);
            }
        });

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Advertising.this,"Abriendo tienda",Toast.LENGTH_LONG).show();
                finish();
                TimerTaskUtils.isVisible = false;
                TimerTaskUtils.startTimerDialog(TimerTaskUtils.actividad);
            }
        });
    }
}
