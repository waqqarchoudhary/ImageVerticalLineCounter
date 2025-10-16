package com.tmmc.assignment.service;

public class LineCounterService {

    //don't cache locally, always read from main memory
    private static volatile LineCounterService instance;
    private static final int BLACK_THRESHOLD = 50;

    private LineCounterService(){}

    public static LineCounterService getInstance(){
        if (instance == null) {
            synchronized (LineCounterService.class) {
                if(instance == null) {
                    instance = new LineCounterService();
                }
            }
        }
        return instance;
    }


}
