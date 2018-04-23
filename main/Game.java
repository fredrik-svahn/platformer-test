import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Game extends JPanel {
    private RenderSystem renderSystem;
    private MovementSystem movementSystem;
    private InputSystem inputSystem;
    private GravitySystem gravitySystem;
    private CollisionSystem collisionSystem;
    private JFrame frame;
    private boolean running;
    private LinkedList<Entity> entities;

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public Game() {
        frame = JFrameFactory.createFrame("Platformer", 500, 500);
        frame.add(this);

        entities = new LinkedList<>();
        renderSystem = new RenderSystem(new Class[] {PositionComponent.class, RenderComponent.class});
        movementSystem = new MovementSystem(new Class[] {PositionComponent.class, VelocityComponent.class});
        inputSystem = new InputSystem(new Class[] {InputComponent.class});
        gravitySystem = new GravitySystem(new Class[] {GravityComponent.class, VelocityComponent.class});
        collisionSystem = new CollisionSystem(new Class[] {PositionComponent.class, CollisionComponent.class});

        frame.addKeyListener(inputSystem);

        EntitySeeder es = new EntitySeeder(entities);
        es.generate();
    }

    private void start() {
        running = true;
        frame.setVisible(true);
        run();
    }

    public void run() {
        while(running) {
            try {
                executeNormalSystems();
                repaint();
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void executeNormalSystems() {
        for(Entity e: entities) {
            if(!e.alive) {
                entities.remove(e);
                continue;
            }

            inputSystem.process(e);
            gravitySystem.process(e);
            movementSystem.process(e);
            collisionSystem.process(e, entities);
        }
    }


    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (Entity e : entities) {
            renderSystem.process(e, g);
        }
    }
}
