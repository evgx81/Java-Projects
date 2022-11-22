# MeasureListsPerformance #
Сравнить производительность ArrayList и LinkedList.  
  
Необходимо написать код, который бы вызывал основные методы коллекций определенное(1000 или 2000, или любое другое) количество раз. При этом должно засекаться время.
  
После этого вывести таблицу с результатами(метод, сколько раз выполнялся, время выполнения).

Количество вызовов метода: 1, 10, 50, 100, 1000, 2000, 10000.  

### Метод add(E e) ###
#### Таблица результатов ####
```
Benchmark                           (N)  Mode  Cnt        Score         Error  Units
TestListsFunctions.arrayListAdd       1  avgt    5    16403,262 ?  129194,090  ns/op
TestListsFunctions.arrayListAdd      10  avgt    5   139906,838 ? 1104663,835  ns/op
TestListsFunctions.arrayListAdd      50  avgt    5   174939,026 ? 1082829,237  ns/op
TestListsFunctions.arrayListAdd     100  avgt    5   119473,689 ?  831796,696  ns/op
TestListsFunctions.arrayListAdd    1000  avgt    5   958537,784 ? 6582835,852  ns/op
TestListsFunctions.arrayListAdd    2000  avgt        174327,911                ns/op
TestListsFunctions.arrayListAdd   10000  avgt        922572,247                ns/op
TestListsFunctions.linkedListAdd      1  avgt    5      351,497 ?      56,040  ns/op
TestListsFunctions.linkedListAdd     10  avgt    5     3627,848 ?    1100,429  ns/op
TestListsFunctions.linkedListAdd     50  avgt    5    18001,318 ?    4443,203  ns/op
TestListsFunctions.linkedListAdd    100  avgt    5    36043,329 ?    6158,212  ns/op
TestListsFunctions.linkedListAdd   1000  avgt    5   379965,849 ?   78584,639  ns/op
TestListsFunctions.linkedListAdd   2000  avgt    5   720505,959 ?  123244,701  ns/op
TestListsFunctions.linkedListAdd  10000  avgt    5  3592500,497 ?  430790,109  ns/op
```
### Метод add(int index, E element) ###
#### Таблица результатов ####
```
Benchmark                                  (N)  Mode  Cnt        Score             Error  Units
TestListsFunctions.arrayListAddByIndex       1  avgt    5      28108,607 ?     24613,288  ns/op
TestListsFunctions.arrayListAddByIndex      10  avgt    5     285289,783 ?    287394,249  ns/op
TestListsFunctions.arrayListAddByIndex      50  avgt    5    1432911,558 ?   1355279,658  ns/op
TestListsFunctions.arrayListAddByIndex     100  avgt    5    3110485,877 ?   2422154,416  ns/op
TestListsFunctions.arrayListAddByIndex    1000  avgt    5   28545053,769 ?  24389242,079  ns/op
TestListsFunctions.arrayListAddByIndex    2000  avgt    5   57646680,847 ?  56394927,873  ns/op
TestListsFunctions.arrayListAddByIndex   10000  avgt    5  298294161,667 ? 272424105,206  ns/op
TestListsFunctions.linkedListAddByIndex      1  avgt    5        329,244 ?        25,585  ns/op
TestListsFunctions.linkedListAddByIndex     10  avgt    5       3386,307 ?       792,955  ns/op
TestListsFunctions.linkedListAddByIndex     50  avgt    5      17939,484 ?      4000,052  ns/op
TestListsFunctions.linkedListAddByIndex    100  avgt    5      38621,976 ?     14505,914  ns/op
TestListsFunctions.linkedListAddByIndex   1000  avgt    5    1067988,220 ?    681438,566  ns/op
TestListsFunctions.linkedListAddByIndex   2000  avgt    5    3687284,051 ?    791410,840  ns/op
TestListsFunctions.linkedListAddByIndex  10000  avgt    5  123979935,556 ? 162678560,045  ns/op
```
### Метод addAll(Collection<? extends E> c) ###
#### Таблица результатов ####
```
Benchmark                              (N)  Mode  Cnt        Score         Error  Units
TestListsFunctions.arrayListAddAll       1  avgt    5       64,763 ?      41,191  ns/op
TestListsFunctions.arrayListAddAll      10  avgt    2      261,788                ns/op
TestListsFunctions.arrayListAddAll      50  avgt    2     1087,311                ns/op
TestListsFunctions.arrayListAddAll     100  avgt    3     3640,976 ?   58828,203  ns/op
TestListsFunctions.arrayListAddAll    1000  avgt    4   115019,106 ? 1119433,093  ns/op
TestListsFunctions.arrayListAddAll    2000  avgt    2    51150,695                ns/op
TestListsFunctions.arrayListAddAll   10000  avgt        210431,962                ns/op
TestListsFunctions.linkedListAddAll      1  avgt    5      206,144 ?     108,571  ns/op
TestListsFunctions.linkedListAddAll     10  avgt    5     1634,409 ?     232,674  ns/op
TestListsFunctions.linkedListAddAll     50  avgt    5     8281,156 ?     740,152  ns/op
TestListsFunctions.linkedListAddAll    100  avgt    5    15827,203 ?    2294,965  ns/op
TestListsFunctions.linkedListAddAll   1000  avgt    5   162837,593 ?   11478,474  ns/op
TestListsFunctions.linkedListAddAll   2000  avgt    5   322172,534 ?   18187,227  ns/op
TestListsFunctions.linkedListAddAll  10000  avgt    5  1625125,026 ?  137288,542  ns/op
```
