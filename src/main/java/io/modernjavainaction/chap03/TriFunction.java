package io.modernjavainaction.chap03;

@FunctionalInterface
public interface TriFunction<T,U,V,R> {
    R apple(T t, U u, V v);
}
