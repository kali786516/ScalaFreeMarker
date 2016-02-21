package com.kali.freemarker

/**
  * Created by kalit_000 on 21/02/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}
import freemarker.template.{TemplateExceptionHandler, Configuration};
import java.io._
import java.io._
import scala.collection.JavaConverters._

object SimpleFreeMarker extends App{

  val cfg = new Configuration(Configuration.VERSION_2_3_23)
  cfg.setDirectoryForTemplateLoading(new File("C:/Users/kalit_000/Desktop/FTL_Writer"))
  cfg.setDefaultEncoding("UTF-8")
  cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)
  val template = cfg.getTemplate("test.ftl")

  val out = new StringWriter
  val data = new scala.collection.mutable.HashMap[String, String]

  data("name") = "fred"
  data("age") = "27"
  template.process(data, out)
  println(out.toString)

  val file = new FileWriter (new File("C:\\Users\\kalit_000\\Desktop\\FTL_Writer\\FTL_helloworld.txt"));
  template.process(data, file);
  file.flush();
  file.close();



}
