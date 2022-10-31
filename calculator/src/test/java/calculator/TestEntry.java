package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEntry {
  private Entry numEntry;
  private Entry symbolEntry;
  private Entry strEntry;
  
  @BeforeEach
  void setup() {
    numEntry = new Entry(2.0f);
    symbolEntry = new Entry(Symbol.LEFT_BRACKET);
    strEntry = new Entry("2");
  }
  
  @Test
  void testEverySymbolEnumToString() {
    assertEquals("(", Symbol.LEFT_BRACKET.toString());
    assertEquals(")", Symbol.RIGHT_BRACKET.toString());
    assertEquals("*", Symbol.TIMES.toString());
    assertEquals("/", Symbol.DIVIDE.toString());
    assertEquals("+", Symbol.PLUS.toString());
    assertEquals("-", Symbol.MINUS.toString());
    assertEquals("invalid", Symbol.INVALID.toString());
  }
  
  @Test
  void testGetTypeString() {
    assertEquals(Type.STRING, strEntry.getType(),
        "A String Entry instance should have STRING type.");
  }
  
  @Test
  void testEveryTypeEnumToString() {
    assertEquals("num", Type.NUMBER.toString());
    assertEquals("sym", Type.SYMBOL.toString());
    assertEquals("str", Type.STRING.toString());
    assertEquals("invalid", Type.INVALID.toString());
  }
  
  @Test
  void testGetTypeNumber() {
    assertEquals(Type.NUMBER, numEntry.getType(),
        "A Number Entry instance should have Number type.");
  }
  
  @Test
  void testGetTypeSymbol() {
    assertEquals(Type.SYMBOL, symbolEntry.getType(), 
        "A Symbol Entry instance should have SYMBOL type.");
  }
  
  @Test
  void testGetSymbol() {
    assertEquals(Symbol.LEFT_BRACKET, symbolEntry.getSymbol(), 
        "getSymbol method should give same Symbol passed in constructor.");
  }
  
  @Test 
  void testInvalidGetSymboWithlNumType() {
    assertThrows(BadTypeException.class, () -> numEntry.getSymbol(), 
        "You cannot use getSymbol method if entry type NUMBER.");
  }
  
  @Test 
  void testInvalidGetSymbolWithStrType() {
    assertThrows(BadTypeException.class, () -> strEntry.getSymbol(), 
        "You cannot use getSymbol method if entry type is SYMBOL.");
  }

  @Test
  void testGetValue() {
    assertEquals(2.0, numEntry.getValue(), 
        "getValue method should give same number passed in constructor.");
  }
  
  @Test 
  void testInvalidGetValueWithSymbolType() {
    assertThrows(BadTypeException.class, () -> symbolEntry.getValue(), 
        "You cannot use getValue method if entry type is SYMBOL.");
  }
  
  @Test 
  void testInvalidGetValueWithStrType() {
    assertThrows(BadTypeException.class, () -> strEntry.getValue(), 
        "You cannot use getValue method if entry type is STRING.");
  }
  
  @Test 
  void tesEntriesOfDifferentTypesArePrintable() {
    assertEquals("2.0", numEntry.toString(), 
        "toString returns float in string format for Entry type NUMBER.");
    assertEquals("(", symbolEntry.toString(), 
        "toString retruns corrosponding enum code for Entry type SYMBOL.");
    assertEquals("2", strEntry.toString(), 
        "toString method returns str variable for type Entry STRING.");
  }
  

  @Test 
  void testEntriesAreEqual() {
    assertEquals(numEntry.equals(numEntry), true, 
        "Check if Entry is equal to itself.");
    assertEquals(numEntry.equals(new Entry(2.0f)), true, 
        "If Entry is NUMBER type and has the same number value then returns true.");
    assertEquals(symbolEntry.equals(new Entry(Symbol.LEFT_BRACKET)), true, 
        "If Entry has same SYMBOL type and the same Symbol enum then return true.");
    assertEquals(strEntry.equals(new Entry("2")), true, 
        "If Entry has same STRING type and the same str value then return true.");
  }

  @Test 
  void testEntriesAreNotEqual() {
    assertEquals(numEntry.equals(new Entry(6.0f)), false,
        "return false as Entry float values are different values.");
    assertEquals(symbolEntry.equals(new Entry(Symbol.RIGHT_BRACKET)), false,
        "return false as symbols are different enums.");
    assertEquals(strEntry.equals(new Entry("3")), false, 
        "return false as Entry str values are different.");
    assertEquals(numEntry.equals(symbolEntry), false, 
        "return false as Entry type NUMBER and SYMBOL are different.");
    assertEquals(strEntry.equals(numEntry), false, 
        "return false as Entry type STRING and NUMBER are different.");
    assertEquals(strEntry.equals(symbolEntry), false, 
        "return false as Entry type STRING and SYMBOL are different.");
  }
  
  @Test 
  void testEntryHashCode() {
    assertEquals(numEntry.hashCode() == numEntry.hashCode(), true, 
            "return true as they are the same insatnce.");
    assertEquals(numEntry.hashCode() == new Entry(2.0f).hashCode(), true, 
            "return true as they are same class of same values.");
    assertEquals(strEntry.equals(numEntry), false, 
            "return false as Entry types are different.");
  }
  
}
