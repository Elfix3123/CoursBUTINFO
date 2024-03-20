package tp04.dalton;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtilitaire {
	public static void afficheCollection(String message, Collection c) {
		System.out.println(message);
		
		Iterator it = c.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println();
	}
}
