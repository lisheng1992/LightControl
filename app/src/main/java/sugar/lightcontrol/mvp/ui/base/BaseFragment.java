package sugar.lightcontrol.mvp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import sugar.lightcontrol.application.BaseApplication;
import sugar.lightcontrol.mvp.presenter.base.BasePresenter;

/**
 * Created by ls on 2018/3/1.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    protected T mPresenter;

    private View mFragmentView;

    public abstract void initViews(View view);

    public abstract int getLayoutId();

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getLayoutId(), container, false);
            unbinder = ButterKnife.bind(this, mFragmentView);
            initViews(mFragmentView);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = BaseApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);

        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    protected void initVerticalRecyclerViewWithDivide(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);
    }
}
