package tech.mlsql.app_runtime.example.action

import tech.mlsql.app_runtime.commons.FormParams
import tech.mlsql.common.utils.serder.json.JSONTool
import tech.mlsql.serviceframework.platform.{PluginItem, PluginType}


class HelloWorldAction extends BaseAction {
  override def _run(params: Map[String, String]): String = {
    JSONTool.toJsonStr(List(Map("msg" -> "web-platform")))
  }

  override def _help(): String = {
    JSONTool.toJsonStr(FormParams.toForm(ExampleAction.Params).toList.reverse)
  }
}

object HelloWorldAction {

  object Params {

  }

  def action = "hello_world"

  def plugin = PluginItem(action,
    classOf[HelloWorldAction].getName, PluginType.action, None)

}