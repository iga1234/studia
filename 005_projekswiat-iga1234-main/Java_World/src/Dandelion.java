public class Dandelion extends Plant{

    public Dandelion(Organism dandelion, Position position, World world) {
        super(dandelion, position, world);
    }

    public Dandelion clone() {
        return new Dandelion(this, null, null);
    }


    public void initParams() {
        this.setPower(0);
        this.setInitiative(0);
        this.setLiveLength(8);
        this.setPowerToReproduce(1);
        this.setSign("D");
    }
}
