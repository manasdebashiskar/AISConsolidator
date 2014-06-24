    import sbt._
    import Keys._
    import akka.sbt.AkkaKernelPlugin
    import akka.sbt.AkkaKernelPlugin.{ Dist, outputDirectory, distJvmOptions}
     
    object AISConsolidatorBuild extends Build {
    val Organization = "akka.sample"
    val Version = "1.0-SNAPSHOT"
    val ScalaVersion = "2.10.4"
     
    lazy val AISConsolidator = Project(
    id = "AISConsolidator",
    base = file("AISConsolidator"),
    settings = defaultSettings ++ AkkaKernelPlugin.distSettings ++ Seq(
    libraryDependencies ++= Dependencies.AISConsolidator,
    distJvmOptions in Dist := "-Xms256M -Xmx1024M",
    outputDirectory in Dist := file("target/AISConsolidator-dist"),
    resolvers ++= Seq("Akka Repository" at "http://repo.akka.io/releases/",
                      "cloudera repo" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
                      "haddop repo" at "https://repository.cloudera.com/content/repositories/releases/",
                      "scala tools" at "http://scala-tools.org/repo-releases"
                     )
    )
    )
     
    lazy val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := Organization,
    version := Version,
    scalaVersion := ScalaVersion,
    crossPaths := false,
    organizationName := "example",
    organizationHomepage := Some(url("http://www.example.com"))
    )
    lazy val defaultSettings = buildSettings ++ Seq(
    // compile options
    scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked"),
    javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")
     
    )
    }
     
    object Dependencies {
    import Dependency._
     
    val AISConsolidator = Seq(
    akkaKernel, akkaSlf4j, logback, sparkCore, sparkStreaming, akkaActor, akkaRemote,
    akkaLogging, akkaContrib,scalaTestkit,akkaTestkit, hadoopClient
    )
    }
     
    object Dependency {
    // Versions
    object V {
    val Akka = "2.3.0"
    val scala = "2.10.4" 
    val cloudera = "0.9.0-cdh5.0.0"
    val spark = "1.0.0"
    }
    
    val scalaLib        = "org.scala-lang" %% "scala-library" % V.scala 
    val akkaKernel      = "com.typesafe.akka" %% "akka-kernel" % V.Akka
    val akkaSlf4j       = "com.typesafe.akka" %% "akka-slf4j" % V.Akka
    val logback         = "ch.qos.logback" % "logback-classic" % V.spark
    val sparkCore       = "org.apache.spark" %% "spark-core"% V.spark
    val sparkStreaming  = "org.apache.spark" %% "spark-streaming" % V.spark
    val hadoopClient    = "org.apache.hadoop" % "hadoop-client" % V.cloudera
    val akkaActor       = "com.typesafe.akka"   %% "akka-actor"% V.Akka
    val akkaTestkit     ="com.typesafe.akka"   %% "akka-testkit" % V.Akka % "test"
    val scalaTestkit    = "org.scalatest"       %% "scalatest"    % "2.0"   % "test"
    val akkaRemote      = "com.typesafe.akka"   %% "akka-remote"% V.Akka
    val akkaLogging     = "com.typesafe.akka"   %% "akka-slf4j"% V.Akka
    val akkaContrib     = "com.typesafe.akka"   %% "akka-contrib"% V.Akka
    }



