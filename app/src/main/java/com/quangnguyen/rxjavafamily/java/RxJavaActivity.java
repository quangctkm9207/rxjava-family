package com.quangnguyen.rxjavafamily.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.quangnguyen.rxjavafamily.R;
import com.quangnguyen.rxjavafamily.java.operations.*;
import com.quangnguyen.rxjavafamily.util.ActivityUtils;

/**
 * @author Quang Nguyen.
 */

public class RxJavaActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rxjava);
  }

  public void onClick(View view) {
    Fragment fragment = null;
    switch (view.getId()) {
      case R.id.create:
        fragment = new CreateFragment();
        break;
      case R.id.map:
        fragment = new MapFragment();
        break;
      case R.id.flatmap:
        fragment = new FlatMapFragment();
        break;
      case R.id.filter:
        fragment = new FilterFragment();
        break;
      case R.id.zip:
        fragment = new ZipFragment();
        break;
      case R.id.reduce:
        fragment = new ReduceFragment();
        break;
      default:
        break;
    }

    if (fragment != null) {
      ActivityUtils.replaceFragment(getSupportFragmentManager(), fragment, R.id.container);
    }
  }
}
