package com.android.rxjavatest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.rxjavatest.data.User;

import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.util.ConnectConsumer;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

public class MainActivity extends AppCompatActivity {

    private String greeting = "Hello From RxJava";
    private Observable<String> myObservable;
    private TextView tvMain;
    private String TAG = "TAG";
    private JOperator mJOperator = new JOperator();
    private ObservableTest mObservableTest = new ObservableTest();
    private ColdObservable coldObservable = new ColdObservable();
    private TestSubject testSubject = new TestSubject();


    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private HotObservable mHotObservable = new HotObservable();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tv_main);


        //mJOperator.fromIterableOperator();

        /*mJOperator.rangeOperator().subscribe(new Observer<Integer>() {
                                      @Override
                                      public void onSubscribe(@NonNull Disposable d) {
                                          Log.e(TAG,"onComplete");
                                      }

                                      @Override
                                      public void onNext(@NonNull Integer integer) {
                                          Log.e(TAG,integer.toString());
                                      }

                                      @Override
                                      public void onError(@NonNull Throwable e) {
                                          Log.e(TAG,"onError");
                                      }

                                      @Override
                                      public void onComplete() {
                                          Log.e(TAG,"onComplete");
                                      }
                                  }

        );*/

        /*mJOperator.repeatOperator().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onComplete");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e(TAG,integer.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }

        });*/

        /*mJOperator.intervalOperator().subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(@NonNull Long Long) {
                Log.e(TAG,Long.toString());
                getLocation();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        });*/
        /*mJOperator.timerOperator().subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(@NonNull Long Long) {
                Log.e(TAG,Long.toString());

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        });*/

        /*mJOperator.createOperator().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e(TAG,integer.toString());

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        });*/

        /*mJOperator.filterOperator().filter(new Predicate<User>() {
            @Override
            public boolean test(User user) throws Throwable {

                if (user.age <= 18){
                    return true;
                }

                return false;
            }
        }).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull User user) {
                Log.e(TAG,"next "+user.name);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/

        /* mJOperator.lastOperator()
                //.last(new User(1,"demo1",15))
                .lastOrError()
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull User user) {
                        Log.e(TAG,user.name);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });*/

        /*mJOperator.distinctOperator().distinct(new Function<User, Object>() {
            @Override
            public Object apply(User user) throws Throwable {

                return user.name;
            }
        }).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull User user) {
                Log.e(TAG,user.name);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/

        /*mJOperator.skipOperator()
                .skip(100,TimeUnit.MICROSECONDS)
                .subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(@NonNull User user) {
                Log.e(TAG,user.name);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        });*/
        /*mJOperator.bufferOperator()
                .buffer(3)
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull List<User> users) {
                        Log.e(TAG,users.size()+"");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG,"onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete");
                    }
                });*/

        /*mJOperator.mapOperator()
                .map(new Function<User, Object>() {

                    @Override
                    public Object apply(User user) throws Throwable {
                        return user.age * 2;
                    }
                })
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Log.e(TAG,o.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });*/

        /*mObservableTest.createObservable().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe ");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e(TAG,integer+" ");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError+");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        });*/
        /*mObservableTest.createSingleObservable().
                subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Integer integer) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });*/

        //mObservableTest.createMaybeObservable().subscribe(mObservableTest.observerMayObservable());
        //mObservableTest.createCompletableObservable().subscribe(mObservableTest.observerCompletableObservable());
        /*mObservableTest.createFlowableObservableT2()
                .toFlowable(BackpressureStrategy.LATEST)
                .observeOn(Schedulers.io(),false, 2)

                .subscribe(new DisposableSubscriber<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG,integer.toString());
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG,t.toString() );
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete");
                    }
                });*/
        /*compositeDisposable.add(
                mObservableTest
                        .createObservable()
                        .subscribeOn(Schedulers.io())
                        .subscribe(integer -> {
                                    Log.e(TAG, integer.toString());
                                }
                                , throwable -> {
                                    Log.e(TAG,throwable.toString());
                                }
                                , () -> {
                                    Log.e(TAG,"complete");
                                }

                        ));*/
        /*compositeDisposable.add(
                Observable.just(mObservableTest.mUserList)
                        .subscribeOn(Schedulers.io())
                        .flatMap(arrayList -> {

                            Log.e(TAG,"Upstream ThreadName :"+ Thread.currentThread().getName());
                            return Observable.fromIterable(arrayList);

                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                it -> {
                                    Log.e(TAG,"onNext" +((User)it).age +" Thread name " + Thread.currentThread().getName());
                                    //Toast.makeText(this,"onNext" +((User)it).age +" Thread name " + Thread.currentThread().getName(),Toast.LENGTH_SHORT).show();
                                }, it -> {
                                    Log.e(TAG,"onError"+ it.toString());
                                }, () -> {
                                    Log.e(TAG, "complete");
                                }

                        )

        );*/
        /*coldObservable.coldObservable().subscribe(coldObservable.coldObserver());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coldObservable.coldObservable().subscribe(coldObservable.coldObserver());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coldObservable.coldObservable().subscribe(coldObservable.coldObserver());*/
        /*ConnectableObservable<User> connectableObservable = mHotObservable.hotObservable();

        connectableObservable
                .subscribe(
                it -> {
                    Log.e(TAG,"onNext "+it.id);
                },
                it -> {
                    Log.e(TAG,"onError "+it);
                }
                , () -> {
                    Log.e(TAG,"complete ");
                }
        );

        connectableObservable.connect();*/
        //Disposable hotObservable = mHotObservable.hotObservable().connect();
        /*coldObservable.coldObservable().subscribe(coldObservable.coldObserver());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coldObservable.coldObservable().subscribe(coldObservable.coldObserver());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coldObservable.coldObservable().subscribe(coldObservable.coldObserver());*/

        /*ConnectableObservable<Long> connectableObservable = mHotObservable.hotObservableTwo();
        connectableObservable.connect();
        connectableObservable.subscribe(
                it->{
                  Log.e(TAG,"onNext 1st : "+it.toString());
                },
                it->{
                    Log.e(TAG,"onError "+it);
                },
                ()->{
                    Log.e(TAG, "onComplete");
                }
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        connectableObservable.subscribe(
                it->{
                    Log.e(TAG,"onNext 2st : "+it.toString());
                },
                it->{
                    Log.e(TAG,"onError 2st"+it);
                },
                ()->{
                    Log.e(TAG, "onComplete 2st");
                }
        );*/
        //testSubject.asyncSubject();
        //testSubject.asyncSubjectTwo();
        //testSubject.behaviorSubject();
        //testSubject.publishSubject();
        testSubject.replaySubject();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
        Log.e("onDestroy", "onDestroy");

    }

    void getLocation() {
        Log.e(TAG, "Latitude: 102.0303 Longitude : 1.2355");
    }

}
