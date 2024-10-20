package transport.medium;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import transport.TransportRoutine;

public class PelicanTransportRoutine extends TransportRoutine {

    @Override
    public Plane createPlane() {
        return new LoggedPlane(new Pelican(), new BufferedWriter(new OutputStreamWriter(System.out)));
    }
    
}
