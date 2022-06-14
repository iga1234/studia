import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class WorldTests {

    @Test (expected = IllegalStateException.class)
    public void worldIsSingleton(){
        new World(8,8);
        new World(10,10);
    }

    @Test
    public void consequencesPositionTest(){
        World world = new World(8,8);
        Sheep sheep = new Sheep(null,new Position(5,5), world);
        Wolf wolf = new Wolf(null, new Position(5,5), world);
        List<Action> result = wolf.consequences(sheep);
        Position expected = new Position(-1,-1);
        Position actual = result.get(0).getPosition();

        assertEquals(expected, actual);

    }

    @Test
    public void SheepVsWolfTest(){
        World world = new World(8,8);
        Sheep sheep = new Sheep(null,new Position(5,5), world);
        Wolf wolf = new Wolf(null, new Position(5,5), world);
        List<Action> result = wolf.consequences(sheep);
        Organism expected = new Wolf(null, new Position(5,5), world);
        Organism actual = result.get(0).getOrganism();

        assertEquals(expected, actual);
    }

    @Test
    public void WolfVsDandelionTest(){
        World world = new World(8,8);
        Wolf wolf = new Wolf(null,new Position(3,3), world);
        Dandelion dandelion = new Dandelion(null, new Position(3,3), world);
        List<Action> result = wolf.consequences(dandelion);
        Organism expected = new Wolf(null, new Position(3,3), world);
        Organism actual = result.get(0).getOrganism();

        assertEquals(expected, actual);
    }

    @Test
    public void WolfVsGrass(){
        World world = new World(8,8);
        Grass grass = new Grass(null,new Position(5,5), world);
        Wolf wolf = new Wolf(null, new Position(5,5), world);
        List<Action> result = wolf.consequences(grass);
        Organism expected = new Wolf(null, new Position(5,5), world);
        Organism actual = result.get(0).getOrganism();

        assertEquals(expected, actual);
    }
    @Test
    public void SheepVsGrassTest(){
        World world = new World(8,8);
        Sheep sheep = new Sheep(null,new Position(5,5), world);
        Wolf wolf = new Wolf(null, new Position(5,5), world);
        List<Action> result = wolf.consequences(sheep);
        Organism expected = new Wolf(null, new Position(5,5), world);
        Organism actual = result.get(0).getOrganism();

        assertEquals(expected, actual);
    }

    @Test
    public void SheepVsToadstoolTest(){
        World world = new World(8,8);
        Sheep sheep = new Sheep(null,new Position(3,3), world);
        Toadstool toadstool = new Toadstool(null, new Position(3,3), world);
        List<Action> result = sheep.consequences(toadstool);
        Organism expected = new Sheep(null, new Position(3,3), world);
        Organism actual = result.get(0).getOrganism();

        assertEquals(expected, actual);
    }
}
