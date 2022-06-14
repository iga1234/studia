import java.util.ArrayList;
import java.util.List;

public class Toadstool extends Plant{

    public Toadstool(Organism toadstool, Position position, World world) {

        super(toadstool, position, world);

    }

    public Toadstool clone() {
        return new Toadstool(this, null, null);
    }

    public void initParams() {
        this.setPower(0);
        this.setInitiative(0);
        this.setLiveLength(10);
        this.setPowerToReproduce(1);
        this.setSign("T");
    }
    public List<Action> consequences(Organism attackingOrganism) {

        List<Action> result = new ArrayList<Action>();

        if (this.getPower() > attackingOrganism.getPower()) {
            result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, attackingOrganism));
        } else {
            result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, this));

        }
        return result;
    }


}
