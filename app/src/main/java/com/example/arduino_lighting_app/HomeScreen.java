package com.example.arduino_lighting_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

//TODO check copyrights for arduino image http://www.sketchappsources.com/free-source/2077-arduino-uno-board-vector-sketch-freebie-resource.html


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.View;


import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.OutputStream;

public class HomeScreen extends AppCompatActivity {
    private BluetoothManager bluetoothManager;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothDevice device;
    private BluetoothSocket socket;
    private OutputStream outstream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ListView lighting_options = findViewById(R.id.lighting_options_list);
        ArrayAdapter<String> lighting_options_values = new ArrayAdapter<>(this, R.layout.right_aligned_entry, getResources().getStringArray(R.array.lighting_options));
        lighting_options.setAdapter(lighting_options_values);
        lighting_options.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        lighting_options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                for(int a = 0; a < lighting_options.getChildCount(); a++)
                {
                    //todo make a new LightingOption
                    lighting_options.getChildAt(a);
                }
                lighting_options.setVisibility(View.INVISIBLE);
                Intent addlightingoption = new Intent(HomeScreen.this,AddLightingOption.class);
                startActivity(addlightingoption);
            }
        });

        ListView pin_details = findViewById(R.id.pin_details_list);
        ArrayAdapter<String> pin_detail_values = new ArrayAdapter<>(this, R.layout.right_aligned_entry, new String[]{"one", "two", "three"});
        pin_details.setAdapter(pin_detail_values);


        FloatingActionButton view_lighting_options = findViewById(R.id.select_lighting_option_button);
        view_lighting_options.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (lighting_options.getVisibility() == View.VISIBLE) {
                            lighting_options.setVisibility(View.INVISIBLE);
                        } else {
                            lighting_options.setVisibility(View.VISIBLE);
                        }
                    }
                });

        ImageView bluetooth_icon = findViewById(R.id.bluetooth_icon);
        bluetooth_icon.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
    }

    @SuppressLint("MissingPermission")
    private boolean checkBluetoothPermissions() {//handles the manager, adapter, device and socket
            bluetoothManager = this.getSystemService(BluetoothManager.class);
            bluetoothAdapter = bluetoothManager.getAdapter();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) ==
                PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            // You can directly ask for the permission.
            // The registered ActivityResultCallback gets the result of this request.
            String[] permissions = {Manifest.permission.BLUETOOTH_CONNECT};
            int code = 0;
            this.requestPermissions(permissions, code);
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) ==
                    PackageManager.PERMISSION_GRANTED) {
                return true;
            }
        }
        return false;

    }
}