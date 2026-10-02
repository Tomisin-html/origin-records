package com.originrecords.app;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onStart() {
        super.onStart();
        // The app's layout is hand-tuned at a fixed text scale. Android's WebView otherwise
        // multiplies every CSS font-size by the phone's system "font size" accessibility
        // setting, which grows text without growing the surrounding padding/line-height,
        // causing cramped, overlapping text on phones set to a larger font size. Locking
        // textZoom to 100 keeps the app's own design consistent across all devices.
        if (this.bridge != null && this.bridge.getWebView() != null) {
            this.bridge.getWebView().getSettings().setTextZoom(100);
        }
    }
}
