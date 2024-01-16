package id.co.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import id.co.myapplication.activity.Hello;
import id.co.myapplication.activity.MainFirstActivity;
import id.co.myapplication.activity.MainSianida;
import id.co.myapplication.activity.Count;
import id.co.myapplication.fragment.FragmenActivity;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_grid);
    }
    public void launchHelloActivity(View view) {
        Intent tampilHello = new Intent(Main.this, Hello.class);
        startActivity(tampilHello);
    }
    public void launchToastActivity(View view){
        Intent tampilToast = new Intent(Main.this, Count.class);
        startActivity(tampilToast);
    }
    public void launchSianidaActivity(View view){
        Intent tampilSianida = new Intent(Main.this, MainSianida.class);
        startActivity(tampilSianida);
    }
    public void lauchTwoActivity(View view){
        Intent tampilTwo = new Intent(Main.this, MainFirstActivity.class);
        startActivity(tampilTwo);
    }
    public void createAlarm2(View view) {
        ArrayList<Integer> alarmDays = new ArrayList<>();
        alarmDays.add(2);
        alarmDays.add(3);
        alarmDays.add(4);
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_DAYS, alarmDays)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Wake up!")
                .putExtra(AlarmClock.EXTRA_HOUR, 7)
                .putExtra(AlarmClock.EXTRA_MINUTES, 30)
                .putExtra(AlarmClock.EXTRA_VIBRATE, false)
                .putExtra(AlarmClock.EXTRA_RINGTONE, "VALUE_RINGTONE_SILENT");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void showMap(View view) {
        String uri = "http://maps.google.com/";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }
    public void launchFilm(View view) {
        Intent tampilFilm = new Intent( Main.this, FragmenActivity.class);
        startActivity(tampilFilm);
    }
}
