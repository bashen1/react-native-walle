# react-native-walle

[![npm version](https://badge.fury.io/js/react-native-walle.svg)](https://badge.fury.io/js/react-native-walle)

美团多渠道打包插件 react-native sdk

SDK Version 1.1.7

## 开始

`$ npm install react-native-walle --save`

## 使用

```javascript
import RNReactNativeWalle from "react-native-walle";

let channel = await RNReactNativeWalle.getChannel();
let channelExtraInfo = await RNReactNativeWalle.getExtraInfo();
```
