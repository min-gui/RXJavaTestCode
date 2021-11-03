package com.android.rxjavatest;

import android.util.Log;

import com.android.rxjavatest.data.User;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObservableTest {

    public Disposable disposable;

    ArrayList mUserList = new ArrayList<User>(Arrays.asList(
            new User(1,"demo1",15),
            new User(2,"demo2",18),
            new User(3,"demo4",20),
            new User(4,"demo4",21),
            new User(5,"demo5",22),
            new User(6,"demo6",22),
            new User(7,"demo7",24)

    )
    );
    ArrayList mUserEmptyList = new ArrayList<User>();
    public Observable<Integer> createObservable() {

        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                try {
                    if (!emitter.isDisposed()){
                        for (int i =0; i <10 ; i++){
                            emitter.onNext(i);
                        }
                        emitter.onComplete();
                    }
                }catch (Exception e){
                    emitter.onError(e);
                }



            }
        });
    }

    public Single<Integer> createSingleObservable(){

        return Single.create(new SingleOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<Integer> emitter) throws Throwable {
                try {
                    if(!emitter.isDisposed()){
                        for (int i = 0 ; i < 100; i++){
                            emitter.onSuccess(i);
                        }
                    }

                }catch (Exception e){
                    emitter.onError(e);
                }
            }
        });
    }

    public SingleObserver<List<Integer>> observerSingleObservable(){
        return new SingleObserver<List<Integer>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e("TAG","onSubscribe");
            }

            @Override
            public void onSuccess(@NonNull List<Integer> integerList) {

                for(Integer i : integerList){
                    Log.e("TAG", "onSucess : "+ i);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("TAG","onError");
            }
        };
    }

    public Observer<Integer> observer(){
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
                Log.e("TAG","onSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e("TAG","onNext"+integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("TAG","onError");
            }

            @Override
            public void onComplete() {
                Log.e("TAG","onComplete");
            }
        };
    }

    public Single<List<User>> createMaybeObservable(){

        return Single.just(mUserEmptyList);
    }

    public SingleObserver<List<User>> observerMayObservable(){
        return new SingleObserver<List<User>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e("tag","onSubscribe");
            }

            @Override
            public void onSuccess(@NonNull List<User> users) {
                for (User user : users){
                    Log.e("tag",user.id +" ");
                }

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("tag","onError");
            }

//            @Override
//            public void onComplete() {
//                Log.e("tag","onComplete");
//            }
        };
    }

    public Completable createCompletableObservable(){
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter emitter) throws Throwable {

                try {
                    if (!emitter.isDisposed()){
                        getLocation();
                        emitter.onComplete();
                    }
                }catch (Exception e ){
                    emitter.onError(e);
                }
            }
        });
    }
    public CompletableObserver observerCompletableObservable(){
        return new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e("TAG","onSubscribe");
            }

            @Override
            public void onComplete() {
                Log.e("TAG","onComplete");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("TAG","onError");
            }
        };
    }

    public Flowable<Integer> createFlowableObservable(){
        return Flowable.range(1,100);
    }

    public Observable<Integer> createFlowableObservableT2(){
        return Observable.range(1,100);
    }

    public void getLocation(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("TAG","latitude 1.23.23");
    }


}
