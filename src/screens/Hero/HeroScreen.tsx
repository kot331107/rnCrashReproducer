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
      {/* <TouchableOpacity style={styles.button} onPress={onPressCloseHero}>
        <Text style={styles.buttonText}>Close Modal</Text>
      </TouchableOpacity> */}
    </View>
  );
};

export default HeroScreen;
