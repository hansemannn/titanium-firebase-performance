// Require the Firebase Performance module
var FirebasePerformance = require('firebase.performance');

// Start the named trace
FirebasePerformance.start('trace_name');

// Increment the counter value
FirebasePerformance.incrementCounter('trace_name', 'counter_name', 1); // Trace name, counter name, increment (optional)

// Stop the named trace
FirebasePerformance.stop('trace_name');
