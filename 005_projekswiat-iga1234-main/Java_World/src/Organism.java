import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract public class Organism {

    private int power;
    private int initiative;
    private Position position;
    private int liveLength;
    private int powerToReproduce;
    private String sign;
    private World world;

    public void setPower(int power) {
        this.power = power;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setLiveLength(int liveLength) {
        this.liveLength = liveLength;
    }

    public void setPowerToReproduce(int powerToReproduce) {
        this.powerToReproduce = powerToReproduce;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public int getPower() {
        return power;
    }

    public int getInitiative() {
        return initiative;
    }

    public Position getPosition() {
        return position;
    }

    public int getLiveLength() {
        return liveLength;
    }

    public int getPowerToReproduce() {
        return powerToReproduce;
    }

    public String getSign() {
        return sign;
    }

    public World getWorld() {
        return world;
    }

    public Organism(Organism organism, Position position, World world) {


        if (organism != null) {
            this.initiative = organism.getInitiative();
            this.liveLength = organism.getLiveLength();
            this.position = organism.getPosition();
            this.power = organism.getPower();
            this.powerToReproduce = organism.getPowerToReproduce();
            this.sign = organism.getSign();
            this.world = organism.getWorld();
        } else {
            if (position != null) {
                this.position = position;
            }
            if (world != null) {
                this.world = world;
            }
        }
    }

    public List<Action> consequences(Organism attackingOrganism) {

        List<Action> result = new ArrayList<Action>();

        if (this.power > attackingOrganism.getPower()) {
            result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, attackingOrganism));
        } else {
            result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, this));

        }
        return result;
    }

    public boolean ifReproduce(){
        return this.power >= this.powerToReproduce;
    }

    abstract public List<Action> move();

    abstract public List<Action> action();

    abstract public Organism clone();

    abstract public void initParams();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organism organism = (Organism) o;
        return power == organism.power && initiative == organism.initiative && liveLength == organism.liveLength && powerToReproduce == organism.powerToReproduce && Objects.equals(position, organism.position) && Objects.equals(sign, organism.sign) && Objects.equals(world, organism.world);
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, initiative, position, liveLength, powerToReproduce, sign, world);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
