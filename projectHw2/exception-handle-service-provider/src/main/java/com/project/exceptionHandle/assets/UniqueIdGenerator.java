package com.project.exceptionHandle.assets;

import java.util.Random;

public class UniqueIdGenerator {

    private static final Random random = new Random();

    public static int generateUniqueID(){
        long timestamp = System.currentTimeMillis();

        int randomVaule = random.nextInt(100000);

        return Math.abs((int)(timestamp % Integer.MAX_VALUE) * 10000 + randomVaule);
    }
}
