import java.awt.*;

public class RenderSystem extends GameSystem {

    public RenderSystem(Class[] requiredComponents) {
          super(requiredComponents);
    }

    public void process(Entity e, Graphics g) {
        if(!verify(e)) {
            return;
        }

        PositionComponent position = (PositionComponent) e.getComponent(PositionComponent.class);
        RenderComponent render = (RenderComponent) e.getComponent(RenderComponent.class);

        g.setColor(render.color);
        g.fillRect((int)position.x, (int)position.y, render.width, render.height);
    }
}
