package com.openlane.pipelinepoc.stress

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

import com.openlane.pipelinepoc.stress.Constants._

class StatusPageStressSimulation extends Simulation {

  val url = sys.env(StatusPageUrlEnvVar)

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
    .pause(1 second) // 10
              
  setUp(
    scn.inject(
      rampUsersPerSec(1) to 100 during(10 seconds),
      constantUsersPerSec(100) during (10 seconds)
    )
  ).protocols(httpConf)
    .assertions(
      global.successfulRequests.percent.greaterThan(99))
}