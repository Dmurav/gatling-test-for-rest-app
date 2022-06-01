package load_models

import configs.StabilityConfig._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.Scenario_1_save_and_selects.scenario_1

// Open load model
class Stability extends Simulation {

  val httpProtocol = http
    .baseUrl(baseUrl) // Here is the root for all relative URLs

  // Устанавливаем сценарий
  val scn = scenario_1()

  // Настраиваем модель нагрузки
  setUp(
    scn.inject(
      rampUsersPerSec(0) to intensity.toInt during rampDuration, //разгон
      constantUsersPerSec(intensity.toInt) during stageDuration) // длительность полки
      .protocols(httpProtocol))
    .maxDuration(testDuration) // Длительность теста в секундах = разгон + полка

}