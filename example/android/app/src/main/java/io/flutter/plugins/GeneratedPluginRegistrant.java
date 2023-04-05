package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import io.flutter.Log;

import io.flutter.embedding.engine.FlutterEngine;

/**
 * Generated file. Do not edit.
 * This file is generated by the Flutter tool based on the
 * plugins that support the Android platform.
 */
@Keep
public final class GeneratedPluginRegistrant {
  private static final String TAG = "GeneratedPluginRegistrant";
  public static void registerWith(@NonNull FlutterEngine flutterEngine) {
    try {
      flutterEngine.getPlugins().add(new com.adobe.marketing.mobile.flutter.flutter_aepassurance.FlutterAEPAssurancePlugin());
    } catch(Exception e) {
      Log.e(TAG, "Error registering plugin flutter_aepassurance, com.adobe.marketing.mobile.flutter.flutter_aepassurance.FlutterAEPAssurancePlugin", e);
    }
    try {
      flutterEngine.getPlugins().add(new com.adobe.marketing.mobile.flutter.flutter_aepcore.FlutterAEPCorePlugin());
    } catch(Exception e) {
      Log.e(TAG, "Error registering plugin flutter_aepcore, com.adobe.marketing.mobile.flutter.flutter_aepcore.FlutterAEPCorePlugin", e);
    }
    try {
      flutterEngine.getPlugins().add(new com.adobe.marketing.mobile.flutter.flutter_aepedge.FlutterAEPEdgePlugin());
    } catch(Exception e) {
      Log.e(TAG, "Error registering plugin flutter_aepedge, com.adobe.marketing.mobile.flutter.flutter_aepedge.FlutterAEPEdgePlugin", e);
    }
    try {
      flutterEngine.getPlugins().add(new com.adobe.marketing.mobile.flutter.flutter_aepedgebridge.FlutterAEPEdgeBridgePlugin());
    } catch(Exception e) {
      Log.e(TAG, "Error registering plugin flutter_aepedgebridge, com.adobe.marketing.mobile.flutter.flutter_aepedgebridge.FlutterAEPEdgeBridgePlugin", e);
    }
    try {
      flutterEngine.getPlugins().add(new com.adobe.marketing.mobile.flutter.flutter_aepedgeconsent.FlutterAEPEdgeConsentPlugin());
    } catch(Exception e) {
      Log.e(TAG, "Error registering plugin flutter_aepedgeconsent, com.adobe.marketing.mobile.flutter.flutter_aepedgeconsent.FlutterAEPEdgeConsentPlugin", e);
    }
    try {
      flutterEngine.getPlugins().add(new com.adobe.marketing.mobile.flutter.flutter_aepedgeidentity.FlutterAEPEdgeIdentityPlugin());
    } catch(Exception e) {
      Log.e(TAG, "Error registering plugin flutter_aepedgeidentity, com.adobe.marketing.mobile.flutter.flutter_aepedgeidentity.FlutterAEPEdgeIdentityPlugin", e);
    }
    try {
      flutterEngine.getPlugins().add(new com.adobe.marketing.mobile.flutter.flutter_aepuserprofile.FlutterAEPUserProfilePlugin());
    } catch(Exception e) {
      Log.e(TAG, "Error registering plugin flutter_aepuserprofile, com.adobe.marketing.mobile.flutter.flutter_aepuserprofile.FlutterAEPUserProfilePlugin", e);
    }
  }
}
