package com.yakovliam.knowbeforeyougo.client.service.wichild;

import com.yakovliam.knowbeforeyougo.client.io.mode.ModeSwitcherUtil;
import com.yakovliam.knowbeforeyougo.client.model.WirelessInterface;
import com.yakovliam.knowbeforeyougo.client.service.WIServiceChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable(preConstruction = true)
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
}
