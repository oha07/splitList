
package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 * @author Ramo
 */
public class Split {
    
    public static List<List<Integer>> split(List<Integer> inputList, int splitSize) throws Exception {
        if (inputList == null || inputList.isEmpty()) {
           return null;
        }
        if (splitSize <1) {
           throw new Exception("le paramètre splitSize doit etre superieur ou égale à 1");
        }
        
        final AtomicInteger counter = new AtomicInteger(0);

        final List<List<Integer>> partitioned = inputList.stream()
                .collect(Collectors.groupingBy(it -> 
                       counter.getAndIncrement() / splitSize
                ))
                .values().stream().collect(Collectors.toCollection((ArrayList::new)));
    
        partitioned.stream().forEach(System.out::println);
        
    return partitioned;
    }
}
