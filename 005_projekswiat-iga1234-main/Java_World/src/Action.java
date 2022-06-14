public class Action {

    private Integer value;
    private ActionEnum action;
    private Position position;
    private Organism organism;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Organism getOrganism() {
        return organism;
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }

    public Action(ActionEnum action, Position position, Integer value, Organism organism) {
        this.value = value;
        this.action = action;
        this.position = position;
        this.organism = organism;
    }

    @Override
    public String toString() {

        if(ActionEnum.A_ADD.equals(this.action)){
            return this.organism.getClass().getSimpleName() + ": add at: " + this.position;
        }
        if(ActionEnum.A_INCREASEPOWER.equals(this.action)){
            return this.organism.getClass().getSimpleName() + ": increase power: " + this.value;
        }
        if(ActionEnum.A_MOVE.equals(this.action)){
            return this.organism.getClass().getSimpleName() + ": move from " + this.organism.getPosition() + " to: " + this.position;
        }
        if(ActionEnum.A_REMOVE.equals(this.action)){
            return this.organism.getClass().getSimpleName() + ": remove from: " + this.organism.getPosition();
        }
        return "Action{" +
                "action=" + action +
                ", organism=" + organism +
                '}';
    }
}
