package app.test.test.inter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by think on 2018-01-31.
 */

public interface ViewInjector {

    /**
     * 注入view
     *
     * @param view
     */
    void injector(View view);

    /**
     * 注入activity
     *
     * @param activity
     */
    void injector(Activity activity);

    /**
     * 注入 view handler
     *
     * @param handler
     * @param view
     */
    void injector(Object handler, View view);

    /**
     * 注入fragment
     *
     * @param fragment
     * @param layoutInflater
     * @param viewGroup
     */
    void injector(Object fragment, LayoutInflater layoutInflater, ViewGroup viewGroup);

}
