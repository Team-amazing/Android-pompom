package com.example.outopompomme.bluetooth;

import com.example.outopompomme.LinkarduinoActivity;
import com.example.outopompomme.bluetooth.BluetoothDataListener;

public class BluetoothDataReceiver extends Thread{
    private LinkarduinoActivity linkarduinoActivity;
    private BluetoothDataListener bluetoothDataListener;

    private boolean isListening = false;

    public BluetoothDataReceiver(LinkarduinoActivity activity) {
        linkarduinoActivity = activity;
    }

    public void setBluetoothDataListener(BluetoothDataListener listener) {
        this.bluetoothDataListener = listener;
    }

    public void stopListening() {
        isListening = false;
    }

    @Override
    public void run() {
        // Bluetooth 데이터 수신 로직 작성
        // 수신한 데이터를 파싱하고, bluetoothDataListener를 통해 전달
    }
}
