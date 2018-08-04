package com.linkedin.stdudfs.avro.examples;

import java.util.Arrays;
import org.apache.avro.Schema;
import org.testng.annotations.Test;

import static com.linkedin.stdudfs.avro.common.AssertAvroUdf.*;
import static com.linkedin.stdudfs.avro.common.SchemaFactory.*;


public class TestArrayFillFunctionWrapper {
  @Test
  public void testArrayFill() {
    assertFunction(new ArrayFillFunctionWrapper(), new Schema[]{INTEGER, LONG}, new Object[]{1, 5L},
        Arrays.asList(1, 1, 1, 1, 1));

    assertFunction(new ArrayFillFunctionWrapper(), new Schema[]{STRING, LONG}, new Object[]{"1", 5L},
        Arrays.asList("1", "1", "1", "1", "1"));

    assertFunction(new ArrayFillFunctionWrapper(), new Schema[]{array(INTEGER), LONG},
        new Object[]{Arrays.asList(1), 5L},
        Arrays.asList(Arrays.asList(1), Arrays.asList(1), Arrays.asList(1), Arrays.asList(1), Arrays.asList(1)));

    assertFunction(new ArrayFillFunctionWrapper(), new Schema[]{INTEGER, LONG}, new Object[]{1, 0L}, Arrays.asList());

    assertFunction(new ArrayFillFunctionWrapper(), new Schema[]{INTEGER, LONG}, new Object[]{1, null}, null);

    assertFunction(new ArrayFillFunctionWrapper(), new Schema[]{INTEGER, LONG}, new Object[]{null, 5}, null);
  }
}
