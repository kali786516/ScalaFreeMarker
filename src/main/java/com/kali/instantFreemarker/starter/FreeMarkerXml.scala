package com.kali.instantFreemarker.starter

/**
  * Created by kalit_000 on 22/02/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}
import java.io._
import java.util._
import freemarker.template._
import java.math.BigDecimal
import freemarker.template.Configuration;
import java.io.OutputStreamWriter;
import java.io.File;
import freemarker.template.Template;

object FreeMarkerXml {

  def main(args: Array[String]) {

    /*--###########################################################################################################
    --BOILER PLATE CODE START
    --###########################################################################################################*/
    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("FreeMarkerXML").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    /*--###########################################################################################################
    Free Marker Config Code
    To: ${recipient.name}
    ${recipient.address}
    Dear ${recipient.name},
   --###########################################################################################################*/
    val cfg=new Configuration()
    cfg.setObjectWrapper(new DefaultObjectWrapper())

    cfg.setDirectoryForTemplateLoading(new File("C:/Users/kalit_000/Desktop/FTL_Writer/FreeMarkerBook"))
    cfg.setDefaultEncoding("UTF-8")
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)
    val template = cfg.getTemplate("example3.ftl")
    val sourcefile = new File("C:\\Users\\kalit_000\\Desktop\\FTL_Writer\\FreeMarkerBook\\example3.xml");

    //--###########################################################################################################
    //-- Declare some data

    val tree=new HashMap[String,Object]()
    tree.put("doc", freemarker.ext.dom.NodeModel.parse(sourcefile));

    val outputfile = new FileWriter (new File("C:\\Users\\kalit_000\\Desktop\\FTL_Writer\\FreeMarkerBook\\xml_output.txt"));
    template.process(tree, outputfile);

    outputfile.flush();
    outputfile.close();


  }
}
