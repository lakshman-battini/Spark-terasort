import sbt._

object Dependencies {
  val resolutionRepos = Seq(
    "Akka Repository" at "http://repo.akka.io/releases/",
    "Spray Repository" at "http://repo.spray.cc/",
    "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
  )

  object V {
    val spark     = "2.2.0"
    val specs2    = "2.4.17" // -> "1.13" when we bump to Scala 2.10.0
    val guava     = "14.0.1"
    val hadoop    = "2.7.0"
    // Add versions for your additional libraries here...
  }

  object Libraries {
    val sparkCore    = "org.apache.spark"           %% "spark-core"            % V.spark   % "provided"
    val hadoopClient = "org.apache.hadoop"          % "hadoop-client"          % V.hadoop  % "provided"
    val guava        = "com.google.guava"           % "guava"                  % V.guava

    // Scala for test only
    val specs2       = "org.specs2"                 %% "specs2"           % V.specs2       % "test"
  }
}