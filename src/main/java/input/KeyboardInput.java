package input;

import org.lwjgl.glfw.GLFWCharModsCallback;
import org.lwjgl.glfw.GLFWKeyCallback;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Created on 12/05/2016 by ThePadna.
 */
public class KeyboardInput extends GLFWKeyCallback {

    public static boolean keys[] = new boolean[104];

    public void invoke(long window, int key, int scancode, int action, int mods) {
        keys[key] = (action != GLFW_RELEASE);
    }

    public static boolean keyDown(int keyCode) {
        return keys[keyCode];
    }
}
