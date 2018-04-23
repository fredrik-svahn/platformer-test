import java.util.HashMap;

public abstract class Entity {
    protected HashMap<Class, Component> components = new HashMap<>();
    protected boolean alive = true;

    public Component getComponent(Class type) {
        return components.get(type);
    }

    public boolean hasComponents(Class[] requiredComponents) {
        for(int i = 0; i < requiredComponents.length; i++) {
            if(!components.containsKey(requiredComponents[i])) {
                return false;
            }
        }

        return true;
    }
}
