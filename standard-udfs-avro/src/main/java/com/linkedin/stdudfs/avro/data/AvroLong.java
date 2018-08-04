package com.linkedin.stdudfs.avro.data;

import com.linkedin.stdudfs.api.data.PlatformData;
import com.linkedin.stdudfs.api.data.StdLong;


public class AvroLong implements StdLong, PlatformData {
  private Long _long;

  public AvroLong(Long aLong) {
    _long = aLong;
  }

  @Override
  public long get() {
    return _long;
  }

  @Override
  public Object getUnderlyingData() {
    return _long;
  }

  @Override
  public void setUnderlyingData(Object value) {
    _long = (Long) value;
  }
}
