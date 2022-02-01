package tech.mlsql.app_runtime.example.action

import tech.mlsql.common.utils.serder.json.JSONTool
import tech.mlsql.serviceframework.platform.action.{ActionContext, CustomAction}
import tech.mlsql.serviceframework.platform.form.Input

abstract class BaseAction extends CustomAction {
  override def run(params: Map[String, String]): String = {
    if (params.contains(BaseAction.Params.HELP.name)) {
      _help()
    }
    else {
      _run(params)
    }
  }

  def _run(params: Map[String, String]): String

  def _help(): String

  def render(status: Int, content: String): String = {
    val context = ActionContext.context()
    render(context.httpContext.response, status, content)
    ""
  }

  def renderEmpty(): String = {
    render(200, JSONTool.toJsonStr(List(Map())))
    ""
  }


  def paramEmptyAsNone(params: Map[String, String], name: String) = {
    params.get(name) match {
      case Some(value) => if (value.isEmpty) None else Some(value)
      case None => None
    }
  }
}

object BaseAction {

  object Params {
    val HELP = Input("__HELP__", "")
    val ADMIN_TOKEN = Input("admin_token", "")
  }

}
