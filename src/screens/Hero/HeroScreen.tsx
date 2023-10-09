import React from "react";
import { NativeModules, Text, TouchableOpacity, View } from "react-native";
// styles
import { styles } from "./styles";

export const HeroScreen = () => {
  const onPressCloseHero = () => {
    NativeModules.HeroService.closeModal();
  };

  return (
    <View style={styles.container}>
      <Text style={styles.fragmentText}>Some content</Text>
    </View>
  );
};

export default HeroScreen;
