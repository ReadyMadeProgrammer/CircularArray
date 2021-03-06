package io.github.ReadyMadeProgrammer

import io.github.ReadyMadeProgrammer.CircularArray.CircularArray
import kotlin.test.*

class CircularArrayTest{
    @Test fun allInOneTest(){
        val array = CircularArray.create<String>(3)
        assertEquals(true,array.isEmpty())
        array.add("First")
        assertEquals(1,array.size)
        array.add("Second")
        array.add("Third")
        assertEquals("First",array.first)
        assertEquals(false,array.add("Forth"))
        assertEquals("Third",array.last)
        array.removeFirst()
        array.add("Forth")
        assertEquals("Second",array.first)
        assertEquals("Forth",array.last)
        assertEquals("Third",array[1])
        assertEquals(true,array.contains("Second"))
        assertEquals(false,array.contains("First"))
        assertEquals(true,array.containsAll(arrayListOf("Second","Forth")))
        assertEquals(false,array.containsAll(arrayListOf("First","Forth")))
        assertEquals(1,array.indexOf("Third"))
        assertEquals(-1,array.indexOf("First"))
        assertEquals(false,array.isEmpty())
        val iterator = array.iterator()
        assertEquals("Second",iterator.next())
        iterator.remove()
        assertEquals("Third",iterator.next())
        assertEquals(true,iterator.hasNext())
        assertEquals("Forth",iterator.next())
        assertEquals(false,iterator.hasNext())
        assertEquals("Third",array.first)
        array.clear()
        assertEquals(true,array.isEmpty())
        assertFails{array.first}
        array.add("1")
        array.add("1")
        array.add("2")
        assertEquals(1,array.lastIndexOf("1"))
        assertEquals(0,array.indexOf("1"))
        assertEquals(-1,array.lastIndexOf("0"))
        array.clear()
        array.add("1")
        array.add("2")
        array.add(1,"0")
        assertSame(array,"1","0","2")
        array.add(1,"0")
        assertSame(array,"1","0","2")
        array.clear()
        array.add("1")
        array.addAll(arrayListOf("1","2"))
        assertSame(array,"1","1","2")
        array.removeLast()
        array.removeLast()
        array.addAll(0,arrayListOf("a","b"))
        assertSame(array,"a","b","1")
        var listIterator = array.listIterator()
        assertFalse(listIterator.hasPrevious())
        assertEquals(0,listIterator.nextIndex())
        assertEquals("a",listIterator.next())
        assertEquals(0,listIterator.previousIndex())
        listIterator.remove()
        assertEquals("b",listIterator.next())
        assertEquals("1",listIterator.next())
        assertFalse(listIterator.hasNext())
        assertFails{listIterator.next()}
        array.clear()
        array.addAll(arrayListOf("1","2","3"))
        val listMidIterator = array.listIterator(1)
        assertEquals("2",listMidIterator.next())
        assertEquals("2",listMidIterator.previous())
        listIterator = array.listIterator()
        array.removeLast()
        listIterator.add("a")
        assertSame(array,"a","1","2")
        listIterator.remove()
        listIterator.add("b")
        assertSame(array,"b","1","2")
        listIterator.set("c")
        assertSame(array,"c","1","2")
        array.remove("1")
        assertSame(array,"c","2")
        assertEquals("c",array.remove())
        array.clear()
        array.addAll(arrayListOf("1","2","1"))
        array.removeAll(arrayListOf("1"))
        assertSame(array,"2")
        array.clear()
        array.add("1")
        array.add("2")
        array.add("3")
        array.retainAll(arrayListOf("2","3"))
        assertSame(array,"2","3")
        array.addFirst("1")
        assertSame(array,"1","2","3")
        assertEquals(arrayListOf("1","2"),array.subList(0,2))
        array.clear()
        array.addAll(arrayListOf("1","2","3"))
        assertEquals("3",array.peekLast())
        assertEquals("1",array.first)
        assertEquals("1",array.element())
        array.removeAt(0)
        assertSame(array,"2","3")
        array.push("1")
        assertSame(array,"1","2","3")
        array.removeLast()
        assertSame(array,"1","2")
        array.addLast("3")
        assertSame(array,"1","2","3")
        array.removeFirst()
        assertSame(array,"2","3")
        array.addFirst("1")
        assertSame(array,"1","2","3")
        array.removeLast()
        assertSame(array,"1","2")
        array.offer("3")
        assertSame(array,"1","2","3")
        assertEquals("1",array.peek())
        val mli = array.descendingIterator()
        for(i in 3 downTo 1) assertEquals(i.toString(),mli.next())
        assertFalse(mli.hasNext())
        mli.remove()
        assertSame(array,"2","3")
        assertEquals("2",array.poll())
        assertSame(array,"3")
        assertEquals("3",array.pollLast())
        assertNull(array.pollLast())
        array.addAll(arrayListOf("2","3"))
        array.offerFirst("1")
        assertSame(array,"1","2","3")
        assertFalse(array.offerFirst("1"))
        assertEquals("1",array.pop())
        assertSame(array,"2","3")
        array.clear()
        array.addAll(arrayListOf("1","2","1"))
        array.removeFirstOccurrence("1")
        assertSame(array,"2","1")
        array.addFirst("1")
        array.removeLastOccurrence("1")
        assertSame(array,"1","2")
    }
    private fun assertSame(real: CircularArray<String>, vararg expected: String){
        for(i in 0 until real.size){
            assertEquals(expected[i],real[i])
        }
    }
}