package oop2_homework;

public class HTCOne extends PhoneByBrand {
    private final int batteryLife = 20;
    private String imei;

    public HTCOne() {
        super();
        super.setBrand("HTC");
        super.setModel("HTC One");
    }

    @Override
    public int getBatteryLife() {
        return batteryLife;
    }
}
