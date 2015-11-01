package com.fr.mowitnow.mow.framework.action;

import java.util.HashMap;
import java.util.Map;

import com.fr.mowitnow.mow.framework.constant.EnumAction;

/**
 * The mow action cache. A factory to get different Mow action declination.
 * 
 * @author ehuguette
 * @since 1.0
 */
public final class MowActionCache {

	/** The mow actions generated in a map. */
	private Map<EnumAction, IMowAction> mowActionMap = new HashMap<>();

	/**
	 * Constructor.
	 */
	private MowActionCache() {

	}

	/**
	 * Enum mow action cache Lazy initializer.
	 */
	private static class MowActionFactoryHolder {

		/** The Single instance of {@link MowActionCache} generated. */
		private static final MowActionCache INSTANCE = new MowActionCache();
	}

	/**
	 * Get the singleton mow action cache instance.
	 * 
	 * @return {@link MowActionCache} The singleton instance
	 */
	public static MowActionCache getInstance() {
		return MowActionFactoryHolder.INSTANCE;
	}

	/**
	 * Get The mow action interface from selected type of action.
	 * 
	 * @param actionType
	 *            The action type
	 * @return {@link IMowAction} the interface of mow action
	 */
	public IMowAction getMowAction(EnumAction actionType) {
		IMowAction mowAction = this.mowActionMap.get(actionType);
		if (mowAction == null) {
			mowAction = initMowAction(actionType);
			this.mowActionMap.put(actionType, mowAction);
		}
		return mowAction;
	}

	/**
	 * Initialize The mow action interface from selected type of action.
	 * 
	 * @param actionType
	 *            The action type
	 * @return {@link IMowAction} the interface of mow action
	 */
	private IMowAction initMowAction(EnumAction actionType) {
		IMowAction mowAction = null;
		switch (actionType) {
			case A :
				mowAction = new MowActionMove();
				break;
			case D :
				mowAction = new MowActionTurnRight();
				break;
			case G :
				mowAction = new MowActionTurnLeft();
				break;
			default :
				throw new IllegalArgumentException("Enum action unknown :"
						+ actionType);
		}
		return mowAction;
	}

}
