import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

/**
 * Created on 11/05/2016 by ThePadna.
 */
public class Util {

    public static FloatBuffer createFloatBuffer(float[] data) {
        FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(data.length);
        floatBuffer.put(data);
        floatBuffer.flip();
        return floatBuffer;
    }
}
