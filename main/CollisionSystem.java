import java.util.List;

public class CollisionSystem extends GameSystem {
    public CollisionSystem(Class[] req) {
        super(req);
    }


    public void process(Entity e, List<Entity> entities) {


        if(!verify(e)) {
            return;
        }

        for(Entity entity : entities) {
            if(!verify(entity) || entity == e) {
                continue;
            }

            PositionComponent position1 = (PositionComponent) e.getComponent(PositionComponent.class);
            CollisionComponent collision1 = (CollisionComponent) e.getComponent(CollisionComponent.class);

            PositionComponent position2 = (PositionComponent) entity.getComponent(PositionComponent.class);
            CollisionComponent collision2 = (CollisionComponent) entity.getComponent(CollisionComponent.class);

            if(isColliding(position1, collision1, position2, collision2)) {
                collision1.action.handle(entity);
            }
        }
    }

    private boolean isColliding(PositionComponent position1, CollisionComponent collision1, PositionComponent position2, CollisionComponent collision2) {
        if(!(collision1.solid || collision2.solid)) {
            return false;
        }

        if(position1.x + collision1.width >= position2.x && position1.x <= position2.x + collision2.width) {
            if(position1.y + collision1.height >= position2.y && position1.y <= position2.y + collision2.height) {
                return true;
            }
        }

        return false;

    }


}
