package app.test.designpattern;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import app.test.designpattern.Builder.Person;
import app.test.designpattern.Observer.Observable;
import app.test.designpattern.Observer.Observer;
import app.test.designpattern.Observer.WeatherBean;
import app.test.designpattern.PrototypeModel.Son;
import app.test.designpattern.StrategyPattern.PlaneStrategy;
import app.test.designpattern.StrategyPattern.TravelContext;
import app.test.designpattern.StrategyPattern.WalkStrategy;

/**
 * @author think
 * @name TEST
 * @class name：app.test.designpattern
 * @class describe :
 * @time 2018-02-07 17:03
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //建造者模式
        setBulider();
        //观察者模式
        setObserver();
        //原型模式
        setPrototypeModel();
        //策略模式
        setStrategy();
    }

    private void setStrategy() {
        TravelContext travelContext = new TravelContext();

        travelContext.setStrategy(new PlaneStrategy());
        travelContext.travel();

        travelContext.setStrategy(new WalkStrategy());
        travelContext.travel();
    }

    private void setPrototypeModel() {
        //原型模式
        Son son = new Son();
        son.setAge(1);
        son.setHeight(11);
        son.setWeight(140);
        son.setName("张三");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("篮球");
        strings.add("足球");
        son.setHobbies(strings);
        Log.d("son", "" + son);


        Son son1 = (Son) son.clone();
        Log.d("son1", "" + son1);
        son1.setName("李四");
        son1.getHobbies().add("游泳健身");
        Log.d("son", "" + son);
        Log.d("son1", "" + son1);


    }

    private void setObserver() {
        //观察者模式
        Observable<WeatherBean> observable = new Observable<>();

        Observer<WeatherBean> observer = new Observer<WeatherBean>() {
            @Override
            public void onUpdate(Observable<WeatherBean> observable, WeatherBean data) {
                Log.d("observer1", "" + data.toString());
            }
        };

        Observer<WeatherBean> observer2 = new Observer<WeatherBean>() {
            @Override
            public void onUpdate(Observable<WeatherBean> observable, WeatherBean data) {
                Log.d("observer2", "" + data.toString());
            }
        };

        observable.register(observer);
        observable.register(observer2);

        WeatherBean weatherBean = new WeatherBean("小雨");
        observable.notifyObservers(weatherBean);

        WeatherBean weatherBean1 = new WeatherBean("晴天");
        observable.notifyObservers(weatherBean1);

        observable.unregister(observer2);

        WeatherBean weatherBean3 = new WeatherBean("台风");
        observable.notifyObservers(weatherBean3);

    }

    private void setBulider() {
        //建造者模式
        new Person.Builder()
                .age(1)
                .height(1d)
                .name("hh")
                .build();


    }
}
