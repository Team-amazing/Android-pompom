package com.example.outopompomme.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;

import com.example.outopompomme.LinkarduinoActivity;

import java.io.InputStream;

public class MyBluetoothManager {
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothDevice bluetoothDevice;
    private BluetoothSocket bluetoothSocket;
    private InputStream inputStream;
    private boolean isConnected = false;

    private BluetoothDataReceiver dataReceiver;

    public MyBluetoothManager(Context context){
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        dataReceiver = new BluetoothDataReceiver((LinkarduinoActivity) context);
        dataReceiver.setBluetoothDataListener((BluetoothDataListener) context);
    }

    public void connectToDevice(){
        // Bluetooth 디바이스 연결 로직 작성
        // 필요한 경우 디바이스 검색, 페어링 등의 작업을 수행
    }

    public void startDataListening() {
        // 데이터 수신을 시작하는 로직 작성
        // BluetoothSocket을 통해 데이터를 수신하고 BluetoothDataReceiver로 전달
    }

    public void disconnect() {
        // Bluetooth 연결 종료 로직 작성
        // 필요한 경우 BluetoothSocket, InputStream 등을 닫음
    }
}
