
public class CacheItem implements Cacheable{
	
	private Object id; 
	private Object data; 
	
	public CacheItem(Object id, Object data){
		this.id = id; 
		this.data = data; 
	}
	
	@Override
	public Object getID() {
		return id;
	}

	@Override
	public Object getData() {
		return data;
	}
	
}
