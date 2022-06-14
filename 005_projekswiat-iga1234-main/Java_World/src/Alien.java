import java.util.ArrayList;
import java.util.List;

public class Alien extends Organism{

    public Alien(Organism organism, Position position, World world) {
        super(organism, position, world);
    }

    @Override
    public List<Action> move() {

        List<Action> result = new ArrayList<Action>();
        List<Position> pomPositions = this.getNeighboringPositions();
        Position newPosition = null;

        if (pomPositions != null && pomPositions.size() > 0) {
            java.util.Random random = new java.util.Random();
            int newPositionInt = random.nextInt(pomPositions.size());
            newPosition = pomPositions.get(newPositionInt);
            result.add(new Action(ActionEnum.A_MOVE, newPosition, 0, this));
        }
        return result;
    }

    @Override
    public List<Action> action() {
        return new ArrayList<>();
    }

    @Override
    public Organism clone() {
        return this;
    }

    @Override
    public void initParams() {
        this.setPower(1);
        this.setInitiative(1);
        java.util.Random random = new java.util.Random();
        int live = random.nextInt(15);
        this.setLiveLength(live);
        this.setPowerToReproduce(0);
        this.setSign("A");
    }

    public List<Position> getNeighboringPositions() {
        return this.getWorld().getNeighboringPositions(this.getPosition());
    }
}
