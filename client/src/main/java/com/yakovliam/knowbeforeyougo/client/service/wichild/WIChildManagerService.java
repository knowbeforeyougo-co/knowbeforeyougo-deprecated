package com.yakovliam.knowbeforeyougo.client.service.wichild;

import com.yakovliam.knowbeforeyougo.client.io.mode.ModeSwitcherUtil;
import com.yakovliam.knowbeforeyougo.client.model.WirelessInterface;
import com.yakovliam.knowbeforeyougo.client.service.WIServiceChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class WIChildManagerService extends WIServiceChild {

    /**
     * Mode switcher util
     */
    @Autowired
    private final ModeSwitcherUtil modeSwitcherUtil;

    /**
     * WIServiceChild
     *
     * @param parent parent
     */
    public WIChildManagerService(WirelessInterface parent) {
        super(parent);
        this.modeSwitcherUtil = new ModeSwitcherUtil();
    }

    /**
     * Switches the mode of the wireless interface
     */
    @Override
    public void switchModes() {
        // switch the mode
        this.modeSwitcherUtil.switchModes(parent);
    }
}
