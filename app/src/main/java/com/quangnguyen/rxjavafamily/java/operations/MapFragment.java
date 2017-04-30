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
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author Quang Nguyen.
 */

public class MapFragment extends Fragment {
  private TextView logText;

  public MapFragment() {
    // Required empty public constructor
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_rxjava_map, container, false);
    logText = (TextView) rootView.findViewById(R.id.text_log);
    return rootView;
  }

  @Override public void onResume() {
    super.onResume();
    demoMap();
  }

  /**
   * Demonstrates "Map" operations.
   * "Map" - Transform the items emitted by an Observables by applying a function to each item.
   * In this case, we transform each integer by adding 10 to it.
   * i.e: 1 -> 11 (1 + 10).
   */
  private void demoMap() {
    observable.map(number -> number + 10)
        .subscribe(observer);
  }

  // In this example, we use 'just' function
  // to create a simple Observable which emits a flow of integers.
  private Observable<Integer> observable = Observable.just(1, 2, 3);

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
