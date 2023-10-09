import React from "react";
import { AppRegistry, SafeAreaView } from "react-native";
import HeroScreen from "./src/screens/Hero/HeroScreen";
import MainScreen from "./src/screens/Main/MainScreen";

const App = () => {
  // See `OverlayFragment::dockScreenView` for the component name usage
  AppRegistry.registerComponent("Hero.HeroScreen", () => HeroScreen);

  return <MainScreen />;
};

export default App;
