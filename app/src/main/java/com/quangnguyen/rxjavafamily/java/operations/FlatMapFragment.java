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
import java.util.ArrayList;
import java.util.List;

/**
 * @author Quang Nguyen.
 */

public class FlatMapFragment extends Fragment {
  private TextView logText;
  List<Integer> list1 = new ArrayList<>();
  List<Integer> list2 = new ArrayList<>();

  public FlatMapFragment() {
    // Required empty public constructor
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_rxjava_flatmap, container, false);
    logText = (TextView) rootView.findViewById(R.id.text_log);
    return rootView;
  }

  @Override public void onResume() {
    super.onResume();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list2.add(100);
    list2.add(101);
    list2.add(102);

    demoFlatMap();
  }

  /**
   * Demonstrate 'FlatMap' operation.
   * FlatMap - Transform the items emitted by an Observable into Observables, then flatten the emissions.
   */
  private void demoFlatMap() {
    observable.flatMap(list -> {
      Integer[] array = new Integer[list.size()];
      list.toArray(array);
      return Observable.fromArray(array);
    }).subscribe(observer);
  }

  private Observable<List<Integer>> observable = Observable.just(list1, list2);

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
