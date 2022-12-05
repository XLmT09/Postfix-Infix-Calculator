package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import enums.Symbol;
import enums.Type;
import exceptions.BadTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEntry {
  private EntryInterface numEntry;
  private EntryInterface symbolEntry;
  private FactoryEntry fact;
  
  @BeforeEach
  void setup() {
    fact = new FactoryEntry();
    numEntry = fact.createEntry(2.0f);
    symbolEntry = fact.createEntry(Symbol.LEFT_BRACKET);
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
  void tesEntriesOfDifferentTypesArePrintable() {
    assertEquals("2.0", numEntry.toString(), 
        "toString returns float in string format for Entry type NUMBER.");
    assertEquals("(", symbolEntry.toString(), 
        "toString retruns corrosponding enum code for Entry type SYMBOL.");
  }
  

  @Test 
  void testEntriesAreEqual() {
    assertEquals(numEntry.equals(numEntry), true, 
        "Check if Entry is equal to itself.");
    assertEquals(numEntry.equals(fact.createEntry(2.0f)), true, 
        "If Entry is NUMBER type and has the same number value then returns true.");
    assertEquals(symbolEntry.equals(fact.createEntry(Symbol.LEFT_BRACKET)), true, 
        "If Entry has same SYMBOL type and the same Symbol enum then return true.");
  }

  @Test 
  void testEntriesAreNotEqual() {
    assertEquals(numEntry.equals(fact.createEntry(6.0f)), false,
        "return false as Entry float values are different values.");
    assertEquals(symbolEntry.equals(fact.createEntry(Symbol.RIGHT_BRACKET)), false,
        "return false as symbols are different enums.");
    assertEquals(numEntry.equals(symbolEntry), false, 
        "return false as Entry type NUMBER and SYMBOL are different.");
  }
  
  @Test 
  void testEntryHashCode() {
    assertEquals(numEntry.hashCode() == numEntry.hashCode(), true, 
            "return true as they are the same insatnce.");
    assertEquals(numEntry.hashCode() == fact.createEntry(2.0f).hashCode(), true, 
            "return true as they are same class of same values.");
  }
  
}
