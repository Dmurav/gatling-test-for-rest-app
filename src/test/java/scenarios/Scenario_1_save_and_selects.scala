package scenarios

import cases.Requests._

import io.gatling.core.Predef._

object Scenario_1_save_and_selects {

  def scenario_1() = scenario("First Scenario") // A scenario is a chain of requests and pauses
    .feed(feederCSV("data.csv"))
    .exec(getAllBooks)
    .exec(getAllBooksByName)
    .exec(addBook)
    .exec(getBookById)
}
