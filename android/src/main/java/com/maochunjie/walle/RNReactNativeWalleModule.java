package com.maochunjie.walle;

import android.content.Context;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.meituan.android.walle.ChannelInfo;
import com.meituan.android.walle.WalleChannelReader;

import java.util.Map;

public class RNReactNativeWalleModule extends ReactContextBaseJavaModule {
    private static String TAG = "RNReactNativeWalleModule";
    private static ReactApplicationContext reactContext = null;

    public RNReactNativeWalleModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNReactNativeWalle";
    }

    /**
     * 获取渠道信息，返回 null 或者 Map
     *
     * @param promise
     */
    @ReactMethod
    public void getChannel(Promise promise) {
        String channel = WalleChannelReader.getChannel(reactContext);
        promise.resolve(channel);
    }

    /**
     * 获取额外信息，返回 null 或者 Map
     *
     * @param promise
     */
    @ReactMethod
    public void getExtraInfo(Promise promise) {
        ChannelInfo channelInfo = WalleChannelReader.getChannelInfo(reactContext);
        if (channelInfo != null) {
            Map extraInfo = channelInfo.getExtraInfo();
            WritableMap writableMap = Arguments.makeNativeMap(extraInfo);
            promise.resolve(writableMap);
            return;
        }
        promise.resolve(null);
    }

    /**
     * Native 使用，返回 null 或者 String
     *
     * @param context
     * @return
     */
    public static String getWalleChannel(Context context) {
        return WalleChannelReader.getChannel(context);
    }
}
