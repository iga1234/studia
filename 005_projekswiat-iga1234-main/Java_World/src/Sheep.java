import java.util.List;

public class Sheep extends Animal{

    public Sheep(Organism sheep, Position position, World world) {
        super(sheep, position, world);
    }

    public Sheep clone() {
        return new Sheep(this, null, null);
    }


    public void initParams() {
        this.setPower(3);
        this.setInitiative(3);
        this.setLiveLength(13);
        this.setPowerToReproduce(6);
        this.setSign("S");
    }

    public List<Position> getNeighboringPositions() {
        return this.getWorld().filterPositionsWithoutAnimals(this.getWorld().getNeighboringPositions(this.getPosition()));
    }
}

