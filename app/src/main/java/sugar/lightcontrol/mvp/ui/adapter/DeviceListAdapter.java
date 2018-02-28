package sugar.lightcontrol.mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import sugar.lightcontrol.R;
import sugar.lightcontrol.listener.OnItemClick;
import sugar.lightcontrol.mvp.bean.DeviceBean;

/**
 * Created by ls on 2018/2/28.
 */

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.DeviceListHolder>{

    private List<DeviceBean> mDeviceBeans;
    private Context mContext;

    private OnItemClick mOnItemClick;
    public void setOnItemClick(OnItemClick onItemClick){
        mOnItemClick = onItemClick;
    }

    public DeviceListAdapter(List<DeviceBean> deviceBeans, Context context) {
        mDeviceBeans = deviceBeans;
        mContext = context;
    }

    @Override
    public DeviceListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_device_list,parent,false);
        return new DeviceListHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceListHolder holder,final int position) {

        holder.device_name_tv.setText(mDeviceBeans.get(position).getDeviceName());
        holder.device_item_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClick != null) {
                    mOnItemClick.onItemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDeviceBeans.size();
    }

    class DeviceListHolder extends RecyclerView.ViewHolder{

        TextView device_name_tv;
        ImageView device_set_iv;
        Button device_delete_bt;
        RelativeLayout device_item_rl;

        public DeviceListHolder(View itemView) {
            super(itemView);
            device_name_tv = itemView.findViewById(R.id.device_name_tv);
            device_set_iv = itemView.findViewById(R.id.device_set_iv);
            device_delete_bt = itemView.findViewById(R.id.device_delete_bt);
            device_item_rl = itemView.findViewById(R.id.device_item_rl);
        }
    }
}
