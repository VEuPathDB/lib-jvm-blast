package org.veupathdb.lib.blast.field;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.veupathdb.lib.blast.consts.Key;

public class Dust
{
  private boolean yes;
  private boolean no;
  private int     level;
  private int     window;
  private int     linker;

  private Dust(boolean yes, boolean no, int level, int window, int linker) {
    this.yes    = yes;
    this.no     = no;
    this.level  = level;
    this.window = window;
    this.linker = linker;
  }

  public boolean isYes() {
    return yes;
  }

  public Dust setYes(boolean yes) {
    this.yes = yes;
    return this;
  }

  public boolean isNo() {
    return no;
  }

  public Dust setNo(boolean no) {
    this.no = no;
    return this;
  }

  public int getLevel() {
    return level;
  }

  public Dust setLevel(int level) {
    this.level = level;
    return this;
  }

  public int getWindow() {
    return window;
  }

  public Dust setWindow(int window) {
    this.window = window;
    return this;
  }

  public int getLinker() {
    return linker;
  }

  public Dust setLinker(int linker) {
    this.linker = linker;
    return this;
  }

  @JsonValue
  public Object toJSONSerializable() {
    if (isYes())
      return "yes";
    if (isNo())
      return "no";
    return new LinkedHashMap<String, Integer>(){{
      put(Key.Level, getLevel());
      put(Key.Window, getWindow());
      put(Key.Linker, getLinker());
    }};
  }

  public static Dust yesDust() {
    return new Dust(true, false, 0, 0, 0);
  }

  public static Dust noDust() {
    return new Dust(false, true, 0, 0, 0);
  }

  public static Dust lwlDust(int level, int window, int linker) {
    return new Dust(false, false, level, window, linker);
  }

  @JsonCreator
  public static Dust fromJSON(JsonNode node) {
    if (node.isTextual()) {
      return switch(node.textValue()) {
        case "yes" -> yesDust();
        case "no" -> noDust();
        default -> throw new IllegalArgumentException();
      };
    }

    if (node.isObject()) {
      if (!node.has(Key.Level) || !node.has(Key.Window) || !node.has(Key.Linker))
        throw new IllegalArgumentException();
      return new Dust(
        false,
        false,
        node.get(Key.Level).intValue(),
        node.get(Key.Window).intValue(),
        node.get(Key.Linker).intValue()
      );
    }

    throw new IllegalArgumentException();
  }
}