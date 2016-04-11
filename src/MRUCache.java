/**
 * Implementation of a Cache that uses a Most Recently Used 
 * replacement policy. 
 * @author ChrisOttino
 *
 */
public class MRUCache<K,V> extends Cache<K,V>{

	public MRUCache(int cacheSize) {
		super(cacheSize);
	}

	@Override
	public synchronized void put(Cacheable<K,V> obj) {
		if(cacheMap.size() == cacheSize){
			this.trimHead();
		}
		keyList.addFirst(obj.getID());
		cacheMap.put(obj.getID(), obj);
	}

	@Override
	public synchronized Cacheable<K,V> get(K id) {
		if(keyList.remove(id)){
			keyList.addFirst(id); 
			return cacheMap.get(id);
		}
		return null;
	}

}
