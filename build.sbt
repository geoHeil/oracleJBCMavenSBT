name := "oracleProblem"
organization := "foobar"

scalaVersion := "2.11.8"

// credentials += Credentials("WebLogic Server", "login.oracle.com", "asdf5kklwr@gmail.com", "12345678GroßKlein")
credentials += Credentials("OAM 11g", "login.oracle.com", "asdf5kklwr@gmail.com", "12345678GroßKlein")
resolvers += "oracle" at "https://maven.oracle.com"


libraryDependencies ++= Seq(
  "com.oracle.jdbc" % "ojdbc8" % "12.2.0.1"
)

assemblyMergeStrategy in assembly := {
  // TODO bad strategy, find out why below does not work.
  // http://stackoverflow.com/questions/43910006/geotools-jai-fatjar-causing-problems-in-native-dependencies
//  case PathList("com", "esotericsoftware", xs@_*) => MergeStrategy.last
//  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
//  case PathList("META-INF", "LICENSE.txt") => MergeStrategy.discard
//  case PathList("META-INF", "NOTICE.txt") => MergeStrategy.discard
  case PathList("oracle", xs@_*) => MergeStrategy.deduplicate
  case _ => MergeStrategy.first
  //  case PathList("META-INF", xs@_*) =>
  //    xs match {
  //      case ("MANIFEST.MF" :: Nil) => MergeStrategy.discard
  //      case ("NOTICE.txt" :: Nil) => MergeStrategy.discard
  //      case ("LICENSE.txt" :: Nil) => MergeStrategy.discard
  //      case ("NOTES.txt" :: Nil) => MergeStrategy.discard
  // Concatenate everything in the services directory to keep GeoTools happy.
  //      case ("services" :: _ :: Nil) =>
  //        MergeStrategy.concat
  //      // Concatenate these to keep JAI happy.
  //      case ("javax.media.jai.registryFile.jai" :: Nil) | ("registryFile.jai" :: Nil) | ("registryFile.jaiext" :: Nil) =>
  //        MergeStrategy.concat
  //      case (name :: Nil) => {
  //        // Must exclude META-INF/*.([RD]SA|SF) to avoid "Invalid signature file digest for Manifest main attributes" exception.
  //        if (name.endsWith(".RSA") || name.endsWith(".DSA") || name.endsWith(".SF")) {
  //          MergeStrategy.discard
  //        }
  //        else {
  //          MergeStrategy.deduplicate
  //        }
  //      }
  //      case _ => MergeStrategy.first
  //    }
  //  case _ => MergeStrategy.first
}