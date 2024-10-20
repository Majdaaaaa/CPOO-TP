package transport.medium;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import transport.TransportRoutine;

public class ChopperTransportRoutine extends TransportRoutine {

    @Override
    public Plane createPlane() {
        return new LoggedPlane(new ChopperPlaneAdapter(new Chopper()), new BufferedWriter(new OutputStreamWriter(System.out)));
    }
    
}
