name := """play-java-hello-world-tutorial"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.6"

libraryDependencies += guice

libraryDependencies ++= Seq(
  javaWs
)

libraryDependencies += ehcache

libraryDependencies += "co.elastic.clients" % "elasticsearch-java" % "7.15.0"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.11.4"
libraryDependencies += "org.elasticsearch.client" % "elasticsearch-rest-client" % "7.15.0"