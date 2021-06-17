package com.yakovliam.knowbeforeyougo.client.service;

import com.yakovliam.knowbeforeyougo.client.model.WirelessInterface;

public abstract class WIServiceChild {

    /**
     * The parent/target interface
     */
    protected WirelessInterface parent;

    /**
     * WIServiceChild
     *
     * @param parent parent
     */
    public WIServiceChild(WirelessInterface parent) {
        this.parent = parent;
    }

    /**
     * Switches the mode of the wireless interface
     */
    public abstract void switchModes();
}
