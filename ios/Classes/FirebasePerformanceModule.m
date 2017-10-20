/**
 * titanium-firebase-performance
 *
 * Created by Hans Knoechel
 * Copyright (c) 2017 Axway Appcelerator. All rights reserved.
 */

#import "FirebasePerformanceModule.h"
#import "TiBase.h"
#import "TiHost.h"

#import <FirebasePerformance/FirebasePerformance.h>

@implementation FirebasePerformanceModule

#pragma mark Internal

- (id)moduleGUID
{
  return @"0f3ea40e-0a87-4ded-8402-44770ed6a41e";
}

- (NSString *)moduleId
{
  return @"firebase.performance";
}

#pragma mark Lifecycle

- (void)startup
{
  [super startup];
  NSLog(@"[DEBUG] %@ loaded", self);
}

- (NSMutableDictionary<NSString *, FIRTrace *> *)traces
{
  if (_traces == nil) {
    _traces = [[NSMutableDictionary alloc] init];
  }

  return _traces;
}

#pragma Public APIs

- (void)startTrace:(id)name
{
  ENSURE_SINGLE_ARG(name, NSString);
  FIRTrace *trace = [FIRPerformance startTraceWithName:name];
  [[self traces] setObject:trace forKey:name];
}

- (void)incrementCounter:(id)arguments
{
  NSString *traceName = [arguments objectAtIndex:0];
  NSString *counterName = [arguments objectAtIndex:1];

  if ([[self traces] objectForKey:traceName] == nil) {
    NSLog(@"[ERROR] Trying to increment the trace %@ which does not exist!", traceName);
    return;
  }

  FIRTrace *trace = [[self traces] objectForKey:traceName];

  if ([arguments count] == 3) {
    NSNumber *count = [arguments objectAtIndex:2];
    [trace incrementCounterNamed:counterName by:count.integerValue];
    return;
  }

  [trace incrementCounterNamed:counterName];
}

- (void)stopTrace:(id)name
{
  ENSURE_SINGLE_ARG(name, NSString);

  if ([[self traces] objectForKey:name] == nil) {
    [self throwException:[[NSString alloc] initWithFormat:@"Trying to increment the trace \"%@\" which does not exist.", name]
               subreason:@"Start a new trace with \"startTrace('trace_name')\" before"
                location:CODELOCATION];
    return;
  }

  FIRTrace *trace = [[self traces] objectForKey:name];
  [trace stop];
}

- (NSArray<NSString *> *)allTraces
{
  return [[self traces] allKeys];
}

- (void)setDataCollectionEnabled:(NSNumber *)dataCollectionEnabled
{
  ENSURE_TYPE(dataCollectionEnabled, NSNumber);
  [[FIRPerformance sharedInstance] setDataCollectionEnabled:[dataCollectionEnabled boolValue]];
}

- (NSNumber *)dataCollectionEnabled
{
  return @([[FIRPerformance sharedInstance] isDataCollectionEnabled]);
}

@end
