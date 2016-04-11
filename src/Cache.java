import java.util.HashMap;
import java.util.LinkedList;

/**
 * Basic implementation of a cache. It maintains a Linked List of the 
 * keys in a hashmap so that accesses can be ordered. All variables 
 * are package and subclass scoped. 
 * @author ChrisOttino
 *
 */
public abstract class Cache<K,V> implements GenericCache <K,V> {
	protected int cacheSize; 
	protected HashMap<K,Cacheable<K,V>> cacheMap;
	protected LinkedList<K> keyList; 
	
	public Cache(int cacheSize){
		this.cacheSize = cacheSize; 
		cacheMap = new HashMap<K, Cacheable<K,V>>(cacheSize); 
		keyList = new LinkedList<K>();
	}
	
	@Override
	public abstract void put(Cacheable<K,V> obj); 

	@Override
	public abstract Cacheable<K,V> get(K id); 

	@Override
	public synchronized void cacheRemove(K id) {
		keyList.remove(id); 
		cacheMap.remove(id); 
	}
	
	/**
	 * Removes the element key from the end of the LinkedList and 
	 * then proceeds to remove this element from the Map. 
	 */
	public synchronized void trimEnd(){
		K id =  keyList.removeLast(); 
		cacheMap.remove(id);
	}
	
	/**
	 * Removes the element key from the beginning of the LinkedList and 
	 * then proceeds to remove this element from the Map
	 */
	public synchronized void trimHead(){
		K id = keyList.removeFirst(); 
		cacheMap.remove(id);
	}
	
	/**
	 * Removes the element key from the specified index of the LinkedList and 
	 * then proceeds to remove this element from the Map
	 * @param index : the index for which key you want to remove. 
	 */
	public synchronized void trimAt(int index){
		K id = keyList.remove(index); 
		cacheMap.remove(id); 
	}
	
	@Override 
	public synchronized void purge(){
		cacheMap.clear();
		keyList.clear();
	}
}
