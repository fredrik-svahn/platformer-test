public class MovementSystem extends GameSystem {
    public MovementSystem(Class[] req) {
        super(req);
    }

    public void process(Entity e) {
        if(!verify(e)) {
            return;
        }


        PositionComponent position = (PositionComponent) e.getComponent(PositionComponent.class);
        VelocityComponent velocity = (VelocityComponent) e.getComponent(VelocityComponent.class);

        position.x += velocity.x;
        position.y += velocity.y;
    }
}
