import React, {useEffect, useMemo, useCallback, useState} from 'react';
import {StyleSheet, View, Text} from 'react-native';
import RNReactNativeWalle from 'react-native-walle';

const App = () => {
  const [channel, setChannel] = useState<string | undefined>();
  const [extraInfo, setExtraInfo] = useState<any>();

  const handleInfo = useCallback(async () => {
    setChannel(await RNReactNativeWalle.getChannel());
    setExtraInfo(await RNReactNativeWalle.getExtraInfo())
  }, []);

  useEffect(() => {
    handleInfo();
  }, [handleInfo]);

  return useMemo(() => (
    <View style={styles.container}>
      <Text>channel: {channel ?? ''}</Text>
      <Text>extraInfo: {JSON.stringify(extraInfo ?? {})}</Text>
    </View>
  ), [channel, extraInfo]);
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});

export default App;