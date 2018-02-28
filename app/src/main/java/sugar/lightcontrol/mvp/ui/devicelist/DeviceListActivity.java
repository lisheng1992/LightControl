package sugar.lightcontrol.mvp.ui.devicelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import sugar.lightcontrol.R;
import sugar.lightcontrol.listener.OnItemClick;
import sugar.lightcontrol.mvp.bean.DeviceBean;
import sugar.lightcontrol.mvp.ui.MainActivity;
import sugar.lightcontrol.mvp.ui.adapter.DeviceListAdapter;
import sugar.lightcontrol.mvp.ui.base.BaseActivity;
import sugar.lightcontrol.mvp.ui.customview.SwipeItemLayout;

public class DeviceListActivity extends BaseActivity implements OnItemClick {


    @BindView(R.id.warn_iv)
    ImageView mWarnIv;
    @BindView(R.id.add_iv)
    ImageView mAddIv;
    @BindView(R.id.device_list_rv)
    RecyclerView mDeviceListRv;

    private DeviceListAdapter mDeviceListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_list;
    }

    @Override
    public void initViews() {
        initVerticalRecyclerViewWithDivide(mDeviceListRv);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mDeviceListRv.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this));
        List<DeviceBean> deviceBeans = new ArrayList<>();
        for (int i = 0;i < 5;i++){
            DeviceBean deviceBean = new DeviceBean();
            deviceBean.setDeviceName("Device :"+i);
            deviceBeans.add(deviceBean);
        }
        mDeviceListAdapter = new DeviceListAdapter(deviceBeans,this);
        mDeviceListAdapter.setOnItemClick(this);
        mDeviceListRv.setAdapter(mDeviceListAdapter);

    }


    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(DeviceListActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
