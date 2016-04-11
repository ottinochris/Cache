/**
 * An implementation of a Cacheable. Contains only an 
 * id object and data object that are created upon the 
 * instantiation of this object. 
 * @author ChrisOttino
 * @param <V>
 *
 */
public class CacheItem <K, V> implements Cacheable<K,V>{
	
	private K id; 
	private V data; 
	
	public CacheItem(K id, V data){
		this.id = id; 
		this.data = data; 
	}
	
	@Override
	public K getID() {
		return id;
	}

	@Override
	public V getData() {
		return data;
	}
	
}
