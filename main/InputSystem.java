import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class InputSystem extends GameSystem implements KeyListener{
    private HashMap<Integer, Boolean> keys = new HashMap<>();

    public InputSystem(Class[] req) {
        super(req);
    }

    public void process(Entity e) {
        if(!verify(e)) {
            return;
        }

        InputComponent input = (InputComponent) e.getComponent(InputComponent.class);
        HashMap<Integer, Runnable> binds = input.binds;
        for(Integer key: binds.keySet()) {
            if(keys.get(key) != null) {
                if(keys.get(key)) {
                    if(binds.get(key) != null) {
                        binds.get(key).run();
                    }
                }
                else {
                    if(binds.get(-key) != null) {
                        binds.get(-key).run();
                    }
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.put(e.getKeyCode(), false);
    }
}
