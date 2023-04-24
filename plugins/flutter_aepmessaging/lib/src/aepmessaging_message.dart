/// Copyright 2023 Adobe. All rights reserved.
/// This file is licensed to you under the Apache License, Version 2.0 (the "License");
/// you may not use this file except in compliance with the License. You may obtain a copy
/// of the License at http://www.apache.org/licenses/LICENSE-2.0
/// Unless required by applicable law or agreed to in writing, software distributed under
/// the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
/// OF ANY KIND, either express or implied. See the License for the specific language
/// governing permissions and limitations under the License.

import 'package:flutter/services.dart';
import 'package:flutter_aepcore/flutter_aepcore.dart';
import 'package:flutter_aepmessaging/flutter_aepmessaging.dart';

/// Represents a message object retrieved from Adobe Experience Platform
class Message extends Showable {
  static const MethodChannel _channel =
      const MethodChannel('flutter_aepmessaging');

  late String id;
  late bool autoTrack;

  Message(
    final String id,
    final bool autoTrack,
  ) {
    this.id = id;
    this.autoTrack = autoTrack;
  }

  /// Clears the message from the cached messages
  void clear() {
    _channel.invokeMethod('clear', {id: this.id});
  }

  /// Signals to the UIServices that the message should be dismissed.
  /// If [autoTrack] is true, calling this method will result in an "inapp.dismiss" Edge Event being dispatched.
  /// If [suppressAutoTrack] set to true, the inapp.dismiss Edge Event will not be sent regardless of the autoTrack setting.
  void dismiss({bool? suppressAutoTrack: false}) {
    _channel.invokeMethod(
        'dismiss', {id: this.id, suppressAutoTrack: suppressAutoTrack});
  }

  /// Adds a handler for Javascript messages sent from the message's webview specified for [name].
  /// The parameter passed to `handler` will contain the body of the message passed from the webview's Javascript.
  Future<String> handleJavascriptMessage(String name) async {
    return await _channel
        .invokeMethod('handleJavascriptMessage', {id: this.id, name: name});
  }

  /// Sets the value of autoTrack on the message to [shouldAutoTrack]
  ///
  /// Note: This function works only for the Message objects that were saved by calling "MessagingDelegate.shouldSaveMessage"
  void setAutoTrack(bool shouldAutoTrack) {
    this.autoTrack = shouldAutoTrack;
    _channel.invokeMethod(
        'setAutoTrack', {id: this.id, autoTrack: shouldAutoTrack});
  }

  /// Signals to the UIServices that the message should be shown.
  ///
  /// If autoTrack is true, calling this method will result in an "inapp.display" Edge Event being dispatched.
  @override
  void show() {
    _channel.invokeMethod('show', {id: this.id});
  }

  /// Generates an Edge Event for the provided [interaction] and [eventType].
  void track(String? interaction, MessagingEdgeEventType eventType) {
    _channel.invokeMethod(
        'track', {id: this.id, eventType: eventType, interaction: interaction});
  }
}
