package com.quangnguyen.rxjavaexample.java.operations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.quangnguyen.rxjavaexample.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author Quang Nguyen.
 */

public class CreateFragment extends Fragment {
  private TextView logText;

  public CreateFragment() {
    // Required empty public constructor
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_rxjava_create, container, false);
    logText = (TextView) rootView.findViewById(R.id.text_log);
    return rootView;
  }

  @Override public void onResume() {
    super.onResume();
    demoCreate();
  }

  /**
   * Demonstrates "Create" operations.
   * "Create" - create an Observable from scratch by calling observer methods programmatically.
   */
  private void demoCreate() {
    observable.subscribe(observer);
  }

  private Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
    @Override public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
      emitter.onNext(1);
      emitter.onNext(2);
      emitter.onNext(3);
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
