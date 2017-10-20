# Firebase Performance - Titanium Module
Use the native Firebase SDK in Axway Titanium. This repository is part of the [Titanium Firebase](https://github.com/hansemannn/titanium-firebase) project.

## Requirements
- [x] Titanium SDK 6.2.0 or later

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

##### `dataCollectionEnabled` (Boolean, get/set)

#### `allTraces` ([String])

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

// Manually disable data collection (enabled by default)
FirebasePerformance.dataCollectionEnabled = false;

// Returns all trace-names
Ti.API.log(FirebasePerformance.allTraces);
```

## Build
```js
cd ios
appc ti build -p ios --build-only
```

## Legal

This module is Copyright (c) 2017-Present by Appcelerator, Inc. All Rights Reserved. 
Usage of this module is subject to the Terms of Service agreement with Appcelerator, Inc.  
