import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.junit.Test;
import utils.MongoDBUtil;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Kevin
 * @Date: 2021/8/27 15:13
 * @Description:
 */
public class Testing {
    //获取数据库连接对象
    private static MongoDatabase mongoDatabase = MongoDBUtil.getConnect2();

    //插入一个文档
    @Test
    public void insertOneTest(){

        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //要插入的数据
        Document document = new Document("name","李白")
                .append("sex", "男")
                .append("age", 22);
        //插入一个文档
        collection.insertOne(document);
    }

    //插入多个文档
    @Test
    public void insertManyTest(){
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //要插入的数据
        List<Document> list = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            Document document = new Document("name", "kevin")
                    .append("sex", "男")
                    .append("age", 18);
            list.add(document);
        }
        collection.insertMany(list);
    }

    //删除与筛选器匹配的单个文档
    @Test
    public void deleteOneTest(){
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //申明删除条件
        Bson filter = Filters.eq("age",18);
        //删除与筛选器匹配的单个文档
        collection.deleteOne(filter);
    }

    //修改多个文档
    @Test
    public void updateManyTest(){
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //修改过滤器
        Bson filter = Filters.eq("name", "李白");
        //指定修改的更新文档
        Document document = new Document("$set", new Document("age", 100));
        //修改多个文档
        collection.updateMany(filter, document);
    }

    //查找集合中的所有文档
    @Test
    public void findTestALl(){
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //查找集合中的所有文档
        FindIterable findIterable = collection.find();
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    //指定查询过滤器查询
    @Test
    public void FilterfindTest(){
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //指定查询过滤器
        Bson filter = Filters.eq("name", "kevin");
        //指定查询过滤器查询
        FindIterable findIterable = collection.find(filter);
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    //取出查询到的第一个文档
    @Test
    public void findTest(){
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        //查找集合中的所有文档
        FindIterable findIterable = collection.find();
        //取出查询到的第一个文档
        Document document = (Document) findIterable.first();
        //打印输出
        System.out.println(document);
    }

}