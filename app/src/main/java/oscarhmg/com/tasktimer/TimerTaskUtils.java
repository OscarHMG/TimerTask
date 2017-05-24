package oscarhmg.com.tasktimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by user on 23/05/2017.
 */
public class TimerTaskUtils {
    static int delay = 10000; // delay for 30 sec.
    int period = 3000; // repeat every sec.
    static final Handler handler = new Handler();
    static Timer timer = null;
    static TimerTask timerTask;
    public static boolean isVisible = false;
    public static MainActivity actividad;
    static Intent intent;



    public static void startTimerDialog(Activity activity){
        actividad = (MainActivity)activity;
        timer = new Timer();
        //Initializate the timerTask Object
        initializateTimerTask();
        timer.schedule(timerTask,delay);
        //timer.schedule(timerTask,delay,period);
    }

    public static void initializateTimerTask() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("DebugMode", "30 seconds past");
                        if (!isVisible) {
                            //showDialog();
                            Intent intent= new Intent(TimerTaskUtils.actividad, Advertising.class);
                            TimerTaskUtils.actividad.startActivity(intent);
                            isVisible = true;
                            stopTimerTask();
                            Log.i("DebugMode","Showing 1 advertising...");
                        }
                    }
                });
            }
        };
    }


    public static void stopTimerTask(){
        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
