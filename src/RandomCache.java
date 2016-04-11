import java.util.concurrent.ThreadLocalRandom;

public class RandomCache<K,V> extends Cache<K,V> {

	public RandomCache(int cacheSize) {
		super(cacheSize);
	}

	@Override
	public void put(Cacheable<K,V> obj) {
		if (cacheMap.size() == cacheSize) {
			int index = ThreadLocalRandom.current().nextInt(0, cacheSize );
			System.out.println(index); 
			this.trimAt(index);
		}
		keyList.addLast(obj.getID());
		cacheMap.put(obj.getID(), obj);
	}

	@Override
	public Cacheable<K,V> get(K id) {
		if(keyList.remove(id)){
			keyList.addFirst(id);
			return cacheMap.get(id); 
		}
		return null;
	}

}
