package modes;
import input.KeyboardInput;
import input.MouseInput;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
/**
 * Created on 12/05/2016 by ThePadna.
 */
public class GameFrame {

    private final GLFWKeyCallback keyInput = new KeyboardInput();
    private final GLFWCursorPosCallback mouseInput = new MouseInput();

    public GameFrame() {
        boolean initialized = glfwInit() == 1 ? true : false;
        if(!initialized) {
            System.err.print("GLFW failed initialization.");
            System.exit(1);
        }
        long window = glfwCreateWindow(500, 750, "Infiltrations", 0, 0);
        glfwShowWindow(window);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        glfwSetKeyCallback(window, keyInput);
        glfwSetCursorPosCallback(window, mouseInput);

        while(glfwWindowShouldClose(window) != 1) {
            glfwPollEvents();
            glClear(GL_COLOR_BUFFER_BIT);
        }

    }
}
