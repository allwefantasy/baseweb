package tech.mlsql.app_runtime.example.action

import tech.mlsql.app_runtime.db.action.BasicActionProxy
import tech.mlsql.app_runtime.example.PluginDB
import tech.mlsql.serviceframework.platform.action.CustomAction
import tech.mlsql.serviceframework.platform.{PluginItem, PluginType}

/**
 * Action logical
 */
class ExampleAction extends CustomAction {
  override def run(params: Map[String, String]): String = ???
}

/**
 * Action Info
 */
object ExampleAction {
  def action = "example"

  def plugin = PluginItem(ExampleAction.action,
    classOf[ExampleAction].getName, PluginType.action, None)
}

/**
 * The other plugin can use ExampleActionProxy.proxy to call action based on
 * rest. For example:
 * val res = ExampleActionProxy.proxy.run(ExampleAction.action,Map())
 */
object ExampleActionProxy {
  lazy val proxy = new BasicActionProxy(PluginDB.plugin_name)
}

/**
 * The other plugin can use ExampleService to operate the db which
 * belongs to example plugin.
 */
object ExampleService {

}
