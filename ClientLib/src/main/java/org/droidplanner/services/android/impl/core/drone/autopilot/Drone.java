package org.droidplanner.services.android.impl.core.drone.autopilot;

import org.droidplanner.services.android.core.drone.DroneInterfaces;
import org.droidplanner.services.android.lib.drone.property.DroneAttribute;
import org.droidplanner.services.android.lib.model.ICommandListener;
import org.droidplanner.services.android.lib.model.action.Action;

/**
 * Created by Fredia Huya-Kouadio on 7/27/15.
 */
public interface Drone {

    /**
     * Gets the vehicle id.
     * The format used for the vehicle id is autopilot specific.
     * @return Vehicle id
     */
    String getId();

    boolean isConnected();

    DroneAttribute getAttribute(String attributeType);

    boolean executeAsyncAction(Action action, ICommandListener listener);

    void setAttributeListener(DroneInterfaces.AttributeEventListener listener);

    void destroy();

    void addDroneListener(DroneInterfaces.OnDroneListener listener);

    void removeDroneListener(DroneInterfaces.OnDroneListener listener);

    void notifyDroneEvent(DroneInterfaces.DroneEventsType event);
}