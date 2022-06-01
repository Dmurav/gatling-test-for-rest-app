package configs

import com.typesafe.config.{Config, ConfigFactory}

object MaxPerfConfig {

  val maxPerfConfig: Config = ConfigFactory.load("application.conf")

  val baseUrl: String = maxPerfConfig.getString("conf.baseUrl")

  val stagesNumber: Int = maxPerfConfig.getInt("maxPerf.stagesNumber")

  val stageDuration: Int = maxPerfConfig.getInt("maxPerf.stageDuration")

  val intensity: Int = maxPerfConfig.getInt("maxPerf.intensity")

  val rampDuration: Int = maxPerfConfig.getInt("maxPerf.rampDuration")

  val testDuration: Int = maxPerfConfig.getInt("maxPerf.testDuration")

}
