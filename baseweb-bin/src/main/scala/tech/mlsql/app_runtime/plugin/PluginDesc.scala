package tech.mlsql.app_runtime.plugin

import tech.mlsql.app_runtime.example.action.{ExampleAction, HelloWorldAction}
import tech.mlsql.serviceframework.platform.{Plugin, PluginItem}

class PluginDesc extends Plugin {
  override def entries: List[PluginItem] = {
    List(ExampleAction.plugin, HelloWorldAction.plugin)
  }
}
