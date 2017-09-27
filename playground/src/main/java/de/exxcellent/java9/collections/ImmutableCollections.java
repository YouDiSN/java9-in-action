package de.exxcellent.java9.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableCollections {

    /**
     * Create immutable collections on the fly.
     * <b>Note:</b> They do not accept {@code null} or duplicate entries (Set/Map)
     */
    public static void main(String args[]) {
        // 不能为null
        List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 5/*, null*/);
        System.out.println(listOfNumbers);

        // 不能重复
        Set<Integer> setOfNumbers = Set.of(1, 2, 3, 4, 5/*, 1*/);
        System.out.println(setOfNumbers);

        Map<String, String> mapOfString = Map.of("key1", "value1", "key2", "value2");
        System.out.println(mapOfString);

        // key 不能重复
        Map<String, String> moreMapOfString = Map.ofEntries(
                Map.entry("key1", "value1"),
                Map.entry("key2", "value2")/*,
                Map.entry("key1", "value3")*/
        );
        System.out.println(moreMapOfString);
    }

}