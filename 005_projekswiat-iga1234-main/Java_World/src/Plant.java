import java.util.ArrayList;
import java.util.List;

abstract public class Plant extends Organism {

    public Plant(Organism plant, Position position, World world) {
        super(plant, position, world);

    }

    public List<Action> move() {
        List<Action> result = new ArrayList<Action>();
        return result;
    }

    public List<Action> action() {
        List<Action> result = new ArrayList<Action>();
        Organism newPlant;
        Position newPosition;

        if (this.ifReproduce()) {
            List <Position> pomPositions = this.getFreeNeighboringPosition(this.getPosition());
            if (pomPositions != null && !pomPositions.isEmpty()) {
                java.util.Random random = new java.util.Random();
                int newPositionInt = random.nextInt(pomPositions.size());
                newPosition = pomPositions.get(newPositionInt);
                newPlant = this.clone();
                newPlant.initParams();
                newPlant.setPosition(newPosition);
                this.setPower(this.getPower()/ 2);
                result.add(new Action(ActionEnum.A_ADD, newPosition, 0, newPlant));
            }
        }
        return result;
    }
    
    public List<Position> getFreeNeighboringPosition(Position position) {
        return this.getWorld().filterFreePositions(this.getWorld().getNeighboringPositions(position));
    }

}
