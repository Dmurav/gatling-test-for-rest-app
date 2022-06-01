package scenarios

import cases.Requests._
import io.gatling.core.Predef._

object Scenario_0_debug {

  def scenario_0() = scenario("Debug Scenario") // A scenario is a chain of requests and pauses
    .feed(feederCSV("data.csv"))
    .exec(getAllBooks)
    .exec(getAllBooksByName)
    .exec(addBook)
    .exec(getBookById)
    //.exec(debag_case)
}
