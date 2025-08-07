import sbt.Keys.libraryDependencies

import scala.collection.immutable.Seq

val Version      = "0.1.0"
val ScalaVersion = "3.6.4"
val scrImageVersion = "4.3.0"
lazy val commonSettings = Seq(
  scalaVersion              := ScalaVersion,
  version                   := Version,
  organization              := "codes.mostly",
//  idePackagePrefix          := Some("codes.mostly"),
  javacOptions ++= Seq("-source", "24", "-target", "24"),
  scalacOptions ++= Seq("-Xmax-inlines", "128"),
  scalacOptions ++= Seq("-no-indent", "-rewrite"),
//  dependencyAllowPreRelease := true, // allows seeing pre-releases when running dependencyUpdates,
  libraryDependencies ++= Seq(
    "org.typelevel"      %% "cats-effect"     % "3.5.4",
    "org.typelevel"      %% "log4cats-slf4j"  % "2.7.0",
    "org.typelevel"      %% "spire"           % "0.18.0",
    "org.scodec"         %% "scodec-core"     % "2.3.1",
    "co.fs2"             %% "fs2-core"        % "3.11.0",
    "co.fs2"             %% "fs2-io"          % "3.11.0",
    "co.fs2"             %% "fs2-scodec"      % "3.11.0",
    "io.github.iltotore" %% "iron"            % "2.6.0",
    "org.scala-lang.modules" %% "scala-xml" % "2.4.0",
    "org.scalatest"      %% "scalatest"       % "3.2.19"   % Test,
    "org.scalatestplus"  %% "scalacheck-1-18" % "3.2.19.0" % Test,
    "org.slf4j"           % "slf4j-simple"    % "2.0.16" ,// for now
    "com.sksamuel.scrimage" % "scrimage-core" % scrImageVersion,
    "com.sksamuel.scrimage" % "scrimage-webp" % scrImageVersion,
    ("com.sksamuel.scrimage" %% "scrimage-scala" % scrImageVersion)
      .cross(CrossVersion.for3Use2_13),
//    "org.bytedeco" % "javacv" % "1.5.12" classifier "windows-x86_64",
    "org.bytedeco" % "opencv" % "4.11.0-1.5.12" classifier "windows-x86_64",
    "org.bytedeco" % "ffmpeg" % "7.1.1-1.5.12" classifier "windows-x86_64"
//    "org.bytedeco" % "ffmpeg-platform" % "7.1.1-1.5.12" classifier "windows-x86_64"
//    "org.bytedeco" % "opencv-platform" % "4.11.0-1.5.12"
  )
)

resolvers ++= Seq(
  "image" at "https://artifacts.alfresco.com/nexus/content/repositories/public/"
)
// https://mvnrepository.com/artifact/net.imglib2/imglib2
libraryDependencies += "net.imglib2" % "imglib2" % "7.1.5"
// https://mvnrepository.com/artifact/dev.zio/zio
libraryDependencies += "dev.zio" %% "zio" % "2.1.20"
// https://mvnrepository.com/artifact/dev.zio/zio-nio
libraryDependencies += "dev.zio" %% "zio-nio" % "2.0.2"
// https://mvnrepository.com/artifact/org.bytedeco/javacv
//libraryDependencies += "org.bytedeco" % "javacv" % "1.5.12" classifier "windows-x86_64"
// https://mvnrepository.com/artifact/org.imagemagick/imagemagick-distribution
libraryDependencies += "org.imagemagick" % "imagemagick-distribution" % "7.1.0-16-ci-11"
// https://mvnrepository.com/artifact/org.bytedeco/opencv
//libraryDependencies += "org.bytedeco" % "opencv" % "4.11.0-1.5.12" classifier "windows-x86_64"
// https://mvnrepository.com/artifact/org.bytedeco/opencv-platform
//libraryDependencies += "org.bytedeco" % "opencv-platform" % "4.11.0-1.5.12"
// https://mvnrepository.com/artifact/org.bytedeco/ffmpeg
//libraryDependencies += "org.bytedeco" % "ffmpeg" % "7.1.1-1.5.12" classifier "windows-x86_64"
// https://mvnrepository.com/artifact/org.bytedeco/ffmpeg-platform
//libraryDependencies += "org.bytedeco" % "ffmpeg-platform" % "7.1.1-1.5.12"
// https://mvnrepository.com/artifact/org.scala-lang.modules/scala-xml
//libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.4.0"
lazy val service = (project in file("app"))
  .settings(commonSettings*)
  .settings(
    name := "storch-media",
    libraryDependencies ++= Seq(
      //
    )
  )

//lazy val integration =
//  (project in file("integration"))
//    .dependsOn(service)
//    .settings(commonSettings*)
//    .settings(
//      name           := "Integration Tests",
//      publish / skip := true,
//      libraryDependencies ++= Seq(
//        //
//      )
//    )
//

