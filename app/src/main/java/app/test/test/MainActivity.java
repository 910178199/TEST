package app.test.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import app.test.test.inter.Iinterface;

/**
 * Created by think on 2018-01-31.
 * android注解的使用
 * 注解的作用：
 * a. 标记，用于告诉编译器一些信息
 * b. 编译时动态处理，如动态生成代码
 * c. 运行时动态处理，如得到注解信息
 *
 * @Retention 用来定义当前注解的作用范围，有以下三个范围可选：
 * 1.RetentionPolicy.SOURCE : 注解只存在于源码中，不会存在于.class文件中，在编译时会被忽略掉
 * <p>
 * 2.RetentionPolicy.CLASS：注解只存在于.class文件中，在编译期有效，但是在运行期会被忽略掉，这也是默认范围
 * <p>
 * 3.RetentionPolicy.RUNTIME：在运行期有效，JVM在运行期通过反射获得注解信息
 * @Target 用于指定注解作用于java的哪些元素，未标注则表示可修饰所有.有以下这些元素类型可供选择：
 * <p>
 * ElementType.ANNOTATION_TYPE can be applied to an annotation type.
 * <p>
 * ElementType.CONSTRUCTOR can be applied to a constructor.
 * <p>
 * ElementType.FIELD can be applied to a field or property.
 * <p>
 * ElementType.LOCAL_VARIABLE can be applied to a local variable.
 * <p>
 * ElementType.METHOD can be applied to a method-level annotation.
 * <p>
 * ElementType.PACKAGE can be applied to a package declaration.
 * <p>
 * ElementType.PARAMETER can be applied to the parameters of a method.
 * <p>
 * ElementType.TYPE can be applied to any element of a class.
 * <p>
 * 通过名字就可以看出来他们的元素类型，不过有两个需要特别说明下：
 * <p>
 * 1.ElementType.ANNOTATION_TYPE:元注解类型，只能用来注解其它的注解，例如@Target和@Retention。
 * <p>
 * 2.ElementType.TYPE：可以用来注解任何类型的java类，如类、接口、枚举、或者注解类。
 * @Inherited 注解表示当前注解会被注解类的子类继承。
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Annotation解析
        Iinterface.ClassPreamble annotations = PreamnleAnntation.class.getAnnotation(Iinterface.ClassPreamble.class);
        Log.d("TAG", "" + annotations.author());

    }

    @SuppressWarnings(value = "unchecked")
        //忽略警告
    void myMethod() {

    }
}
