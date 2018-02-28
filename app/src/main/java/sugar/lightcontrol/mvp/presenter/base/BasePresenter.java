package sugar.lightcontrol.mvp.presenter.base;

import android.support.annotation.NonNull;

import sugar.lightcontrol.mvp.view.BaseView;

/**
 * Created by ls on 2018/2/28.
 */

public interface BasePresenter {

    /**
     * 绑定回调
     * @param view
     */
    void attachView(@NonNull BaseView view);

    /**
     * 销毁
     */
    void onDestroy();

}
