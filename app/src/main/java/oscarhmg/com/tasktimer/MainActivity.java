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
    static int delay = 10000; // delay for 30 sec.
    int period = 3000; // repeat every sec.
    static final Handler handler = new Handler();
    static Timer timer = null;
    static TimerTask timerTask;
    public static boolean isVisible = false;
    public static MainActivity activity ;
    static Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        TimerTaskUtils.startTimerDialog(this);
    }

/*
    public static void startTimerDialog(){
        timer = new Timer();
        //Initializate the timerTask Object
        initializateTimerTask();
        timer.schedule(timerTask,delay);
        //timer.schedule(timerTask,delay,period);
    }*/

    /*
    public static void initializateTimerTask() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("DebugMode","30 seconds past");
                        if (!isVisible) {
                            //showDialog();
                             intent= new Intent(actividad, Advertising.class);
                            actividad.startActivity(intent);
                            isVisible = true;
                            MainActivity.stopTimerTask();
                            Log.i("DebugMode","Showing 1 advertising...");
                        }
                    }
                });
            }
        };
    }*/





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
        // as you specify a parent actividad in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
