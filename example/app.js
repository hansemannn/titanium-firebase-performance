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
