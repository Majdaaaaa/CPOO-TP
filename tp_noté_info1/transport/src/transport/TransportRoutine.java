package transport;

import transport.exceptions.OutOfReachException;
import transport.exceptions.OverweightException;
import transport.medium.PelicanTransportRoutine;
import transport.medium.Plane;

public abstract class TransportRoutine {

	public abstract Plane createPlane();

	public void transport(int freight, int distance) {
		Plane plane = createPlane();

		try {
			int remainingDistance = distance;
			while (remainingDistance > 0) {
				int cover = Math.min(remainingDistance, plane.maxReach());
				carryInReach(freight, plane, cover);
				remainingDistance-= cover;
			}
		} catch (OverweightException e) {
			System.out.println("trop lourd");
		} catch (OutOfReachException e) {
			System.out.println("trop loin");
		}
	}

	private void carryInReach(int freight, Plane plane, int cover) throws OverweightException, OutOfReachException {
		int remainingFreight = freight;
		while (remainingFreight > 0) {
			int carry = Math.min(remainingFreight, plane.maxLoad());
			plane.load(carry);
			plane.takeoff();
			plane.fly(cover);
			plane.land();
			plane.unload(carry);
			remainingFreight-= carry;
			if (remainingFreight>0) {
				plane.takeoff();
				plane.fly(cover);
				plane.land();
			}
		}
	}
	
	public static void main(String[] args) {
		//.transnew TransportRoutine()port(6_000, 1_500);
		TransportRoutine routine = new PelicanTransportRoutine();
		routine.transport(6_000, 1_500);
	}
}
