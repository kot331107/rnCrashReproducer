import React, { useEffect, useState } from "react";
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
  const [isHeroPresented, setIsHeroPresented] = useState(false);

  useEffect(() => {
    BackHandler.addEventListener("hardwareBackPress", handleBackPressed);
    return () => {
      BackHandler.removeEventListener("hardwareBackPress", handleBackPressed);
    };
  });

  const handleBackPressed = (): boolean | null | undefined => {
    if (isHeroPresented) {
      NativeModules.HeroService.closeModal();
      setIsHeroPresented(false);
      return true;
    }
    return false;
  };

  const onPressOpenHero = () => {
    setIsHeroPresented(true);
    NativeModules.HeroService.showModal();
  };

  return (
    <View style={styles.container}>
      <TextInput style={styles.input} placeholder={"Tap to show keyboard"} />
      <TouchableOpacity style={styles.button} onPress={onPressOpenHero}>
        <Text style={styles.buttonText}>Open Modal</Text>
      </TouchableOpacity>
    </View>
  );
};

export default MainScreen;
