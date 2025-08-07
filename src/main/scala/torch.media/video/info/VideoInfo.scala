package torch.media.video.info

import torch.media.Size

case class VideoInfo(codec: String,
                     width: Int,
                     height: Int,
                     fps: Double,
                     tags: Tags) extends Size {
  override def toString: String = {
    s"VideoInfo(codec: $codec, width: $width, height: $height, fps: $fps, tags: $tags)"
  }
}