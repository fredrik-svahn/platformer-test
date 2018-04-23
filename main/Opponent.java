import java.awt.*;
import java.awt.event.KeyEvent;

public class Opponent extends Entity{

    private int health = 50;

    public Opponent() {
        RenderComponent renderComponent = new RenderComponent();
        PositionComponent positionComponent = new PositionComponent();
        VelocityComponent velocityComponent = new VelocityComponent();
        InputComponent inputComponent = new InputComponent();
        CollisionComponent collisionComponent = new CollisionComponent();

        inputComponent.binds.put(KeyEvent.VK_A, this::left);
        inputComponent.binds.put(KeyEvent.VK_W, this::up);
        inputComponent.binds.put(KeyEvent.VK_S, this::down);
        inputComponent.binds.put(KeyEvent.VK_D, this::right);

        renderComponent.color = Color.BLUE;
        renderComponent.width = 50;
        renderComponent.height = 50;

        positionComponent.x = 250;
        positionComponent.y = 0;

        velocityComponent.x = 0f;
        velocityComponent.y = 0f;

        collisionComponent.width = 50;
        collisionComponent.height = 50;
        collisionComponent.solid = true;
        collisionComponent.action = e -> reduceHealth(e);

        components.put(RenderComponent.class, renderComponent);
        components.put(PositionComponent.class, positionComponent);
        components.put(VelocityComponent.class, velocityComponent);
        components.put(InputComponent.class, inputComponent);
        components.put(CollisionComponent.class, collisionComponent);
    }

    private void reduceHealth(Entity e) {
        health--;

        if(health <= 0) {
            alive = false;
        }
    }

    private VelocityComponent getVelocity() {
        return (VelocityComponent) components.get(VelocityComponent.class);
    }

    private PositionComponent getPosition() {
        return (PositionComponent) components.get(PositionComponent.class);
    }

    public void left() {
        getPosition().x += -2;
    }

    public void right() {
        getPosition().x += 2;

    }

    public void up() {
        getPosition().y += -2;

    }

    public void down() {
        getPosition().y += 2;
    }
}
