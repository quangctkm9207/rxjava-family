package com.quangnguyen.rxjavafamily.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.quangnguyen.rxjavafamily.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class RxLifecycleActivity extends RxAppCompatActivity {
  private TextView logText;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rxlifecycle);
    logText = (TextView) findViewById(R.id.text_log);

    // Call .subscribe method inside onCreate.
    demoLifecycle();
  }

  /**
   * Demonstrates how RxLifecycle works.
   *
   * In this case, we call .subscribe inside onCreate.
   * So, observable will be terminated automatically onDestroy.
   */
  private void demoLifecycle() {
    observable
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(number -> logText.append("\n" + number));
  }

  private Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
    @Override public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
      // Suppose we have a long task which is simulated by using Thread.sleep().
      // We need to run it in the background to avoid blocking the main thread.
      emitter.onNext(1);
      Thread.sleep(1000);
      emitter.onNext(2);
      Thread.sleep(1000);
      emitter.onNext(3);
      Thread.sleep(1000);
      emitter.onNext(4);
      Thread.sleep(1000);
      emitter.onNext(5);
      Thread.sleep(1000);
      emitter.onNext(6);
      Thread.sleep(1000);
      emitter.onComplete();
    }
  });
}
