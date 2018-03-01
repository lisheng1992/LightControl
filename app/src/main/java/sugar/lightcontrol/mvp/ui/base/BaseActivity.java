package sugar.lightcontrol.mvp.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import sugar.lightcontrol.application.BaseApplication;
import sugar.lightcontrol.mvp.presenter.base.BasePresenter;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    public abstract int getLayoutId();

    public abstract void initViews();

    public T mPresenter;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        setContentView(layoutId);
        unbinder = ButterKnife.bind(this);
        initViews();
    }

    protected void initVerticalRecyclerViewWithDivide(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = BaseApplication.getRefWatcher(this);
        refWatcher.watch(this);
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
