package com.cxyzy.demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cxyzy.androidutils.RxTimer
import com.cxyzy.androidutils.TimeCostUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TimeCostUtil.startTick("xxx")
        button.setOnClickListener {
            RxTimer().interval(3000, object : RxTimer.RxAction {
                override fun action(number: Long) {
                    var timeCost = TimeCostUtil.getTimeCost("xxx")
                    Toast.makeText(this@MainActivity, "test:" + timeCost, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
