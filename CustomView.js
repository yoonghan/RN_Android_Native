import {requireNativeComponent, ViewPropTypes} from 'react-native';
import PropTypes from 'prop-types';

module.exports = requireNativeComponent('MyCustomReactViewManager', {name: 'message',propTypes: { 'ReactPropName':PropTypes.String }});
