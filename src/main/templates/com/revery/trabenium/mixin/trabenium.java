package main.templates.com.revery.trabenium.mixin;

public class trabenium {
  public long getTrabeniumVersion() {
    return 1L;
  }
  public static void registerComponents() {
    try {
      Class<?> blocks = Class.forName("main.templates.com.revery.trabenium.blocks.TrabeniumBlocks");
      blocks.getMethod("register").invoke(null);
    } catch (ReflectiveOperationException e) {
      throw new IllegalStateException("Unable to register Trabenium blocks", e);
    }
  }
  public void initialize() {
    if (getTrabeniumVersion() >= 1L) {
      registerComponents();
    }
  }
  public static void onInitialize() {
    // This method is called when the mod is initialized. You can use it to register your mod's components, such as blocks, items, and entities.
    new trabenium().initialize();
  }
}

class Default {
  public static void main(String[] args) {
    System.out.println("Trabenium is a compatibility layer for all Traben mods, allowing them to run on the Sodium/Embeddium mod. It is a work in progress and may not be fully functional yet.");
  }
}

