package tech.mlsql.app_runtime.example.action

import tech.mlsql.app_runtime.db.action.BasicActionProxy
import tech.mlsql.app_runtime.example.PluginDB
import tech.mlsql.serviceframework.platform.action.CustomAction
import tech.mlsql.serviceframework.platform.{PluginItem, PluginType}

/**
 * 21/1/2020 WilliamZhu(allwefantasy@gmail.com)
 */
class ExampleAction extends CustomAction {
  override def run(params: Map[String, String]): String = ???
}

object ExampleAction {
  def action = "example"

  def plugin = PluginItem(ExampleAction.action,
    classOf[ExampleAction].getName, PluginType.action, None)
}

object ExampleActionProxy {
  lazy val proxy = new BasicActionProxy(PluginDB.plugin_name)
}
