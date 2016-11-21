
import io.gatling.core.Predef._ // 2
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SimpleSimulation extends Simulation {

  val url = sys.env("status_url")

  print( url )

  val httpConf = http // 4
    .baseURL(url) // 5
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("BasicSimulation") // 7
    .exec(http("request_1")  // 8
    .get("/status")) // 9
    .pause(5) // 10
              
  setUp(scn.inject(atOnceUsers(10))).protocols(httpConf)
    .assertions(
      global.successfulRequests.percent.greaterThan(100))
}