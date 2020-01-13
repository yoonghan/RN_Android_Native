# Plain code for React Native UI
This project is to show the integration between React Native with a custom native Android component.
[Reference](https://facebook.github.io/react-native/docs/native-components-android.html)

## Base installation
1. Install node js of version 12.10.0[Reference](https://nodejs.org/en/download/releases/)
2. Install react native with command
```
npm install -g react-native@0.60.4
```

## Installation
1. Clone the project.
2. Cd to the folder and run the command

```
npm install
```
3. Install android studio.
4. Checkout React-Native Website getting started to configure Android studio.

```
# Make sure you create a file .bash_profile in $HOME for MacOS and restart the terminal.
export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/emulator
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/tools/bin
export PATH=$PATH:$ANDROID_HOME/platform-tools

#Windows
set ANDROID_SDK_ROOT=C:\Users\<User name>\AppData\Local\Android\Sdk
```

## Goals
Let's say there is a layout in pure android, e.g. a button. This is the walkthrough to get the module working in React Native project.
This project assumes that the React Native project is already created.

*NOTE*: If you can master this, the React Native Module will be a walk in the park.

![alt text](gitimg/sample.png?raw=true)


## Learn
These is how the bridge for the button is created.
1. Open Android studio and point to android/ folder within this project. Allow gradle to run and fix those android error if exist. If the code works, the green "Play"/"Debug" button is enabled in Android Studio. Else you will need to make time to fix this...this is the most difficult part for new Android coders.
2. Create the XML (or create a layout via android code) of the layout, Sample is in res/layout/multiplecamerastreamlayout.xml
3. Create a View to inflate the XML. Sample is in com.sample_android_ui.CustomView. *BONUS:* Added a click action.
4. Create a View Manager that will link the Custom View, here is the place to expose the properties. Sample is in com.sample_android_ui.MyCustomReactViewManager. *BONUS:* Added an optional @ReactProps for parameter passing.
5. Create a ReactPackage and add the react ViewManager into "createViewManagers" method. Sample in com.sample_android_uid.MyCustomPackage.
6. Add the Package into MainApplication to tie the ReactPackage to the loader. Sample in MainApplication.java
```java
  @Override
  protected List<ReactPackage> getPackages() {
    ...
    packages.add(new MyCustomPackage()); //Added here.
    return packages;
  }
```
7. Define in Javascript, a custom JS view. Sample JS created is CustomView.js
```javascript
  //File created is named CustomView.js
  import {requireNativeComponent, ViewPropTypes} from 'react-native';
  import PropTypes from 'prop-types';

  module.exports = requireNativeComponent('MyCustomReactViewManager', null);

  //BONUS: Updated to add module.exports = requireNativeComponent('MyCustomReactViewManager', {name: 'message',propTypes: { 'ReactPropName':PropTypes.String }});

  //If View Manager have react properties the code will be module.exports = requireNativeComponent('MyCustomReactViewManager', {name: 'AnynameWillDoItsforLog',propTypes: { 'ReactPropName':PropTypes.* }}); -- Check PropTypes.* is from ReactJS site.
```
8. Use it in the main Javascript code and remember to set the height/width.
```javascript
  import CustomView from './CustomView.js';
  ...
    render() {
     return
      ...
      <CustomView style={{height:200, width:200}}/>
      //BONUS: Updated to create <CustomView style={{height:200, width:200}} message={"Hi there"}/>
      ...;
    }
```
9. Added an event that receive onClick message, from native code. I.e. from Native code to React Native.
```javascript
  <CustomView
    ...
    onClick={this._clickEvent}
    />
```

## Run it.
1. Open android and start a device emulator.
2. Once done, do the command.

```
react-native run-android.
```

3. Click the button and see the toast box appearing.
4. If there are changes in android. You need to run 'react-native run-android' again.
5. If you opened it in Android Studio, there will be messages in LogCat. Filter it by "ANDROID_SAMPLE_UI" to get more info.
6. If compilation/deployment complains "missing debug.keystore" or "invalid keystore"; either generate a new keystore, or use the ready created *debug.keystore*. The generated keystore has the password or *secret*, keyalias of *debug*; this is under Build->Generate Signed Bundle/Apk. Set deploy build variant as debug.


## Issues
1. If you encountered the error **error Invalid regular expression: /(.\fixtures\.|node_modules[\]react[\]dist[\].|** when starting android, downgrade nodejs to 12.10.0
2. If you "react-native start" command keeps failing. Downgrade react-native to 0.60.4. The command is
```
  npm uninstall -g react-native
  npm install -g react-native@0.60.4
```

3. When the application starts as blank. Do these steps.

 a. Close the app sample_reactnative in android.
 b. Open the app again.
 c. Press R and R again.
  d. Wait few seconds (10 seconds)
