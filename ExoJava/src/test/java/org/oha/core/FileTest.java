package org.oha.core;

import com.Split;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Ramo
 */
public class FileTest {

   

    @Test
    public void test() throws Exception {

        TestCase.assertNull(Split.split(null, 3));
        TestCase.assertNull(Split.split(new ArrayList<>(), 3));
       
       List<Integer> intList = Arrays.asList(1, 2, 3, 0, 4, 5, 6, 0, 7, 8);
           try {
                List<List<Integer>> result = Split.split(intList, 0);
                Assert.fail();
           } catch (Exception e) {
               Assert.assertEquals(e.getMessage(), "le paramètre splitSize doit etre superieur ou égale à 1");
           }
           
        List<List<Integer>> result = Split.split(intList, 3);

        Assert.assertEquals(4, result.size());
        
       List<Integer> s1 = Arrays.asList(1, 2, 3);
       List<Integer> s2 = Arrays.asList(0, 4, 5);
       List<Integer> s3 = Arrays.asList(6, 0, 7);
       List<Integer> s4 = Arrays.asList(8);

        Assert.assertEquals(s1, result.get(0));
        Assert.assertEquals(s2, result.get(1));
        Assert.assertEquals(s3, result.get(2));
        Assert.assertEquals(s4, result.get(3));
    }

}
