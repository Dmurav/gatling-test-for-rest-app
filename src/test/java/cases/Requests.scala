package cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder


object Requests {

  def feederCSV(path: String): BatchableFeederBuilder[String]#F = {
    val f = csv(path).random
    return f
  }

  def getAllBooks = {
    exec(
      http("get all books")
        .get("/api/v1/book")
        .header("Accept", "application/json")
        .check(status.is(200))
        .check()
    )
      .pause(1)
  }

  def getAllBooksByName = {
    exec(
      http("get all books by name")
        .get("/api/v1/book")
        .queryParam("name", "Java")
        .header("Accept", "application/json")
        .check(status.is(200))
    )
      .pause(1)
  }

  def getBookById = {
    exec(
      http("get book by id")
        .get("/api/v1/book/${id}")
        .check(status.is(200))
    )
      .pause(2)
  }

  def addBook = {
    exec(
      http("save book")
      .post("/api/v1/book/add")
        .check(status.is(200))
        .body(StringBody("""{
                           "name": "${name}",
                           "author": "${author}",
                           "free": ${free}
                       } """)).asJson)
      .pause(1)
  }

  def deleteBookById = {
    exec(
      http("delete book by id")
        .delete("/api/v1/book/${id}")
    .check(status.is(200))
    )
  }

  def findByUse = {
    exec(
      http("find free books")
      .get("/api/v1/book/free")
      .header("Accept", "application/json")
      .check(status.is(200))
    )
  }

  // для экспериментов с сессией
  def debag_case = {
    exec {
      session => session.set("name", "Dima")
    }
  }
    .exec {
      session => println(session("name").as[String])
        session
    }

}
