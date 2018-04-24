# Firebase Performance - Titanium Module
Use the native Firebase SDK in Axway Titanium. This repository is part of the [Titanium Firebase](https://github.com/hansemannn/titanium-firebase) project.

## Requirements
- [x] The [Firebase Core](https://github.com/hansemannn/titanium-firebase-core) module
- [x] iOS: Titanium SDK 6.3.0+
- [x] Android: Titanium SDK 7.0.0+

## Download
- [x] [Stable release](https://github.com/hansemannn/titanium-firebase-performance/releases)
- [x] [![gitTio](http://hans-knoechel.de/shields/shield-gittio.svg)](http://gitt.io/component/firebase.performance)

## API's

### `FirebasePerformance`

#### Methods

##### `startTrace(name)`
  - `name` (String)

##### `incrementCounter(message, counter, increment)`
  - `name` (String)
  - `counter` (String)
  - `increment` (Number, optional)

##### `stopTrace(name)`
  - `name` (String)
  
#### Properties

##### `dataCollectionEnabled` (Boolean, get/set, iOS-only)

#### `allTraces` ([String], iOS-only)

## Example
```js
// Require the Firebase Performance module
var FirebasePerformance = require('firebase.performance');

// Start the named trace
FirebasePerformance.startTrace('trace_name');

// Increment the counter value
FirebasePerformance.incrementCounter('trace_name', 'counter_name', 1); // Trace name, counter name, increment (optional)

// Stop the named trace
FirebasePerformance.stopTrace('trace_name');

/// -- iOS-only, remove for Android for now --

// Manually disable data collection (enabled by default)
FirebasePerformance.dataCollectionEnabled = false;

// Returns all trace-names
Ti.API.log(FirebasePerformance.allTraces);
```

## Build

### iOS
```js
cd ios
appc ti build -p ios --build-only
```

### Android
```js
cd android
appc ti build -p android --build-only
```

## Legal

This module is Copyright (c) 2017-present by Hans Knöchel. All Rights Reserved.
Usage of this module is subject to the Terms of Service agreement with Appcelerator, Inc.  
