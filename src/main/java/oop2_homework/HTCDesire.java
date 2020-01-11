package oop2_homework;

public class HTCDesire extends PhoneByBrand {
    private final int batteryLife = 15;
    private String imei;

    public HTCDesire() {
        super();
        super.setBrand("HTC");
        super.setModel("HTC Desire");
    }

    @Override
    public int getBatteryLife() {
        return batteryLife;
    }
}
