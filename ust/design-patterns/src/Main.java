import designpattern.creational.singleton.PlayService;
import designpattern.structural.adaptor.Android;
import designpattern.structural.adaptor.IPhone;
import designpattern.structural.adaptor.LightningToTypeCAdapter;
import designpattern.structural.adaptor.TypeCToLightningAdapter;
import interfacesegregation.BasicHPPrinter;
import interfacesegregation.HPPrinter;
import interfacesegregation.Printer;
import liskovsubstitution.AdvanceCalculator;
import liskovsubstitution.Calculator;
import opencloseprincple.Phone;

public class Main {
    public static void main(String[] args) {

//        Object phone = new Phone();
//
//        if(phone instanceof Phone p){
//            p.takePicture();
//        } else if (phone instanceof IPhone p){
//            p.takeShots();
//        }

//        Calculator calculator = new AdvanceCalculator();
//        System.out.println(calculator.add(4, 5));

//        HPPrinter printer = new HPPrinter();
//        printer.print();
//        printer.scan();

        // designpatterns - creational - singleton
//        PlayService playService1 = PlayService.getObject();
//        playService1.setValue("Charan");
//        PlayService playService2 = PlayService.getObject();
//        playService1.setValue("Ruseel");
//
//        playService1.printValue();
//        playService2.printValue();

        // Structural design pattern

        IPhone iPhone13 = new IPhone();
        Android android15 = new Android();
//        iPhone13.charge();

        TypeCToLightningAdapter typeCToLightningAdapter = new TypeCToLightningAdapter(iPhone13);
        typeCToLightningAdapter.chargeWithTypeC();

        LightningToTypeCAdapter typeCAdapter = new LightningToTypeCAdapter(android15);
        typeCAdapter.chargeWithLightning();

    }
}