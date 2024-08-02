package jetty.web

import org.eclipse.jetty.server.handler.{HandlerList, StatisticsHandler}
import org.eclipse.jetty.server.{HttpConnectionFactory, Server, ServerConnector}
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.util.thread.{QueuedThreadPool, ScheduledExecutorScheduler}

object JettyUtils {

  def startJettyServer(host: String, port: Int, maxThreads: Int = 10, serverName: String): Unit = {
    val pool = new QueuedThreadPool
    pool.setMaxThreads(maxThreads)
    pool.setDaemon(true)
    val server = new Server(pool)

    val httpConnector = new ServerConnector(
      server,
      null,
      new ScheduledExecutorScheduler(s"${serverName}Scheduler", true),
      null,
      -1,
      -1,
      new HttpConnectionFactory())
    httpConnector.setHost(host)
    httpConnector.setPort(port)
    server.setConnectors(Array(httpConnector))

    // handler
    val handlerList = new HandlerList
    val contextHandler = new ServletContextHandler
    contextHandler.setContextPath("/")
    handlerList.addHandler(contextHandler)
    val statisticsHandler = new StatisticsHandler()
    statisticsHandler.setHandler(handlerList)
    server.setHandler(statisticsHandler)

    server.start()
  }

  def setJettyServlet(): Unit = {

  }

}
