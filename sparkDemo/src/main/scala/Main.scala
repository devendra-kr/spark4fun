import org.apache.spark.{SparkConf, SparkContext}

object Main {
  def main(args: Array[String]): Unit = {
    getPartnerCount(args(0), args(1), args(2))
  }

  case class StreamHistoryInfo(ipv4: String,av: String, partnerName: String,
  partnerId: Long, analytics_id: String, ipv6: String, sessionId: String,
  time: Long,userId: Long, dataType: String, channelId: Long)

  def getPartnerCount(name: String, filePathIn: String, filePathOut: String) = {
    val conf = new SparkConf().setMaster(name).setAppName("App Name")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val userInfo = sc.textFile(filePathIn)
    val partners = userInfo.map(u => (u.split(",")(0), u.split(",")(1))).reduceByKey(_+_).
      map(i => (i._1 +", " + i._2))
    partners.saveAsTextFile(filePathOut)
  }
}
