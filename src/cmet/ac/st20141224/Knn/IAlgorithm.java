package cmet.ac.st20141224.Knn;

/**
 * Interface for the recursive algorithm.
 */
public interface IAlgorithm<R, T> { // generics interface
    R distance(T val, T min, T max);
}