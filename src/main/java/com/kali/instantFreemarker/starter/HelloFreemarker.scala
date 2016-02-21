package com.kali.instantFreemarker.starter

/**
  * Created by kalit_000 on 21/02/2016.
  */

import java.util

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}
import java.io._
import java.util._
import freemarker.template._

object HelloFreemarker {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("HelloFreeMarker").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    val cfg=new Configuration()
    cfg.setObjectWrapper(new DefaultObjectWrapper())

    cfg.setDirectoryForTemplateLoading(new File("C:/Users/kalit_000/Desktop/FTL_Writer/FreeMarkerBook"))
    cfg.setDefaultEncoding("UTF-8")
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)
    val template = cfg.getTemplate("hello.ftl")

    val model=new HashMap[String,Object]()
    model.put("name","Kali")
    model.put("penislength","12 Inch")
    model.put("jobname","MIS_RPT_QV_CASH")

    val file = new FileWriter (new File("C:\\Users\\kalit_000\\Desktop\\FTL_Writer\\FreeMarkerBook\\hellokali.txt"));
    template.process(model, file);

    println("name key value:-%s".format(model.get("name").toString))
    println("penislength key value:-%s".format(model.get("penislength").toString))
    println("jobname key value:-%s".format(model.get("jobname").toString))

    file.flush();
    file.close();

  }
}
