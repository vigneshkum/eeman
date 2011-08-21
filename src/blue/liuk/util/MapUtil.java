package blue.liuk.util;

import java.util.Map;

public class MapUtil {
	public static boolean checkUse(Map<?, ?> map, String key) {
		if (map.containsKey(key) && !"".equals(map.get(key).toString())) {
			return true;
		}
		return false;

	}

	public static <K,T> T getValue(Map<K, T> map, K key) {
		if (map.containsKey(key) && !"".equals(map.get(key).toString())) {
			return (T) map.get(key);
		}
		return null;

	}
}