/**
 * Created by ankit.anand on 28/06/17.
 */
interface Cache<T,K,V> {
    public T get(K Key);
    public void put(K Key,V Value);
}