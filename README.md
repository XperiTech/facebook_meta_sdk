# facebook_meta_sdk

A Flutter plugin to integrate Facebook AppEventsLogger for logging events.

> **Note:** This assumes the plugin is already installed in your project, including proper configuration of Info.plist (iOS) and AndroidManifest.xml (Android) as required by Facebook's SDK.

## Usage

### Import the Package

In your Dart code, import the plugin:

```dart
import 'package:facebook_meta_sdk/facebook_meta_sdk.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();

  try {
    // Initialize the Facebook (Meta) SDK
    final bool isMetaSDKInitialized = await FacebookMetaSdk.initialize();
    if (isMetaSDKInitialized) {
      debugPrint('Meta SDK initialized successfully');
    } else {
      debugPrint('Meta SDK initialization failed');
    }
  } catch (error) {
    log('Error init FacebookSDK: $error');
  }

  runApp(const App());
}
```