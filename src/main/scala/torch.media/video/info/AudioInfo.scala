package torch.media.video.info

case class AudioInfo(codec: String = null, bitRate: Long = 0L, channels: Int, channelLayout: Option[String], tags: Tags) {
  override def toString: String = {
    s"AudioInfo(codec: $codec, bitRate: $bitRate, channels: $channels, channelsLayout: $channelLayout, tags: $tags)"
  }
}