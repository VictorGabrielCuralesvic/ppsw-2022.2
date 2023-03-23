package br.upe.ppsw.jabberpoint.controller;

import java.io.IOException;

public abstract class Accessor {

  // atributos
  public static final String DEMO_NAME = "Apresentação de Demonstração";
  public static final String DEFAULT_EXTENSION = ".xml";

  // construtor
  public static Accessor getDemoAccessor() {
    return new DemoPresentation();
  }

  // construtor
  public Accessor() {}

  // métodos
  abstract public void loadFile(Presentation presentation, String fileName) throws IOException;

  abstract public void saveFile(Presentation presentation, String fileName) throws IOException;

}
