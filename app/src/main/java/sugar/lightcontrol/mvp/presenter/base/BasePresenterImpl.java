package sugar.lightcontrol.mvp.presenter.base;

import android.support.annotation.NonNull;

import sugar.lightcontrol.listener.RequestCallback;
import sugar.lightcontrol.mvp.view.BaseView;

/**
 * Created by ls on 2018/2/28.
 */

public class BasePresenterImpl<T extends BaseView,E> implements BasePresenter,RequestCallback<E> {

    protected T mView;
    public boolean isShowDialog = true;
    @Override
    public void onStart() {
        if (isShowDialog) {
            mView.showDialog();
        }
    }

    @Override
    public void onCompleted() {
        if (isShowDialog) {
            mView.dissmissDialog();
        }
    }

    @Override
    public void onError() {
        if (isShowDialog) {
            mView.dissmissDialog();
        }
    }

    @Override
    public void onSuccess(E response) {

    }

    @Override
    public void onFail() {

    }

    @Override
    public void attachView(@NonNull BaseView view) {
        mView = (T) view;
    }

    @Override
    public void onDestroy() {

    }
}
