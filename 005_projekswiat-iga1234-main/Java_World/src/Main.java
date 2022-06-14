import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        World pyWorld = new World.Builder()
                .alien(new Position(5,5))
                .dandelion(new Position(0, 4))
                .toadstool(new Position(4,4))
                .grass(new Position(4,0))
                .wolf(new Position(7,7))
                .sheep(new Position(0,0))
                .build(8, 8);

        System.out.print(pyWorld);

        for (int i = 0; i < 100; i++){

            System.in.read();
            System.out.print("\033[H\033[2J ");
            System.out.flush();
            pyWorld.makeTurn();
            System.out.print(pyWorld.toString());
        }
    }
}
