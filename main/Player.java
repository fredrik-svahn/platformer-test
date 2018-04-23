import java.awt.event.KeyEvent;

import java.awt.*;

public class Player extends Entity {
    public Player() {
        RenderComponent renderComponent = new RenderComponent();
        PositionComponent positionComponent = new PositionComponent();
        VelocityComponent velocityComponent = new VelocityComponent();
        InputComponent inputComponent = new InputComponent();
        GravityComponent gravityComponent = new GravityComponent();
        CollisionComponent collisionComponent = new CollisionComponent();

        inputComponent.binds.put(KeyEvent.VK_LEFT, this::left);
        inputComponent.binds.put(KeyEvent.VK_UP, this::up);
        inputComponent.binds.put(KeyEvent.VK_DOWN, this::down);
        inputComponent.binds.put(KeyEvent.VK_RIGHT, this::right);

        renderComponent.color = Color.RED;
        renderComponent.width = 50;
        renderComponent.height = 50;

        positionComponent.x = 0;
        positionComponent.y = 0;

        velocityComponent.x = 0f;
        velocityComponent.y = 0f;

        gravityComponent.strength = 0f;

        collisionComponent.width = 50;
        collisionComponent.height = 50;
        collisionComponent.solid = true;
        collisionComponent.action = e -> printCollision(e);


        components.put(RenderComponent.class, renderComponent);
        components.put(PositionComponent.class, positionComponent);
        components.put(VelocityComponent.class, velocityComponent);
        components.put(InputComponent.class, inputComponent);
        components.put(GravityComponent.class, gravityComponent);
        components.put(CollisionComponent.class, collisionComponent);
    }

    private VelocityComponent getVelocity() {
        return (VelocityComponent) components.get(VelocityComponent.class);
    }

    private PositionComponent getPosition() {
        return (PositionComponent) components.get(PositionComponent.class);
    }

    private GravityComponent getGravity() {
        return (GravityComponent) components.get(GravityComponent.class);
    }

    public void printCollision(Entity e) {
        System.out.println("Collided with: " + e);
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
