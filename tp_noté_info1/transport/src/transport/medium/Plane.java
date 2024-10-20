package transport.medium;

import transport.exceptions.OutOfReachException;
import transport.exceptions.OverweightException;

/**
 * Interface des avions.
 * 
 * @author Emmanuel Bigeon
 *
 */
public interface Plane {
	/**
	 * Charge un certain poids dans l'avion
	 * 
	 * @param weight le poids à ajouter
	 */
	void load(int weight);

	/**
	 * Décharge un certain poids de l'avion
	 * 
	 * @param weight le poids à retirer
	 */
	void unload(int weight);

	/**
	 * Fait décoller l'avion.
	 * <p>
	 * Dans le cas ou l'avion est en l'air ceci n'a aucun effet.
	 * 
	 * @throws OverweightException si l'avion est trop chargé
	 */
	void takeoff() throws OverweightException;

	/**
	 * Fait atterrir l'avion
	 * <p>
	 * Dans le cas ou l'avion est au sol ceci n'a aucun effet.
	 */
	void land();

	/**
	 * Indique si l'avion est en l'air
	 * 
	 * @return si l'avion est en l'air
	 */
	boolean isFlying();

	/**
	 * Fait se déplacer l'avion d'une certaine distance
	 * 
	 * @param distance la distance
	 * @throws OutOfReachException si la distance depuis le dernier décollage est
	 *                             trop grande
	 */
	void fly(int distance) throws OutOfReachException;

	/**
	 * Donne la charge courante de l'avion
	 * 
	 * @return charge courante
	 */
	int currentLoad();

	/**
	 * Donne la charge maximale pour que l'avion puisse encore décoller.
	 * 
	 * @return charge maximale pour le décollage
	 */
	int maxLoad();
	
	/**
	 * Donne la distance maximale que l'avion peut parcourir en une fois.
	 * 
	 * @return distance maximale de vol de l'avion
	 */
	int maxReach();
}
