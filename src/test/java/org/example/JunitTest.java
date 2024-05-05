package org.example;

import org.example.fortest.MyDictionary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class JunitTest {
    @Mock
    List mockedList;
    @Spy
    ArrayList<String> spyList;
    @Captor
    private ArgumentCaptor argCaptor;
    @InjectMocks
    MyDictionary dic = new MyDictionary();
    @Mock
    Map<String, String> wordMap;

    @Test
    public void mockTest() {

        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        assertEquals(0, mockedList.size());
        Mockito.when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

    @Test
    public void spyTest() {
        spyList.add("one");
        spyList.add("two");
        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(spyList.size(), 2);

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(spyList.size(), 100);

    }

    @Test void captorTest() {
        mockedList.add("one");
        Mockito.verify(mockedList).add(argCaptor.capture());
        assertEquals("one", argCaptor.getValue());
    }

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
        assertEquals("aMeaning", dic.getMeaning("aWord"));

    }

}