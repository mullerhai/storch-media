package torch.media

import java.nio.charset.Charset

/** I am aware that this is a grab-bag of random stuff */
package object gitch {

  type BitCodec[A] = scodec.Codec[A]

  type FourAsciiChars = String :| Match["""\p{ASCII}{4}"""]

  val asciiCharset: Charset = Charset.forName("ASCII")

  extension (s: String) {
    def toAsciiBits: BitVector = BitVector(s.getBytes(asciiCharset))
  }

}
