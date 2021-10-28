package com.android.rxjavatest;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class JOperator {
    String TAG = getClass().getSimpleName();

    ArrayList mListNum = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
    ArrayList arrayList1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    ArrayList arrayList2 = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));

    void justOperator() {
        ArrayList list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 89, 19));

        Observable observable = Observable.just(list);

        Observer<List<Integer>> observer = new Observer<List<Integer>>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull List<Integer> integerlist) {
                Log.e(TAG, "onNext " + integerlist);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");
            }
        };

        observable.subscribeOn(Schedulers.io()).subscribe(observer);
    }

    void fromOperator() {

    }

    public void fromIterableOperator() {
        Observable observable = Observable.fromIterable(mListNum);

        Observer<Integer> observer = new Observer<Integer>(){

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integers) {
                Log.e(TAG,integers.toString());
            }


            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        };

        observable.subscribe(observer);
    }

    public Observable<Integer> repeatOperator(){
        return Observable.range(1,100).repeat(5);
    }

    public Observable<Integer> rangeOperator(){
        return Observable.range(1,100);
    }

    public Observable<Long> intervalOperator() {

        return Observable.interval(1, TimeUnit.SECONDS);
    }
}
