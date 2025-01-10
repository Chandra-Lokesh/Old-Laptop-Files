package designpattern.structural.adaptor;

public class TypeCToLightningAdapter implements TypeCCharger{

    private IPhone iPhone;

    @Override
    public void chargeWithTypeC() {
        iPhone.charge();
    }

    public TypeCToLightningAdapter(IPhone iPhone){
        this.iPhone = iPhone;
    }

}
