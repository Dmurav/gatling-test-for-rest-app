package load_models

import configs.MaxPerfConfig._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.Scenario_1_save_and_selects.scenario_1

// Open load model
class MaxPerf extends Simulation {

  val httpProtocol = http
    .baseUrl(baseUrl) // Here is the root for all relative URLs

  // Устанавливаем сценарий
  val scn = scenario_1()

  // Настраиваем модель нагрузки
  setUp(
    scn.inject(incrementUsersPerSec((intensity / stagesNumber).toInt) // интенсивность на ступень
      .times(stagesNumber) // Количество ступеней
      .eachLevelLasting(stageDuration) // Длительность полки в секундах
      .separatedByRampsLasting(rampDuration) // Длительность разгона в секундах
      .startingFrom(0)) // Начало нагрузки с )
      .protocols(httpProtocol))
    .maxDuration(testDuration) // Длительность теста в секундах

}

