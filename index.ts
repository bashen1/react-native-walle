import {NativeModules} from 'react-native';

type WalleChannelType = {
  getChannel(): Promise<string>;
  getExtraInfo(): Promise<{
    [key: string]: string;
  }>;
};

const {RNReactNativeWalle} = NativeModules;

export default RNReactNativeWalle as WalleChannelType;