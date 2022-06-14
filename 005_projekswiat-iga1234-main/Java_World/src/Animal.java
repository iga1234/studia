import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


abstract public class Animal extends Organism {

    private Position lastPosition;

    public Animal(Organism animal, Position position, World world) {
        super(animal, position, world);
        this.lastPosition = position;
    }

    public Position getLastPosition() {
        return this.lastPosition;
    }

    public void setLastPosition(Position value){
        this.lastPosition = value;
    }

    public List<Action> move() {
        List<Action> result = new ArrayList<Action>();
        List<Position> pomPositions = this.getNeighboringPositions();
        Position newPosition = null;

        if(this.getWorld().isAlienNearBy(this.getPosition())){
            return result;
        }

        if (pomPositions != null && pomPositions.size() > 0) {
            java.util.Random random = new java.util.Random();
            int newPositionInt = random.nextInt(pomPositions.size());
            newPosition = pomPositions.get(newPositionInt);
            result.add(new Action(ActionEnum.A_MOVE, newPosition, 0, this));
            this.lastPosition = this.getPosition();
            Organism metOrganism = this.getWorld().getOrganismFromPosition(newPosition);
            if(metOrganism  != null) {
                result.addAll(metOrganism.consequences(this));
            }
        }
        return result;
    }

    public  List<Action> action() {
        List<Action> result = new ArrayList<Action>();
        Organism newAnimal;
        Position newAnimalPosition;
        List <Position> birthPositions = this.getNeighboringBirthPositions();

        if (this.ifReproduce() && birthPositions != null && birthPositions.size() > 0) {
            java.util.Random random = new java.util.Random();
            int newAnimalPositionInt = random.nextInt(birthPositions.size());
            newAnimalPosition = birthPositions.get(newAnimalPositionInt);
            newAnimal = this.clone();
            newAnimal.initParams();
            newAnimal.setPosition(newAnimalPosition);
            this.setPower(this.getPower() / 2);
            result.add(new Action(ActionEnum.A_ADD, newAnimalPosition, 0, newAnimal));
        }
        return result;
    }

    public List<Position> getNeighboringPositions() {
        return this.getWorld().getNeighboringPositions(this.getPosition());
    }
    public List<Position> getNeighboringBirthPositions() {
        return getWorld().filterFreePositions(this.getWorld().getNeighboringPositions(this.getPosition()));
    }
}
