/*
 * Copyright 2007  T-Rank AS
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package no.trank.openpipe.solr.analysis;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import junit.framework.TestCase;

import no.trank.openpipe.solr.analysis.io.Base64InputStream;
import no.trank.openpipe.solr.analysis.io.Base64OutputBuffer;
import no.trank.openpipe.solr.util.IOUtil;

/**
 * @version $Revision$
 */
public class BinaryTokenDeserializerTest extends TestCase {

   public void testSomething() throws Exception {
      Base64OutputBuffer bout = new Base64OutputBuffer();
      BinaryIO.writeHeader(bout, true);
      OutputStream out = new DeflaterOutputStream(bout);
      IOUtil.writeUTF(out, "Dette er en test");
      out.close();
//      InputStream in = new Base64InputStream(bout.toString());
      InputStream in = new Base64InputStream("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");
      final boolean compressed = BinaryIO.readHeaderIsCompressed(in);
      if (compressed) {
         in = new InflaterInputStream(in);
      }
      final String text = IOUtil.readUTF(in);
//      System.out.println(text);
//      assertEquals("Dette er en test", text);
   }
}
