/** 
 * <p>Title: TestSolr.java</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年5月1日 下午4:34:12</p>
 * @version 1.0
 */
package cn.e3mall.solrClentTest;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * solr测试类
 * <p>Title: TestSolr</p>
 * <p>@author WangLei </p>
 * <p>@date 2019年5月1日 下午4:34:12</p>
 * @version 1.0
 */
public class TestSolr {
	
	/**
	 * 添加文档
	 * <p>Title: addDocument</p>
	 * <p>@date 2019年5月1日 下午4:37:37</p>
	 * @throws Exception
	 */
	@Test
	public void addDocument() throws Exception {
		// 第一步：把solrJ的jar包添加到工程中。
		// 第二步：创建一个SolrServer，使用HttpSolrServer创建对象。
		SolrServer solrServer = new HttpSolrServer("http://192.168.230.4:8080/solr/collection1");
		// 第三步：创建一个文档对象SolrInputDocument对象。
		SolrInputDocument document = new SolrInputDocument();
		// 第四步：向文档中添加域。必须有id域，域的名称必须在schema.xml中定义。
		document.addField("id", "test001");
		document.addField("item_title", "测试商品");
		document.addField("item_price", "199");
		// 第五步：把文档添加到索引库中。
		solrServer.add(document);
		// 第六步：提交。
		solrServer.commit();
	}

	/**
	 * 根据id,删除文档
	 * <p>Title: deleteDocumentById</p>
	 * <p>@date 2019年5月1日 下午4:37:50</p>
	 * @throws Exception
	 */
	@Test
	public void deleteDocumentById() throws Exception {
		// 第一步：创建一个SolrServer对象。
		SolrServer solrServer = new HttpSolrServer("http://192.168.230.4:8080/solr/collection1");
		// 第二步：调用SolrServer对象的根据id删除的方法。
		solrServer.deleteById("change.me");
		// 第三步：提交。
		solrServer.commit();
	}
	
	/**
	 * 根据查询删除
	 * <p>Title: deleteDocumentByQuery</p>
	 * <p>@date 2019年5月1日 下午4:39:24</p>
	 * @throws Exception
	 */
	@Test
	public void deleteDocumentByQuery() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://192.168.230.4:8080/solr/collection1");
		solrServer.deleteByQuery("item_title:测试商品");
		solrServer.commit();
	}

	/**
	 * 简单查询
	 * <p>Title: queryDocument</p>
	 * <p>@date 2019年5月1日 下午4:50:03</p>
	 * @throws Exception
	 */
	@Test
	public void queryDocument() throws Exception {
		// 第一步：创建一个SolrServer对象
		SolrServer solrServer = new HttpSolrServer("http://192.168.230.4:8080/solr/collection1");
		// 第二步：创建一个SolrQuery对象。
		SolrQuery query = new SolrQuery();
		// 第三步：向SolrQuery中添加查询条件、过滤条件。。。
		query.setQuery("*:*");
		// 第四步：执行查询。得到一个Response对象。
		QueryResponse response = solrServer.query(query);
		// 第五步：取查询结果。
		SolrDocumentList solrDocumentList = response.getResults();
		System.out.println("查询结果的总记录数：" + solrDocumentList.getNumFound());
		// 第六步：遍历结果并打印。
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_price"));
		}
	}
	
	/**
	 * 带高亮显示
	 * <p>Title: queryDocumentWithHighLighting</p>
	 * <p>@date 2019年5月1日 下午4:51:30</p>
	 * @throws Exception
	 */
	@Test
	public void queryDocumentWithHighLighting() throws Exception {
		// 第一步：创建一个SolrServer对象
		SolrServer solrServer = new HttpSolrServer("http://192.168.230.4:8080/solr/collection1");
		// 第二步：创建一个SolrQuery对象。
		SolrQuery query = new SolrQuery();
		// 第三步：向SolrQuery中添加查询条件、过滤条件。。。
		query.setQuery("测试");
		//指定默认搜索域
		query.set("df", "item_keywords");
		//开启高亮显示
		query.setHighlight(true);
		//高亮显示的域
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em>");
		query.setHighlightSimplePost("</em>");
		// 第四步：执行查询。得到一个Response对象。
		QueryResponse response = solrServer.query(query);
		// 第五步：取查询结果。
		SolrDocumentList solrDocumentList = response.getResults();
		System.out.println("查询结果的总记录数：" + solrDocumentList.getNumFound());
		// 第六步：遍历结果并打印。
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			//取高亮显示
			Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
			String itemTitle = null;
			if (list != null && list.size() > 0) {
				itemTitle = list.get(0);
			} else {
				itemTitle = (String) solrDocument.get("item_title");
			}
			System.out.println(itemTitle);
			System.out.println(solrDocument.get("item_price"));
		}
	}


}
