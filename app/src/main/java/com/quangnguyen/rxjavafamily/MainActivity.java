package com.quangnguyen.rxjavafamily;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.quangnguyen.rxjavafamily.android.RxAndroidActivity;
import com.quangnguyen.rxjavafamily.binding.RxBindingActivity;
import com.quangnguyen.rxjavafamily.java.RxJavaActivity;
import com.quangnguyen.rxjavafamily.lifecycle.RxLifecycleActivity;
import com.quangnguyen.rxjavafamily.relay.RxRelayActivity;

/**
 * @author Quang Nguyen
 */

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onClick(View view) {
    Intent intent = null;
    switch (view.getId()) {
      case R.id.java:
        intent = new Intent(this, RxJavaActivity.class);
        break;
      case R.id.android:
        intent = new Intent(this, RxAndroidActivity.class);
        break;
      case R.id.binding:
        intent = new Intent(this, RxBindingActivity.class);
        break;
      case R.id.lifecycle:
        intent = new Intent(this, RxLifecycleActivity.class);
        break;
      case R.id.relay:
        intent = new Intent(this, RxRelayActivity.class);
        break;
      default:
        break;
    }
    if (intent != null) {
      startActivity(intent);
    }
  }
}
