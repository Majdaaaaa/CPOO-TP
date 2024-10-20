package transport.medium;

import transport.exceptions.OutOfReachException;
import transport.exceptions.OverweightException;

public class ChopperPlaneAdapter implements Plane {
    private Chopper chopper;

    public ChopperPlaneAdapter(Chopper c) {
        this.chopper = c;
    }

    @Override
    public void load(int weight) {
        if(isFlying()){
            chopper.hook(weight);
        }
        
    }

    @Override
    public void unload(int weight) {
        if(isFlying()){
             chopper.unhook();
        }
       
    }

    @Override
    public void takeoff() throws OverweightException {
        chopper.takeoff();
    }

    @Override
    public void land() {
        chopper.land();
    }

    @Override
    public boolean isFlying() {
        return chopper.isFlying();
    }

    @Override
    public void fly(int distance) throws OutOfReachException {
        try {
            chopper.fly(distance);
        } catch (OverweightException e) {
            throw new OutOfReachException();
        }

    }

    @Override
    public int currentLoad() {
       return chopper.currentLoad();
    }

    @Override
    public int maxLoad() {
        return chopper.maxLoad();
    }

    @Override
    public int maxReach() {
       return chopper.maxCurrentReach();
    }

}
