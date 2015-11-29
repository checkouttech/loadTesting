import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class HappyPath extends Simulation {


        val httpProtocol = http
                .baseURL("http://192.168.150.110:10001")
                .inferHtmlResources()
                .acceptHeader("application/json")
                .acceptEncodingHeader("gzip, deflate")
                .acceptLanguageHeader("en-US,en;q=0.5")
                .doNotTrackHeader("1")
                .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:42.0) Gecko/20100101 Firefox/42.0")



                          //.addCookie(Cookie("name", "value"))
        //.exec(addCookies("", Cookie("my.domain.com", "cookie_name", cookieValue, "/")))


        val scn = scenario("HappyPath")
                          .exec(http("request_0")
                          .post("/requestdetails")
                          .check(status.is(200))
                          )

        setUp(scn.inject(atOnceUsers(100))).protocols(httpProtocol)

        // setUp(scn.inject( ramp(8000 users) over (2 minutes)    ) ).protocols(httpProtocol)

        // setUp(scn.inject(rampRate(10 usersPerSec) to(100 usersPerSec) during(5 minutes))).protocols(httpProtocol)
}



/*
                          .exec(addCookie(Cookie("name", "value")))
                          .addCookie(Cookie("name", "value"))
*/
/* ramp(8000 users) over (2 minutes)
      .inject(ramp(8000 users) over (2 minutes))

    ConsultProductsScenario.scn
      .inject(rampRate(10 usersPerSec) to(100 usersPerSec) during(5 minutes))
      .protocolConfig(httpConf)
 */


