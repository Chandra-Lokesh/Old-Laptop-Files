package SimExample;

public class Phone {

    Sim sim;
    public void setSim(Sim sim){
        this.sim = sim;
    }
    public void browse(){
        sim.browse();
    }
    public void call(){
        sim.call();
    }
}
