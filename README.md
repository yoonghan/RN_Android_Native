# Plain code for React Native UI
This project is to show the integration between React Native with a custom native Android component.
[Reference](https://facebook.github.io/react-native/docs/native-components-android.html)

## Installation
1. Clone the project.
2. Cd to the folder and run the command

```
npm install
```

## Goals
Let's say there is a layout in pure android, e.g. a button. What should the steps be to integrate into existing React Native project.
This project assumes that the React Native project is already created. 
![alt text](gitimg/sample.png?raw=true)
*NOTE*: If you can master this, the React Module will be a walk in the park.

## Steps
These are the steps:
1. Open Android studio and point to android/ folder within this project. Allow gradle to run and fix those android error if exist.
2. Create the XML (or layout is build via code without XML ignore step 2) of the layout, Sample is in res/layout/multiplecamerastreamlayout.xml
3. Create a View to inflate the XML. Sample is in com.sample_android_ui.CustomView.
4. Create a View Manager that will link the Custom View, here is the place to expose the properties. Sample is in com.sample_android_ui.MyCustomReactViewManager.
5. Create a ReactPackage and add the react ViewManager into "createViewManagers" method. Sample in com.sample_android_uid.MyCustomPackage.
6. Add the Package into MainApplication to tie the ReactPackage to the loader. Sample in MainApplication.java
```java
   @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
              new MyCustomPackage()
      );
    }
```
7. Define in Javascript, a custom JS view. Sample JS created is CustomView.js
```javascript
  //File created is named CustomView.js
  import {requireNativeComponent, ViewPropTypes} from 'react-native';
  import PropTypes from 'prop-types';

  module.exports = requireNativeComponent('MyCustomReactViewManager', null);
  //If View Manager have react properties the code will be module.exports = requireNativeComponent('MyCustomReactViewManager', {name: 'AnynameWillDoItsforLog',propTypes: { 'ReactPropName':PropTypes.* }});
```
8. Use it in the main Javascript code and remember to set the height/width.
```javascript
  import CustomView from './CustomView.js';
  ...
    render() {
     return
      ...
      <CustomView style={{height:200, width:200}}/>
      ...;
    }
```

## Run it.
1. Once done, do the command.

```
react-native run-android.
```