/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2017 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package firebase.performance;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.util.TiConvert;

import java.util.Map;
import java.util.HashMap;

import android.app.Activity;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.metrics.HttpMetric;

@Kroll.module(name="TitaniumFirebasePerformance", id="firebase.performance")
public class TitaniumFirebasePerformanceModule extends KrollModule
{
	private static final String LCAT = "TitaniumFirebasePerformanceModule";
	private static final boolean DBG = TiConfig.LOGD;

  private Map<String, Trace> traces = new HashMap<String, Trace>();
  private Map<String, HttpMetric> metrics = new HashMap<String, HttpMetric>();

	public TitaniumFirebasePerformanceModule()
	{
		super();
	}

  @Override
  public void onDestroy(Activity activity)
  {
    this.traces.clear();
    this.traces = null;
    
    this.metrics.clear();
    this.metrics = null;
  }

  @Kroll.method
  public void startTrace(String identifier) {
    Trace trace = FirebasePerformance.getInstance().newTrace(identifier);
    trace.start();

    this.traces.put(identifier, trace);
  }

  @Kroll.method
  public void stopTrace(String identifier) {
    if (this.traces.get(identifier) == null) {
      Log.e(LCAT, String.format("Cannot find trace for identifier %s", identifier));
      return;
    }

    Trace trace = this.traces.get(identifier);
    trace.stop();
  }
  
  @Kroll.method
  public void startMetric(String url, String httpMethod) {
    HttpMetric metric = FirebasePerformance.getInstance().newHttpMetric(url, httpMethod);
    metric.start();

    this.metrics.put(url + httpMethod, metric);
  }
	
  @Kroll.method
  public void stopMetric(String url, String httpMethod) {
    if (this.metrics.get(url + httpMethod) == null) { 	
    Log.e(LCAT, String.format("Cannot find metric for url %s", url + httpMethod));
    return;
    }

    HttpMetric metric = this.metrics.get(url + httpMethod);
    metric.stop();
  }
	
  @Kroll.method
  public void setMetricRequestPayloadSize(String url, String httpMethod, long bytes) {
    if (this.metrics.get(url + httpMethod) == null) {	
    Log.e(LCAT, String.format("Cannot find metric for url %s", url + httpMethod));
    return;
    }

    HttpMetric metric = this.metrics.get(url + httpMethod);
    metric.setRequestPayloadSize(bytes);
  }

  @Kroll.method
  public void setMetricHttpResponseCode(String url, String httpMethod, int responseCode) {
    if (this.metrics.get(url + httpMethod) == null) {	
    Log.e(LCAT, String.format("Cannot find metric for url %s", url + httpMethod));
    return;
    }

    HttpMetric metric = this.metrics.get(url + httpMethod);
    metric.setHttpResponseCode(responseCode);
  }
	
  @Kroll.method
  public void setMetricResponseContentType(String url, String httpMethod, String contentType) {
    if (this.metrics.get(url + httpMethod) == null) {	
    Log.e(LCAT, String.format("Cannot find metric for url %s", url + httpMethod));
    return;
    }

    HttpMetric metric = this.metrics.get(url + httpMethod);
    metric.setResponseContentType(contentType);
  }
	
  @Kroll.method
  public void setMetricResponsePayloadSize(String url, String httpMethod, long bytes) {
    if (this.metrics.get(url + httpMethod) == null) {	
    Log.e(LCAT, String.format("Cannot find metric for url %s", url + httpMethod));
    return;
    }

    HttpMetric metric = this.metrics.get(url + httpMethod);
    metric.setResponsePayloadSize(bytes);
  }
	
  @Kroll.method
  public void setMetricAttribute(String url, String httpMethod, String attribute, String value) {
    if (this.metrics.get(url + httpMethod) == null) {	
    Log.e(LCAT, String.format("Cannot find metric for url %s", url + httpMethod));
    return;
    }

    HttpMetric metric = this.metrics.get(url + httpMethod);
    metric.putAttribute(attribute, value);
  }

  @Kroll.method
  public void incrementCounter(String identifier, String counterName, Object incrementedBy) {
    if (this.traces.get(identifier) == null) {
      Log.e(LCAT, String.format("Cannot find trace for identifier %s", identifier));
      return;
    }

    Trace trace = this.traces.get(identifier);
    
    trace.incrementMetric(counterName, (long) TiConvert.toInt(incrementedBy));
  }
}
