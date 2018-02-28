package sugar.lightcontrol.mvp.bean;

/**
 * Created by ls on 2018/2/28.
 */

public class DeviceBean {
    private String deviceName;
    private boolean isDelete;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
