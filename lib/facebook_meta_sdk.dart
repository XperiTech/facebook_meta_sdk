import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class FacebookMetaSdk {
  static const MethodChannel _channel = MethodChannel('facebook_meta_sdk');

  /// Initializes the Facebook(Meta) SDK.
  /// Returns true if initialization was successful, otherwise false.
  static Future<bool> initialize() async {
    try {
      return await _channel.invokeMethod('initialize');
    } on PlatformException catch (e) {
      debugPrint('Error initializing FacebookMetaSdk: ${e.message}');
      return false;
    }
  }
}
