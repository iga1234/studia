import java.util.Objects;

public class Position {
    
    private Integer x;
    private Integer y;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Position(Position position, Integer x, Integer y) {
        this.x = 0;
        this.y = 0;
        if(position != null){
            this.x = position.getX();
            this.y = position.getY();
        }
        else{
            if(x != null){
                this.x = x;
            }
            if(y != null){
                this.y = y;
            }
        }
    }

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(x, position.x) && Objects.equals(y, position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "position (" + x + ","
                 + y + ")";
    }
}
