public class GravitySystem extends GameSystem {
    public GravitySystem(Class[] req) {
        super(req);
    }

    public void process(Entity e) {
        if (!verify(e)) {
            return;
        }

        GravityComponent gravity = (GravityComponent) e.getComponent(GravityComponent.class);
        VelocityComponent velocity = (VelocityComponent) e.getComponent(VelocityComponent.class);

        velocity.y += gravity.strength;
    }
}
