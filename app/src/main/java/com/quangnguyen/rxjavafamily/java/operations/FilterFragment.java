package com.quangnguyen.rxjavafamily.java.operations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.quangnguyen.rxjavafamily.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author Quang Nguyen.
 */

public class FilterFragment extends Fragment {
  private TextView logText;

  public FilterFragment() {
    // Required empty public constructor
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_rxjava_filter, container, false);
    logText = (TextView) rootView.findViewById(R.id.text_log);
    return rootView;
  }

  @Override public void onResume() {
    super.onResume();
    demoFilter();
  }

  /**
   * Demonstrate 'Filter' operation.
   * Filter - Emit only those items from an Observable that pass a predicate test.
   * In this case, only emit the elements which are even.
   */
  private void demoFilter() {
    observable.filter(number -> number % 2 == 0)
        .subscribe(observer);
  }

  private Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5, 6);

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
