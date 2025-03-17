package com.example.facebook_meta_sdk

import android.content.Context
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** FacebookMetaSdkPlugin */
class FacebookMetaSdkPlugin : FlutterPlugin, MethodChannel.MethodCallHandler {

  private lateinit var channel: MethodChannel
  private lateinit var context: Context
  private var logger: AppEventsLogger? = null

  override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    context = binding.applicationContext
    channel = MethodChannel(binding.binaryMessenger, "facebook_meta_sdk")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
    when (call.method) {
      "initialize" -> {
        try {
          // Initialize Facebook SDK and create a logger instance
          FacebookSdk.sdkInitialize(context)
          logger = AppEventsLogger.newLogger(context)
          result.success(true)
        } catch (e: Exception) {
          // Log the error if needed
          result.success(false)
        }
      }
      // todo: In case we want to add any custom events etc
      // "logSentFriendRequestEvent" -> {
      //   if (logger == null) {
      //     result.error("SDK_NOT_INITIALIZED", "Call initialize() first", null)
      //   } else {
      //     logger?.logEvent("sentFriendRequest")
      //     result.success(null)
      //   }
      // }
      else -> result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}
