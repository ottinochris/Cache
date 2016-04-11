import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Very simple testing class for various implementations of caches. 
 * @author ChrisOttino
 *
 */
public class CacheTesting {

	@Test
	public void TestLRUCache() {
		// ReplacePolicy LRU = new LeastRecentlyUsed(2);
		Cache<String, Integer> myCache = new LRUCache<String, Integer>(2);

		Cacheable<String,Integer> item1 = new CacheItem<String, Integer>("Chris", 23);
		Cacheable<String,Integer> item2 = new CacheItem<String,Integer>("Kiara", 20);
		Cacheable<String,Integer> item3 = new CacheItem<String,Integer>("Brennan", 25);

		myCache.put(item1);
		myCache.put(item2);
		myCache.get(item1.getID());
		myCache.put(item3);

		// Since one was used more than two it should still be in cache.
		Cacheable<String, Integer> test = myCache.get(item1.getID());
		assertEquals(item1, test);

		// Since this was last added it should replace two who was Least Used.
		test = myCache.get(item3.getID());
		assertEquals(item3, test);

		// Two should not be in cache.
		test = myCache.get(item2.getID());
		assertEquals(null, test);
	}

	@Test
	public void TestMRUCache() {
		// ReplacePolicy LRU = new LeastRecentlyUsed(2);
		Cache<String, Integer> myCache = new MRUCache<String, Integer>(5);

		Cacheable<String, Integer> item1 = new CacheItem<String, Integer>("Chris", 23);
		Cacheable<String, Integer> item2 = new CacheItem<String, Integer>("Kiara", 20);
		Cacheable<String, Integer> item3 = new CacheItem<String, Integer>("Brennan", 25);
		Cacheable<String, Integer> item4 = new CacheItem<String, Integer>("Bob", 26);
		Cacheable<String, Integer> item5 = new CacheItem<String, Integer>("John", 21);
		Cacheable<String, Integer> item6 = new CacheItem<String, Integer>("Sam", 40);

		myCache.put(item1);
		myCache.put(item2);	
		myCache.put(item3);
		myCache.put(item4);
		myCache.put(item5);
	
		myCache.get(item1.getID());
		myCache.put(item6);

		// Since one was accessed most recently it should be deleted. 
		Cacheable<String, Integer> test = myCache.get(item1.getID());
		assertEquals(null, test);

		test = myCache.get(item3.getID());
		assertEquals(item3, test);

		test = myCache.get(item2.getID());
		assertEquals(item2, test);
		
		test = myCache.get(item5.getID());
		assertEquals(item5, test); 
		
		myCache.put(item1);
		
		//Since item 5 was accessed most recently (in above test case) 
		//it will be replaced. 
		test = myCache.get(item5.getID()); 
		assertEquals(null, test); 
	}
	
}
