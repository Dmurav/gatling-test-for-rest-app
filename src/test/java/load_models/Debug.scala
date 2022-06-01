package load_models

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.typesafe.config.ConfigFactory
import scenarios.Scenario_0_debug.scenario_0
import scenarios.Scenario_1_save_and_selects.scenario_1


class Debug extends Simulation {

  // Загружаем конфигурационный файл
  val config = ConfigFactory.load("application.conf")

  // Настраиваем протокол
  val httpProtocol = http
    .baseUrl(config.getString("conf.baseUrl")) // Here is the root for all relative URLs

  // Устанавливаем сценарий
  //val scn = scenario_1()
  val scn = scenario_1()

  // Настраиваем модель нагрузки
  setUp(
    scn.inject(
      constantUsersPerSec(1) during (1))
      .protocols(httpProtocol))
}
