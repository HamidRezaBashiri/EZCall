package com.ezcall.data.dataSource.webRTC.audio

import com.ezcall.data.dataSource.webRTC.audio.AudioDevice

typealias AudioDeviceChangeListener = (
  audioDevices: List<AudioDevice>,
  selectedAudioDevice: AudioDevice?
) -> Unit
