package cmet.ac.st20141224.Knn;

public interface IAlgorithm<R, T> { // generics interface
    R normalize(T val, T min, T max);
}