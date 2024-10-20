package transport.medium;

import transport.exceptions.OutOfReachException;
import transport.exceptions.OverweightException;

public class Pelican implements Plane {

    private int MAXLOAD = 5000;
    private int MAX_DISTANCE = 1000;

    private int load = 0; // ce qui est chargé
    private boolean flying = false; // Si en plein vol
    private int parcouru = 0;

    @Override
    public void load(int weight) {
        if(!isFlying()){
            load += weight;
        }
        
    }

    @Override
    public void unload(int weight) {
        if(!isFlying()){
            load -= weight;
        }
    }

    @Override
    public void takeoff() throws OverweightException{
        if(load>MAXLOAD){
            throw new OverweightException();
        }else{
            this.flying=true;
        }
    }

    @Override
    public void land() {
        if(isFlying() && parcouru <= MAX_DISTANCE){
            this.flying=false;
            this.parcouru=0;
        }

    }

    @Override
    public boolean isFlying() {
       return this.flying;
    }

    @Override
    public void fly(int distance) throws OutOfReachException {
       if(this.parcouru >= MAX_DISTANCE){
        throw new OutOfReachException();
       }else{
        this.parcouru+=distance;
       }
    }

    @Override
    public int currentLoad() {
       return this.load;
    }

    @Override
    public int maxLoad() {
        return this.MAXLOAD;
    }

    @Override
    public int maxReach() {
        return this.MAX_DISTANCE;
    }

}
