package designpattern.structural.adaptor;

public class LightningToTypeCAdapter implements LightningCharger{

    private Android android;

    public LightningToTypeCAdapter(Android android){
        this.android = android;
    }

    @Override
    public void chargeWithLightning() {
        android.charge();
    }
}
