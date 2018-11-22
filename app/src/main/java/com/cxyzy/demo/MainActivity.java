package com.cxyzy.demo;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.cxyzy.androidutils.RxTimer;
import com.cxyzy.androidutils.TimeCostUtil;

public final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        TimeCostUtil.startTick("xxx");
        findViewById(R.id.button).setOnClickListener(v -> {
            (new RxTimer()).interval(3000L, number -> {
                long timeCost = TimeCostUtil.getTimeCost("xxx");
                Toast.makeText(MainActivity.this, ("test:" + timeCost), Toast.LENGTH_SHORT).show();
            });
        });
    }

}
