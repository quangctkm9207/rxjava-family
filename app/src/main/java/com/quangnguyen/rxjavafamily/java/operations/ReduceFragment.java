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
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * @author Quang Nguyen.
 */

public class ReduceFragment extends Fragment {
  private TextView logText;

  public ReduceFragment() {
    // Required empty public constructor
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_rxjava_reduce, container, false);
    logText = (TextView) rootView.findViewById(R.id.text_log);
    return rootView;
  }

  @Override public void onResume() {
    super.onResume();
    demoReduce();
  }

  /**
   * Demonstrate 'Reduce' operation.
   * Reduce - Apply a function to each item emitted by an Observable, sequentially, and emit the final value.
   *
   * In this case, we calculate the sum of all elements.
   */
  private void demoReduce() {
    observable.reduce((sum, item) -> sum + item)
        .subscribe(consumer);
  }

  private Observable<Integer> observable = Observable.just(1, 2, 3);

  private Consumer<Integer> consumer = new Consumer<Integer>() {
    @Override public void accept(@NonNull Integer integer) throws Exception {
      logText.append("\n final value: " + integer);
    }
  };
}
