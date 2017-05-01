package com.quangnguyen.rxjavafamily.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.quangnguyen.rxjavafamily.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxAndroidActivity extends AppCompatActivity {

  private TextView logText;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rxandroid);
    logText = (TextView) findViewById(R.id.text_log);
  }

  public void onClick(View view) {
    if (view.getId() == R.id.run_background) {
      runBackgroundTask();
    }
  }

  /**
   * Demonstrates a common asynchronous operation
   * in which we run a long-time task in background and observe task's result on the main thread.
   *
   * RxAndroid provides AndroidSchedulers to do that in the easy way.
   * Also, AndroidSchedulers is all that remains in RxAndroid.
   * Other parts such as ViewObservable or LifecycleObservable are moved into their own add-on libraries.
   * (i.e: RxBinding or RxLifecycle).
   */
  private void runBackgroundTask() {
    observable.subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer);
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
      emitter.onComplete();
    }
  });

  private Observer<Integer> observer = new Observer<Integer>() {
    @Override public void onSubscribe(Disposable d) {
      logText.append("\n onSubscribe.");
    }

    @Override public void onNext(Integer integer) {
      logText.append("\n onNext: " + integer);
    }

    @Override public void onError(Throwable e) {
      logText.append("\n onError: " + e.getLocalizedMessage());
    }

    @Override public void onComplete() {
      logText.append("\n onComplete.");
    }
  };
}
