package com.yakovliam.knowbeforeyougo.client.model;

import com.yakovliam.knowbeforeyougo.client.service.wichild.WIChildManagerService;

public class WirelessInterface {

    /**
     * The mode that the current target wireless interface is in
     */
    private InterfaceMode mode;

    /**
     * The handle or name of the target wireless interface
     */
    private final String handle;

    /**
     * The actual management service for the interface
     */
    private final WIChildManagerService managerService;

    /**
     * Construct a wireless interface
     *
     * @param handle handle
     * @param def    default
     */
    public WirelessInterface(String handle, InterfaceMode def) {
        this.handle = handle;
        this.mode = def;
        this.managerService = new WIChildManagerService(this);
    }

    /**
     * Construct a wireless interface
     *
     * @param handle handle
     */
    public WirelessInterface(String handle) {
        this(handle, InterfaceMode.MANAGED);
    }

    /**
     * Returns the mode
     *
     * @return mode
     */
    public InterfaceMode getMode() {
        return mode;
    }

    /**
     * Sets the mode
     *
     * @param mode mode
     */
    public void setMode(InterfaceMode mode) {
        this.mode = mode;
    }

    /**
     * Returns the handle
     *
     * @return handle
     */
    public String getHandle() {
        return handle;
    }

    /**
     * Returns the management service
     *
     * @return service
     */
    public WIChildManagerService getManagerService() {
        return managerService;
    }
}
