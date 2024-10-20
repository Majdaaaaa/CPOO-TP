package transport.medium;

import java.util.logging.Level;
import java.util.logging.Logger;

import transport.exceptions.OutOfReachException;
import transport.exceptions.OverweightException;

/**
 * Classe représentant un hélicoptère.
 * <p>
 * Un hélicoptère peut décoller, atterrir, se déplacer en l'air, avoir une
 * charge attaché ou retirée. Les conditions pour chacune de ces actions sont
 * précisées dans les documentation des méthodes correspondantes.
 * <p>
 * A noter que l'attache d'un poids à l'hélicoptère prends elle même une unité
 * de poids supplémentaire.
 * 
 * @author Emmanuel
 *
 */
public class Chopper {
	private static final int CAPACITY = 50;
	private static final int MAX_REACH = 100;
	private static final Logger LOGGER = Logger.getLogger(Chopper.class.getName());

	private int load = 0;
	private boolean flying = false;
	private int reach = 0;

	/**
	 * Attache un certain poids à l'hélicoptère.
	 * <p>
	 * L'attache prends une unité de poids en plus.
	 * <p>
	 * Les conditions pour attacher une charge sont que:
	 * <ul>
	 * <li>Aucune cherge n'est attachée.
	 * <li>L'hélicoptère soit en vol
	 * </ul>
	 * 
	 * @param weight le poids à ajouter
	 */
	public void hook(int weight) {
		LOGGER.log(Level.INFO, ()-> "Hooking "+weight+"kg");
		if (load != 0) {
			throw new IllegalStateException("Cannot hook a package if one is already there");
		}
		if (!flying) {
			throw new IllegalStateException("Cannot hook a package to a landed chopper");
		}
		load = weight + 1;
	}

	/**
	 * Décharge le colis transporté
	 */
	public void unhook() {
		LOGGER.log(Level.INFO, "Unhooking");
		load = 0;
	}

	/**
	 * Fait décoller l'hélicoptère.
	 * <p>
	 * Dans le cas ou l'hélicoptère est en l'air ceci n'a aucun effet.
	 * 
	 */
	public void takeoff() {
		if (!isFlying()) {
			reach = MAX_REACH;
			flying = true;
			LOGGER.log(Level.INFO, "Taking off");
		}
	}

	/**
	 * Fait atterrir l'hélicoptère
	 * <p>
	 * Dans le cas ou l'hélicoptère est au sol ceci n'a aucun effet.
	 * <p>
	 * Les conditions pour atterir sont qu'on ne transporte pas de charge.
	 */
	public void land() {
		if (load != 0) {
			throw new IllegalStateException("Cannot land while carrying a package");
		}
		flying = false;
	}

	/**
	 * Indique si l'hélicoptère est en l'air
	 * 
	 * @return si l'hélicoptère est en l'air
	 */
	public boolean isFlying() {
		return flying;
	}

	/**
	 * Fait se déplacer l'hélicoptère d'une certaine distance
	 * 
	 * @param distance la distance
	 * @throws OutOfReachException si la distance depuis le dernier décollage est
	 *                             trop grande
	 * @throws OverweightException si l'hélicoptère est trop chargé
	 */
	public void fly(int distance) throws OutOfReachException, OverweightException {
		LOGGER.log(Level.INFO, ()-> "Flying "+distance+"km");
		if (load > CAPACITY) {
			throw new OverweightException();
		}
		if (distance > reach) {
			throw new OutOfReachException();
		}
		reach -= distance;
	}

	/**
	 * Donne la charge courante de l'hélicoptère
	 * 
	 * @return charge courante
	 */
	public int currentLoad() {
		return load;
	}

	/**
	 * Donne la charge maximale pour que l'hélicoptère puisse se déplacer.
	 * 
	 * @return charge maximale pour le déplacement
	 */
	public int maxLoad() {
		return CAPACITY;
	}

	/**
	 * Donne la distance maximale courante que l'hélicoptère peut encore parcourir.
	 * 
	 * @return la distance que l'hélicoptère peut encore parcourir
	 */
	public int maxCurrentReach() {
		return reach;
	}
}
