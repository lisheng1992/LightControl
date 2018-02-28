package sugar.lightcontrol.listener;

/**
 * Created by ls on 2018/2/28.
 */

public interface RequestCallback<T> {

    void onStart();

    void onCompleted();

    void onError();

    void onSuccess(T response);

    void onFail();
}
