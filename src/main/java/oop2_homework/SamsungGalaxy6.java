package oop2_homework;

public class SamsungGalaxy6 extends PhoneByBrand {
    private final static int batteryLife = 10;
    private String imei;

    public SamsungGalaxy6(String imei) {
        super();
        super.setBrand("Samsung");
        super.setModel("Samsung Galaxy 6");
        this.imei = imei;
    }

    @Override
    public int getBatteryLife() {
        return batteryLife;
    }

}
