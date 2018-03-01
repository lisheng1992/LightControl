package sugar.lightcontrol.mvp.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import sugar.lightcontrol.R;
import sugar.lightcontrol.mvp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_vp)
    ViewPager main_vp;



    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
