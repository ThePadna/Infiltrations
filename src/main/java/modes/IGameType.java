package modes;

/**
 * Created on 12/05/2016 by ThePadna.
 */
public interface IGameType {

    public void init();
    public boolean requestClose();
    public void runTick();

}
