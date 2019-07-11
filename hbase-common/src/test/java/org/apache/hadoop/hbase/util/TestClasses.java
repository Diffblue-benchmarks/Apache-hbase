/*
 * Copyright The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.util;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestClasses {

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  @Test
  public void testExtendedForName() throws ClassNotFoundException {
    Assert.assertEquals(int.class, Classes.extendedForName("int"));
    Assert.assertEquals(long.class, Classes.extendedForName("long"));
    Assert.assertEquals(char.class, Classes.extendedForName("char"));
    Assert.assertEquals(byte.class, Classes.extendedForName("byte"));
    Assert.assertEquals(short.class, Classes.extendedForName("short"));
    Assert.assertEquals(float.class, Classes.extendedForName("float"));
    Assert.assertEquals(double.class, Classes.extendedForName("double"));
    Assert.assertEquals(boolean.class, Classes.extendedForName("boolean"));

    thrown.expect(ClassNotFoundException.class);
    Classes.extendedForName("foo");
  }

  @Test
  public void testStringify() {
    Assert.assertEquals("", Classes.stringify(new Class[0]));
    Assert.assertEquals("NULL", Classes.stringify(null));
    Assert.assertEquals("java.lang.String,java.lang.Integer",
            Classes.stringify(new Class[]{String.class, Integer.class}));
  }
}
