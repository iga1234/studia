import java.util.ArrayList;
import java.util.List;

public class Wolf extends Animal {

    public Wolf(Organism wolf, Position position, World world) {
        super(wolf, position, world);


    }

    public Wolf clone() {

        return new Wolf(this, null, null);
    }


    public void initParams() {
        this.setPower(6);
        this.setInitiative(5);
        this.setLiveLength(15);
        this.setPowerToReproduce(12);
        this.setSign("W");
    }

    public List<Position> getNeighboringPositions() {
        return this.getWorld().filterPositionsWithOtherSpecies(this.getWorld().getNeighboringPositions(this.getPosition()), Wolf.class);
    }
}
