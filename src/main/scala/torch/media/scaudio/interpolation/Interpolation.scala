package torch.media.scaudio.interpolation

package torch.media.scaudio.sample.Channel

trait Interpolation {
	def overshot(pitch:Double):Int
	def interpolate(buffer:Channel, frame:Double, pitch:Double):Float
}
