package com.qianfanyun.module_rxjava;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.qianfanyun.module_base.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author ArcherYc
 * @date on 2019/4/1  9:40 AM
 * @mail 247067345@qq.com
 */
public class RxJavaViewModel extends BaseViewModel {


    public RxJavaViewModel(@NonNull Application application) {
        super(application);
    }

    public void simpleCase() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "aa"));
        studentList.add(new Student(2, "bb"));
        Disposable disposable = Observable.fromIterable(studentList)
                .doOnNext(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) throws Exception {
                        student.setName("cc");
                    }
                })
                .subscribe(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) throws Exception {
                        Log.d("xx",student.toString());
                    }
                });
    }

    private class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id + '\n' +
                    "name=" + name + '\n' +
                    '}';
        }
    }
}
