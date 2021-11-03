package com.android.rxjavatest;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.subjects.AsyncSubject;

public class TestSubject {
    private String TAG = getClass().getSimpleName();

    public void asyncSubject() {
        Observable<Long> longObservable = Observable.interval(1, TimeUnit.SECONDS).takeWhile(aLong ->
                aLong <= 5 ? true : false
        );

        AsyncSubject<Long> longAsyncSubject = AsyncSubject.create();

        longObservable.subscribe(longAsyncSubject);

        longAsyncSubject.subscribe(
                it -> {
                    Log.e(TAG, "onNext1 " +it.toString());
                },
                it -> {
                    Log.e(TAG,"onEtrror1 : "+it.toString());
                },
                () -> {
                    Log.e(TAG, "onCompleted1");
                }
        );

        longAsyncSubject.subscribe(
                it -> {
                    Log.e(TAG, "onNext2 " +it.toString());
                },
                it -> {
                    Log.e(TAG,"onEtrror2 : "+it.toString());
                },
                () -> {
                    Log.e(TAG, "onCompleted2");
                }
        );

    }

    public void asyncSubjectTwo(){
        AsyncSubject<Integer> asyncSubject = AsyncSubject.create();

        asyncSubject.onNext(1);
        asyncSubject.onNext(2);
        asyncSubject.subscribe(
                it ->{
                    Log.e(TAG, "OnNext1 "+it);
                },
                it ->{
                    Log.e(TAG,"OnError1 : "+it);
                },
                ()->{
                    Log.e(TAG,"onCompleted1");
                }
        );
        asyncSubject.onNext(3);
        asyncSubject.onNext(4);
        asyncSubject.subscribe(
                it ->{
                    Log.e(TAG, "OnNext2 "+it);
                },
                it ->{
                    Log.e(TAG,"OnError2 : "+it);
                },
                ()->{
                    Log.e(TAG,"onCompleted2");
                }
        );

        asyncSubject.onComplete();
        asyncSubject.onNext(6);
        asyncSubject.subscribe(
                it ->{
                    Log.e(TAG, "OnNext3 "+it);
                },
                it ->{
                    Log.e(TAG,"OnError3 : "+it);
                },
                ()->{
                    Log.e(TAG,"onCompleted3");
                }
        );
        asyncSubject.subscribe(
                it ->{
                    Log.e(TAG, "OnNext4 "+it);
                },
                it ->{
                    Log.e(TAG,"OnError4 : "+it);
                },
                ()->{
                    Log.e(TAG,"onCompleted4");
                }
        );
    }

}
