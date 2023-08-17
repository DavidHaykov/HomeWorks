package telran.cars.model;

import telran.cars.dto.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RentCompanyLocks{
    static final ReadWriteLock carsLock = new ReentrantReadWriteLock();
    static final ReadWriteLock driversLock = new ReentrantReadWriteLock();
    static final ReadWriteLock modelsLock = new ReentrantReadWriteLock();
    static final ReadWriteLock recordLock = new ReentrantReadWriteLock();

    static final int CARS_INDEX = 0;
    static final int DRIVERS_INDEX = 1;
    static final int MODELS_INDEX = 2;
    static final int RECORDS_INDEX = 3;

    static final int WRITE_INDEX = 0;
    static final int READ_INDEX = 1;

    static Lock[][] locks;
    static {
        locks = new Lock[2][4];
        ReadWriteLock[] rwl = {carsLock, driversLock, modelsLock, recordLock};
        for(int i = 0; i < rwl.length; i++){
            locks[WRITE_INDEX][i] = rwl[i].writeLock();
            locks[READ_INDEX][i] = rwl[i].readLock();

        }
    }
    private static void lockUnlock(boolean flag, int typeLock, int ...indexes){
        if(flag){
            lock(typeLock, indexes);
        }else {
            unlock(typeLock, indexes);
        }
    }

    private static void unlock(int typeLock, int[] indexes) {
        Arrays.sort(Arrays.stream(indexes).boxed().toArray(Integer[]::new), (i1, i2) -> i2 - i1);
        for(int index : indexes){
            locks[typeLock][index].unlock();
        }
    }

    private static void lock(int typeLock, int[] indexes) {
        Arrays.sort(indexes);
        for(int index : indexes){
            locks[typeLock][index].lock();
        }
    }



    public static void lockUnlock_addCar(boolean flag) {
        lockUnlock(flag, WRITE_INDEX, CARS_INDEX);
        lockUnlock(flag, READ_INDEX, MODELS_INDEX);
    }
    public static void lockUnlock_save(boolean flag){
        lockUnlock(flag, READ_INDEX, 0, 1, 2, 3);
    }

    public static void lockUnlock_addDriver(boolean flag) {
        lockUnlock(flag, WRITE_INDEX, DRIVERS_INDEX);
    }


    public static void lockUnlock_addModel(boolean flag) {
        lockUnlock(flag, WRITE_INDEX, MODELS_INDEX);
    }


    public static void lockUnlock_getCar(boolean flag) {
        lockUnlock(flag, READ_INDEX, CARS_INDEX);
    }


    public static void lockUnlock_getModel(boolean flag) {
        lockUnlock(flag, READ_INDEX, MODELS_INDEX);
    }


    public static void lockUnlock_getDriver(boolean flag) {
        lockUnlock(flag, READ_INDEX, DRIVERS_INDEX);
    }


    public static void lockUnlock_rentCar(boolean flag) {
        lockUnlock(flag, READ_INDEX, DRIVERS_INDEX);
        lockUnlock(flag, WRITE_INDEX, CARS_INDEX, RECORDS_INDEX);
    }


    public static void lockUnlock_getCarsByDriver(boolean flag) {
        lockUnlock(flag, READ_INDEX, DRIVERS_INDEX, RECORDS_INDEX);
    }


    public static void lockUnlock_getDriversByCar(boolean flag) {
        lockUnlock(flag, READ_INDEX, CARS_INDEX, RECORDS_INDEX);
    }


    public static void lockUnlock_getCarsByModel(boolean flag) {
        lockUnlock(flag, READ_INDEX, CARS_INDEX, MODELS_INDEX);
    }


    public static void lockUnlock_getRentRecordsAtDate(boolean flag) {
        lockUnlock(flag, READ_INDEX, RECORDS_INDEX);
    }


    public static void lockUnlock_removeCar(boolean flag) {
        lockUnlock(flag, WRITE_INDEX, CARS_INDEX, MODELS_INDEX, RECORDS_INDEX);
    }



    public static void lockUnlock_returnCar(boolean flag) {
        lockUnlock(flag, READ_INDEX, DRIVERS_INDEX, CARS_INDEX, RECORDS_INDEX);
        lockUnlock(flag,WRITE_INDEX, CARS_INDEX,RECORDS_INDEX, MODELS_INDEX );
    }


    public static void lockUnlock_getMostPopularCarModels(boolean flag) {
        lockUnlock(flag, READ_INDEX, CARS_INDEX, MODELS_INDEX, RECORDS_INDEX, DRIVERS_INDEX);

    }


    public static void lockUnlock_getMostProfitableCarModels(boolean flag) {
        lockUnlock(flag, READ_INDEX, MODELS_INDEX, RECORDS_INDEX);
    }


    public static void lockUnlock_getMostActiveDrivers(boolean flag) {
        lockUnlock(flag, READ_INDEX, RECORDS_INDEX, DRIVERS_INDEX);

    }


    public static void lockUnlock_getModelNames(boolean flag) {
        lockUnlock(flag, READ_INDEX, MODELS_INDEX);
    }
}
