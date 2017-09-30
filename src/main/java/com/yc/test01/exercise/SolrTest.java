package com.yc.test01.exercise;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrTest {

	
	@Test
	public void addDocument(){
		
		  //创建连接  
	      SolrServer solrServer = new HttpSolrServer("http://127.0.0.1:8680/solr/");  
	      //创建文档对象  
	      SolrInputDocument doucument= new SolrInputDocument();  
	      doucument.addField("id", "917770");  
	      doucument.addField("item_title", "华为 P6-C00 电信3G手机（粉色） CDMA2000/GSM 双模双待双通");  
	      doucument.addField("item_price", 134900);  
	      //把文档对象写入文档里  
	      try {
			solrServer.add(doucument);
			//提交  
		    solrServer.commit();  
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
	
	
}
