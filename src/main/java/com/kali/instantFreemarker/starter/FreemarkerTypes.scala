package com.kali.instantFreemarker.starter

/**
  * Created by kalit_000 on 21/02/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}
import java.io._
import java.util._
import freemarker.template._
import java.math.BigDecimal

object FreemarkerTypes {

  def main(args: Array[String]) {

    //--###########################################################################################################
    //--BOILER PLATE CODE START
    //--###########################################################################################################
    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("FreemarkerTypes").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    /*--###########################################################################################################
     Free Marker Config Code
     --String: ${string?html}
     --Number: ${number?c}
     --Date: ${.now?datetime}
     --Complex: ${object}
    --###########################################################################################################*/

    val cfg=new Configuration()
    cfg.setObjectWrapper(new DefaultObjectWrapper())

    cfg.setDirectoryForTemplateLoading(new File("C:/Users/kalit_000/Desktop/FTL_Writer/FreeMarkerBook"))
    cfg.setDefaultEncoding("UTF-8")
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)
    val template = cfg.getTemplate("types.ftl")

    //--###########################################################################################################
    //-- Declare some data

    val model=new HashMap[String,Object]()
    model.put("string","easy & fast")
    model.put("number",new BigDecimal("1234.5678"))
    //model.put("boolean","true")
    model.put("object",Locale.US)

    val file = new FileWriter (new File("C:\\Users\\kalit_000\\Desktop\\FTL_Writer\\FreeMarkerBook\\types.txt"));
    template.process(model, file);

    println("string key value:-%s".format(model.get("string").toString))
    println("number key value:-%s".format(model.get("number").toString))
    println("object key value:-%s".format(model.get("object").toString))

    file.flush();
    file.close();



  }


}
