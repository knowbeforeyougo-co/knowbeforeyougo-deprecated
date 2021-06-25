package com.yakovliam.knowbeforeyougo.client.service.wichild;

import com.yakovliam.knowbeforeyougo.client.io.mode.ModeSwitcherUtil;
import com.yakovliam.knowbeforeyougo.client.model.InterfaceMode;
import com.yakovliam.knowbeforeyougo.client.model.WirelessInterface;
import com.yakovliam.knowbeforeyougo.client.service.WIServiceChild;

public class WIChildManagerService extends WIServiceChild {

    /**
     * WIServiceChild
     *
     * @param parent parent
     */
    public WIChildManagerService(WirelessInterface parent) {
        super(parent);
    }

    /**
     * Switches the mode of the wireless interface
     */
    @Override
    public void switchModes() {
        // switch the mode
        ModeSwitcherUtil.switchModes(parent);
    }

    /**
     * Sets the interface mode to provided
     *
     * @param interfaceMode interface mode
     */
    @Override
    public void setMode(InterfaceMode interfaceMode) {
        // switch the mode
        ModeSwitcherUtil.setMode(parent, interfaceMode);
    }
}
