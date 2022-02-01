package tech.mlsql.app_runtime.example.action

import tech.mlsql.app_runtime.db.action.BasicActionProxy
import tech.mlsql.app_runtime.example.PluginDB
import tech.mlsql.common.utils.serder.json.JSONTool
import tech.mlsql.serviceframework.platform.form.{FormParams, Input}
import tech.mlsql.serviceframework.platform.{PluginItem, PluginType}

/**
 * Action logical
 */
class ExampleAction extends BaseAction {

  override def _run(params: Map[String, String]): String = {
    JSONTool.toJsonStr(List(Map("value" -> s"Hello ${params(ExampleAction.Params.ECHO.name)}")))
  }

  override def _help(): String = {
    JSONTool.toJsonStr(FormParams.toForm(ExampleAction.Params).toList.reverse)
  }
}

/**
 * Action Info
 */
object ExampleAction {

  object Params {
    val ECHO = Input("echo", "")
  }

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

  object Config {
    val EXAMPLE_KEY = s"${PluginDB.plugin_name}__config__example"
  }

}
