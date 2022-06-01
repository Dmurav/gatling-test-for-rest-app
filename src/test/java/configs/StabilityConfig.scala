package configs

import com.typesafe.config.{Config, ConfigFactory}

object StabilityConfig {

    val stabConfig: Config = ConfigFactory.load("application.conf")

    val baseUrl: String = stabConfig.getString("conf.baseUrl")

    val stageDuration: Int = stabConfig.getInt("stability.stageDuration")

    val intensity: Int = stabConfig.getInt("stability.intensity")

    val rampDuration: Int = stabConfig.getInt("stability.rampDuration")

    val testDuration: Int = stabConfig.getInt("stability.testDuration")

}
