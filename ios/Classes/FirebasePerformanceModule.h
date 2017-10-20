/**
 * titanium-firebase-performance
 *
 * Created by Hans Knoechel
 * Copyright (c) 2017 Axway Appcelerator. All rights reserved.
 */

#import "TiModule.h"

@class FIRTrace;

@interface FirebasePerformanceModule : TiModule {
  NSMutableDictionary<NSString *, FIRTrace *> *_traces;
}

#pragma mark Public APIs

- (void)startTrace:(id)name;

- (void)incrementCounter:(id)arguments;

- (void)stopTrace:(id)name;

- (void)setDataCollectionEnabled:(NSNumber *)dataCollectionEnabled;

- (NSNumber *)dataCollectionEnabled;

- (NSArray<NSString *> *)allTraces;

@end
