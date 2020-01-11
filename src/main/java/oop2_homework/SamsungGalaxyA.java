package oop2_homework;

public class SamsungGalaxyA extends PhoneByBrand {
    private final static int batteryLife = 15;
    private String imei;

    public SamsungGalaxyA(String imei) {
        super();
        super.setBrand("Samsung");
        super.setModel("Samsung Galaxy A");
        this.imei = imei;
    }
    @Override
    public int getBatteryLife() {
        return batteryLife;
    }
}
