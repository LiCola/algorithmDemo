package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by LiCola on 2018/3/12.
 */
public class StringSearchTest {

  @Test
  public void searchViolent() {
    int index = StringSearch.searchViolent("bc", "abc");
    assertEquals(1,index);

    int index1 = StringSearch.searchViolent("ed", "abc");
    assertEquals(-1,index1);
    System.out.println("search not find index:"+index1);
    "内容".indexOf("s");

  }
}