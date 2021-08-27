package mongo

import com.mongodb.client.{FindIterable, MongoCollection, MongoCursor, MongoDatabase}
import com.mongodb.{MongoClient, MongoCredential, ServerAddress}
import org.bson.Document

import java.util

object MondoDBtoES {
  def main(args: Array[String]): Unit = {
    //初始化和连接
    try {
      //两个变量分别为服务器地址和端口
      val serverAddress: ServerAddress = new ServerAddress("47.119.120.170", 27017)
      val adds = new util.ArrayList[ServerAddress]()
      adds.add(serverAddress)
      //用户名，连接的数据库名，用户密码
      val credential = MongoCredential.createCredential("root", "admin", "123456".toCharArray)
      val credentials = new util.ArrayList[MongoCredential]()
      credentials.add(credential)
      //通过验证连接到MongoDB客户端
      val mongoClient: MongoClient = new MongoClient(adds, credentials)
      //连接数据库
      val mongoDatabase: MongoDatabase = mongoClient.getDatabase("admin")
      println("Connect MongoDB Successfully!!!")


      val collection: MongoCollection[Document] = mongoDatabase.getCollection("runoob")
      println("已经选中集合runoob")
//      printf(collection.count().toString)
      //检索所有文档
      //获取迭代器
      val findInterable: FindIterable[Document] = collection.find()
      //获取游标
      val mongoCursor: MongoCursor[Document] = findInterable.iterator()
      //开始遍历
      while (mongoCursor.hasNext) {
        println(mongoCursor.next())
      }


    } catch {
      case e: Exception =>
        println(e.getClass.getName + ": " + e.getMessage)
    }
  }

}
