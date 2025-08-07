package torch.media.gitch

case object Application {

  def run[F[_]: Applicative: LoggerFactory]: F[ExitCode] = {
    val log: Logger[F] = LoggerFactory[F].getLogger
    for {
      _ <- log.info("App running")
    } yield ExitCode.Success
  }

}
