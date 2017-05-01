package com.quangnguyen.rxjavafamily.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.quangnguyen.rxjavafamily.R;

public class RxLifecycleActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rxlifecycle);
  }
}
