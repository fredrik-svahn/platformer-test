public abstract class GameSystem {
    private Class[] requiredComponents;

    public GameSystem() {

    }

    public GameSystem(Class[] requiredComponents) {
        this.requiredComponents = requiredComponents;
    }

    public Class[] getRequiredComponents() {
        return requiredComponents;
    }

    protected boolean verify(Entity e) {
        if(e.hasComponents(getRequiredComponents())) {
            return true;
        }

        return false;
    }
}
