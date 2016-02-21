package com.kali.freemarker

/**
  * Created by kalit_000 on 21/02/2016.
  */

import java.util
//import org.apache.log4j.{Level, Logger}
//import org.apache.spark.{SparkContext, SparkConf}
import java.io._;
import freemarker.template.Configuration;
import java.io._
import java.util._
import freemarker.template._
import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer

import scala.collection.mutable.ArrayBuffer;


object FreeMarkerFirst extends  App{

  //def main(args: Array[String]) {

    //Logger.getLogger("org").setLevel(Level.WARN)
    //Logger.getLogger("akka").setLevel(Level.WARN)

    //val conf = new SparkConf().setMaster("local[*]").setAppName("FreeMarker_App").set("spark.hadoop.validateOutputSpecs", "false")
    //val sc = new SparkContext(conf)
/*
    val cfg = new Configuration

      cfg.setDirectoryForTemplateLoading(new File("C:/Users/kalit_000/Desktop/FTL_Writer"));
      val template = cfg.getTemplate("helloworld.ftl")

      //val data = scala.collection.mutable.HashMap[String, String]
      val data = scala.collection.mutable.HashMap[String,Object]()
      data += ("message" -> "Hello, world!")


      var countries = new ArrayBuffer[String]()
      countries += ("India")
      countries += ("United States")
      countries += ("Germany")
      countries += ("France")

      data.put("countries", countries)

      println(data)


      // write to string
      val output = new StringWriter
      template.process(data, output)
      println(output.toString)


      //val stringResult = output.toString
      // do whatever you want/need to do with the string here ...
      // File output
      val file = new FileWriter (new File("C:\\Users\\kalit_000\\Desktop\\FTL_Writer\\testresult.txt"));
      template.process(data, file);
      file.flush();
      file.close();
      //println(stringResult)


  //}
  */

}
