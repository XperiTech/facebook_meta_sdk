import FBSDKCoreKit
import Flutter
import UIKit

public class FacebookMetaSdkPlugin: NSObject, FlutterPlugin {

  /// Registers the plugin with the Flutter engine.
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(
      name: "facebook_meta_sdk", binaryMessenger: registrar.messenger())
    let instance = FacebookMetaSdkPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  /// Handles method calls from the Flutter side.
  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    switch call.method {
    case "initialize":
      // Initialize the Facebook SDK.
      ApplicationDelegate.shared.application(
        UIApplication.shared, didFinishLaunchingWithOptions: nil)
      result(true)

    //todo: In case we want to add any custom events etc
    // case "logSentFriendRequestEvent":
    //   // Log an event when a friend request is sent.
    //   AppEvents.shared.logEvent(AppEvents.Name("sentFriendRequest"))
    //   result(nil)

    default:
      result(FlutterMethodNotImplemented)
    }
  }
}
