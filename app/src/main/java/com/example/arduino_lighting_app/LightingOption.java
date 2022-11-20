package com.example.arduino_lighting_app;

import java.util.ArrayList;

public class LightingOption {
    String option;
    ArrayList<Integer> pins;
    int state; //used for switch on/off and mode toggle. switch on/off uses 0 for off and 1 for on
    int[] rgba = new int[4]; //used for rgb and rgba

}
