package oscarhmg.com.tasktimer;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private static MaterialDialog dialog = null;
    int delay = 0; // delay for 5 sec.
    int period = 30000; // repeat every sec.
    final Handler handler = new Handler();
    Timer timer = null;
    TimerTask timerTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startTimerDialog();
    }


    public void startTimerDialog(){
        timer = new Timer();
        //Initializate the timerTask Object
        initializateTimerTask();
        timer.schedule(timerTask,delay,period);
    }

    public void initializateTimerTask() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("DebugMode","30 seconds past");
                        if (dialog == null) {
                            showDialog();
                            Log.i("DebugMode","Showing 1 Dialog only...");
                        }
                    }
                });
            }
        };
    }


    public void stopTimerTask(){
        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }



    public void showDialog(){
        MaterialDialog.Builder builder = new MaterialDialog.Builder(this);
        builder.title("iAgendador");
        builder.content("Obtenga la version PREMIUM");
        builder.positiveText("Obtenga PREMIUM");
        builder.negativeText("Minimizar");
        builder.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                Toast.makeText(MainActivity.this, "Obtener version premium...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://market.android.com/search?q=pname:com.google.earth"));
                startActivity(intent);
                dialog = null;
            }
        });
        builder.onNegative(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                materialDialog.dismiss();
                materialDialog.cancel();
                dialog = null;
                //stopTimerTask();
            }
        });
        dialog = builder.build();
        dialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
