package com.fr.mowitnow.mow.framework.context;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fr.mowitnow.mow.framework.constant.EnumDirection;

/**
 * Implementation of the mow position.
 * 
 * @author ehuguette
 * @since 1.0
 */
public class MowPosition
        implements Observer {

    /** logger class. */
    private static final Logger LOG = LoggerFactory.getLogger(MowPosition.class);

    /** The mow coordinates on the field. */
    private Coordinates coordinates;
    /** The mow orientation. */
    private EnumDirection direction;
    /** The mow action generic operations. */
    private MowActionOperation mowActionOperation;
    /** The number of notification received. */
    private Integer notificationNumber;

    /**
     * Constructor.
     * 
     * @param xi
     *            The top right X limit parameter
     * @param yi
     *            The top right X limit parameter
     * @param direction
     *            The orientation
     */
    public MowPosition(Integer xi, Integer yi, EnumDirection direction) {
	this.coordinates = new Coordinates(xi, yi);
	this.direction = direction;
	this.mowActionOperation = new MowActionOperation();
	this.notificationNumber = 0;
    }

    /**
     * 
     * @return {@link Integer} the position of the mow on the X axe
     */
    public Integer getX() {
	return coordinates.getX();
    }

    /**
     * 
     * @return {@link Integer} the position of the mow on the Y axe
     */
    public Integer getY() {
	return coordinates.getY();
    }

    /**
     * 
     * @return {@link EnumDirection}
     */
    public EnumDirection getDirection() {
	return direction;
    }

    /**
     * @return the notificationNumber
     */
    public Integer getNotificationNumber() {
	return notificationNumber;
    }

    /**
     * Turn the mow to the next right direction.
     */
    public void turnRight() {
	this.direction = mowActionOperation.next(this.direction);
    }

    /**
     * Turn the mow to the next left direction.
     */
    public void turnLeft() {
	this.direction = mowActionOperation.previous(this.direction);
    }

    /**
     * Move the mow to next position.
     * 
     * @param mowField
     *            The mow field
     */
    public void moveOneStep(MowField mowField) {
	Coordinates coordinates = mowActionOperation.moveOneStep(this.coordinates, direction);
	if (mowActionOperation.isInFieldCoordinates(mowField, coordinates)) {
	    this.coordinates = coordinates;
	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Observable observable, Object object) {
	if (observable instanceof MowActionObservable && object instanceof MowPosition) {
	    this.notificationNumber = notificationNumber + 1;
	    MowPosition mowPosition = (MowPosition) object;
	    StringBuilder msg = new StringBuilder("Notification received from");
	    msg.append(" - ").append(mowPosition.toString());
	    msg.append(" - ").append(this.toString());
	    msg.append(" - on").append(new Date());
	    LOG.warn(msg.toString());
	} else {
	    throw new IllegalArgumentException("Waiting for and observable object and MowPosition");
	}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
	result = prime * result + ((direction == null) ? 0 : direction.hashCode());
	result = prime * result + ((notificationNumber == null) ? 0 : notificationNumber.hashCode());
	return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	MowPosition other = (MowPosition) obj;
	if (coordinates == null) {
	    if (other.coordinates != null)
		return false;
	} else if (!coordinates.equals(other.coordinates))
	    return false;
	if (direction != other.direction)
	    return false;
	if (notificationNumber == null) {
	    if (other.notificationNumber != null)
		return false;
	} else if (!notificationNumber.equals(other.notificationNumber))
	    return false;
	return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
	StringBuilder msg = new StringBuilder("Mow position");
	msg.append(" - X=").append(getX());
	msg.append(" - Y=").append(getY());
	msg.append(" - O=").append(getDirection());
	msg.append(" - nb notify=").append(getNotificationNumber());
	return msg.toString();
    }

}
