package tech.mlsql.app_runtime.plugin

import tech.mlsql.app_runtime.example.action.ExampleAction
import tech.mlsql.serviceframework.platform.{AppRuntimeStore, Plugin, PluginItem, PluginLoader}

class PluginDesc extends Plugin {
  override def entries: List[PluginItem] = {
    List(ExampleAction.plugin)
  }

  def registerForTest() = {
    val pluginLoader = PluginLoader(Thread.currentThread().getContextClassLoader, this)
    entries.foreach { item =>
      AppRuntimeStore.store.registerAction(item.name, item.clzzName, pluginLoader)
    }
  }
}
