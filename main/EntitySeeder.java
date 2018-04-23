import java.util.LinkedList;

public class EntitySeeder {
    private LinkedList<Entity> entities;

    public EntitySeeder(LinkedList<Entity> entities) {
        this.entities = entities;
    }

    public void generate() {
        Player player = new Player();
        Opponent opponent = new Opponent();
        entities.add(player);
        entities.add(opponent);
    }
}
