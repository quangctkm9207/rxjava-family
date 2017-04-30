package com.quangnguyen.rxjavaexample.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * @author Quang Nguyen.
 */

public class ActivityUtils {

  public static void replaceFragment(@NonNull FragmentManager fragmentManager,@NonNull Fragment fragment,
      int layoutId) {
    fragmentManager.beginTransaction().replace(layoutId, fragment).commit();
  }
}
