import React, { useState } from "react";
import {
  BackHandler,
  NativeModules,
  Text,
  TextInput,
  TouchableOpacity,
  View,
} from "react-native";
// styles
import { styles } from "./styles";

export const MainScreen = () => {
  const [, setIsHeroPresented] = useState(false);

  const onPressOpenHero = () => {
    setIsHeroPresented(true);
    NativeModules.HeroService.showModal();
  };

  return (
    <View style={styles.container}>
      <TouchableOpacity style={styles.button} onPress={onPressOpenHero}>
        <Text style={styles.buttonText}>1. Tap to Open Popup Fragment</Text>
      </TouchableOpacity>
      <TextInput style={styles.input} placeholder={"2. Tap to show keyboard"} />
    </View>
  );
};

export default MainScreen;
